package org.example.FinalProdject.Tabels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int teacherID;
    private String firstName;
    private String lastName;

    @ManyToMany(targetEntity = CourseTeacher.class)
    private List<CourseTeacher> courseTeacher;


    public Teacher() {
    }

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Teacher setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Teacher setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<CourseTeacher> getCourseTeacher() {
        return courseTeacher;
    }

    public Teacher setCourseTeacher(List<CourseTeacher> courseTeacher) {
        this.courseTeacher = courseTeacher;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
