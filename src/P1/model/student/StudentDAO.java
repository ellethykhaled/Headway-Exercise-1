package P1.model.student;

import P1.utils.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DataAccessObject<Student> {

    private static final String GET_ALL = "SELECT * FROM students";
    private static final String GET_ONE = "SELECT * FROM students WHERE id=?";
    private static final String UPDATE = "UPDATE students SET name=?," +
            " age=?, grade=?, faculty_serial_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM students WHERE id=?";

    public StudentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE)) {
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGrade(rs.getFloat("grade"));
                student.setAge(rs.getInt("age"));
                student.setFacultySerialNumber(rs.getInt("faculty_serial_number"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        ArrayList<Student> list = new ArrayList<>();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ALL)) {
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

    @Override
    public Student update(Student dto) {
        Student student;
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE)) {
            statement.setString(1, dto.getName());
            statement.setInt(2, dto.getAge());
            statement.setFloat(3, dto.getGrade());
            statement.setInt(4, dto.getFacultySerialNumber());
            statement.setInt(5, dto.getId());

            statement.execute();
            student = this.findById(dto.getId());
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public Student create(Student dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
