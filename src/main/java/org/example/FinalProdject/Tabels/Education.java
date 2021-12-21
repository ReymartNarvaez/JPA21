package org.example.FinalProdject.Tabels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int educationID;
    private String educationName;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Student> studentList;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<Course> courseList;

    public Education() {
    }

    public Education(String educationName) {
        this.educationName = educationName;
    }

    public String getEducationName() {
        return educationName;
    }

    public Education setEducationName(String educationName) {
        this.educationName = educationName;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Education setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public Education setCourseList(List<Course> courseList) {
        this.courseList = courseList;
        return this;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationID=" + educationID +
                ", educationName='" + educationName + '\'' +
                ", studentList=" + studentList +
                ", courseList=" + courseList +
                '}';
    }
}

