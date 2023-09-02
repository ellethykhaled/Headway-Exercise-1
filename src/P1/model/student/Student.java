package P1.model.student;

import P1.utils.DataTransferObject;

import java.util.ArrayList;

public class Student implements DataTransferObject {
    private int id;
    private String name;
    private int age;
    private float grade;
    private ArrayList<Integer> departments;
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

    public ArrayList<Integer> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Integer> departments) {
        this.departments = departments;
    }

    public int getFacultySerialNumber() {
        return facultySerialNumber;
    }

    public void setFacultySerialNumber(int facultySerialNumber) {
        this.facultySerialNumber = facultySerialNumber;
    }
}
