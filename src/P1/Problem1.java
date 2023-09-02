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
}
