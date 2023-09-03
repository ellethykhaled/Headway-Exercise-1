package P1;

import P1.model.department.JoinedDAO;
import P1.model.student.Student;
import P1.model.student.StudentDAO;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Problem1 {

    public static void main(String... args) {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();

        try {
            Connection connection = databaseConnectionManager.getConnection();

            StudentDAO studentDAO = new StudentDAO(connection);

            testSelectAllStudents(studentDAO);

            testSelectStudentById(studentDAO, 5);
            testSelectStudentById(studentDAO, -1);

            testUpdateStudentById(studentDAO, 50);
            testUpdateStudentById(studentDAO, -1);

            testDeleteStudentById(studentDAO, 49);
            testSelectAllStudents(studentDAO);
            testDeleteStudentById(studentDAO, -1);

            JoinedDAO joinedDAO = new JoinedDAO(connection);

            testSelectDepartmentStudents(joinedDAO, "HR Department");
            testSelectDepartmentStudents(joinedDAO, "Finance Department");
            testSelectDepartmentStudents(joinedDAO, "IT Department");

            testSelectNoDepartmentStudents(joinedDAO);

            testFindDepartmentsStudentCount(joinedDAO);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void testSelectAllStudents(StudentDAO studentDAO) {
        System.out.println("\nTesting Select All Students");
        List<Student> students = studentDAO.findAll();
        if (students.size() > 0)
            System.out.println("List of students:");
        else
            System.out.println("No students found");
        for (Student s : students)
            System.out.println(s);
    }

    static void testSelectStudentById(StudentDAO studentDAO, int id) {
        System.out.println("\nTesting Select Student By Id");
        Student student = studentDAO.findById(id);
        if (student.getId() == 0)
            System.out.println("No student found by id " + id);
        else
            System.out.println(student);
    }

    static void testUpdateStudentById(StudentDAO studentDAO, int id) {
        System.out.println("\nTesting Update Student By Id");
        Student student = studentDAO.findById(id);
        if (student.getId() == 0) {
            System.out.println("No student found by id " + id);
            return;
        }
        System.out.println("Student info before update");
        System.out.println(student);

        // Just a toggling condition
        if (student.getAge() > 30)
            student.setAge(student.getAge() - 20);
        else
            student.setAge(student.getAge() + 20);

        /* Uncomment the following line to generate unique constraint violation exception **/
//        student.setFacultySerialNumber(149);

        try {
            student = studentDAO.update(student);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to update student info");
            return;
        }
        System.out.println("Student info after update");
        System.out.println(student);
    }

    static void testDeleteStudentById(StudentDAO studentDAO, int id) {
        System.out.println("\nTesting Delete Student By Id");
        studentDAO.delete(id);
    }

    private static void testSelectDepartmentStudents(JoinedDAO joinedDAO, String departmentName) {
        System.out.println("\nTesting Select Department Students");
        List<Student> students = joinedDAO.findDepartmentStudents(departmentName);
        if (students.size() > 0)
            System.out.println("List of students in " + departmentName + ":");
        else
            System.out.println("No students found");
        for (Student s : students)
            System.out.println(s);
    }

    private static void testSelectNoDepartmentStudents(JoinedDAO joinedDAO) {
        System.out.println("\nTesting Select No Department Students");
        List<Student> students = joinedDAO.findNoDepartmentStudents();
        if (students.size() > 0)
            System.out.println("List of students with no department:");
        else
            System.out.println("No students found");
        for (Student s : students)
            System.out.println(s);
    }

    private static void testFindDepartmentsStudentCount(JoinedDAO joinedDAO) {
        System.out.println("\nTesting Select Departments Student Count");
        List<Pair<String, Integer>> departmentsStudentCount = joinedDAO.findDepartmentsStudentCount();
        if (departmentsStudentCount.size() > 0)
            System.out.println("List of departments with students:");
        else
            System.out.println("No students found");
        for (Pair<String, Integer> s : departmentsStudentCount)
            System.out.println(s.getKey() + " contains " + s.getValue() + " students");
    }
}
