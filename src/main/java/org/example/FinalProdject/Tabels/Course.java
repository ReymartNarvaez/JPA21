package org.example.FinalProdject.Tabels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Education education;
    private String CourseName;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<CourseTeacher> courseTeacher;

    public Course() {
    }

    public Course(String courseName, Education education) {
        this.education = education;
        CourseName = courseName;
    }

    public String getCourseName() {
        return CourseName;
    }

    public Course setCourseName(String courseName) {
        CourseName = courseName;
        return this;
    }

    public Education getEducation(Education newEducationForCourse) {
        return education;
    }

    public Course setEducation(Education education) {
        this.education = education;
        return this;
    }

    public List<CourseTeacher> getCourseTeacher() {
        return courseTeacher;
    }

    public Course setCourseTeacher(List<CourseTeacher> courseTeacher) {
        this.courseTeacher = courseTeacher;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", CourseName='" + CourseName + '\'' +
                ", education=" + education +
                '}';
    }
}
