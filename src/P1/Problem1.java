package P1;

import P1.model.student.Student;
import P1.model.student.StudentDAO;

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void testSelectAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        if (students.size() > 0)
            System.out.println("List of students:");
        else
            System.out.println("No students found");
        for (Student s : students)
            System.out.println(s);
    }

    static void testSelectStudentById(StudentDAO studentDAO, int id) {
        Student student = studentDAO.findById(id);
        if (student.getId() == 0)
            System.out.println("No student found by id " + id);
        else
            System.out.println(student);
    }

    static void testUpdateStudentById(StudentDAO studentDAO, int id) {
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
}
