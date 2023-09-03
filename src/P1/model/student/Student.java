package P1.model.student;

import P1.utils.DataTransferObject;

public class Student implements DataTransferObject {
    private int id;
    private String name;
    private int age;
    private float grade;
    private int facultySerialNumber;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getFacultySerialNumber() {
        return facultySerialNumber;
    }

    public void setFacultySerialNumber(int facultySerialNumber) {
        this.facultySerialNumber = facultySerialNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", facultySerialNumber=" + facultySerialNumber +
                '}';
    }
}
