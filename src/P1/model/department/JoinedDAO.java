package P1.model.department;

import P1.model.student.Student;
import P1.utils.DataAccessObject;

import javafx.util.Pair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinedDAO extends DataAccessObject {

    private static final String GET_DEPARTMENT_STUDENTS =
            "SELECT * FROM students s INNER JOIN students_departments sd ON s.id = sd.student_id " +
                    "INNER JOIN departments d ON d.id = sd.department_id WHERE d.name = ?";

    private static final String GET_NO_DEPARTMENT_STUDENTS =
            "SELECT * FROM students s LEFT JOIN students_departments sd ON s.id = sd.student_id " +
                    "WHERE sd.student_id IS NULL;";

    private static final String GET_DEPARTMENTS_STUDENT_COUNT =
            "SELECT d.name, COUNT(sd.student_id) FROM departments d " +
                    "INNER JOIN students_departments sd ON d.id = sd.department_id GROUP BY d.name;";

    public JoinedDAO(Connection connection) {
        super(connection);
    }

    public List<Student> findDepartmentStudents(String departmentName) {
        ArrayList<Student> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_DEPARTMENT_STUDENTS)) {
            statement.setString(1, departmentName);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getFloat("grade"));
                student.setAge(rs.getInt("age"));
                student.setFacultySerialNumber(rs.getInt("faculty_serial_number"));

                list.add(student);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Student> findNoDepartmentStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_NO_DEPARTMENT_STUDENTS)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getFloat("grade"));
                student.setAge(rs.getInt("age"));
                student.setFacultySerialNumber(rs.getInt("faculty_serial_number"));

                list.add(student);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public ArrayList<Pair<String, Integer>> findDepartmentsStudentCount() {
        ArrayList<Pair<String, Integer>> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_DEPARTMENTS_STUDENT_COUNT)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int count = rs.getInt("count");
                Pair<String, Integer> pair = new Pair<>(name, count);

                list.add(pair);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}
