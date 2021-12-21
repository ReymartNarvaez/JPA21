package org.example.FinalProdject.Tabels;

import org.example.FinalProdject.TableID.CourseTeacherID;

import javax.persistence.*;


@Entity
public class CourseTeacher {

    @EmbeddedId
    CourseTeacherID courseTeacherID;

    public CourseTeacher() {
    }

    public CourseTeacher(Course courseID, Teacher teacherID) {
        courseTeacherID = new CourseTeacherID(courseID, teacherID);
    }


    public CourseTeacherID getCourseTeacherID() {
        return courseTeacherID;
    }

    public CourseTeacher setCourseTeacherID(CourseTeacherID courseTeacherID) {
        this.courseTeacherID = courseTeacherID;
        return this;
    }

    @Override
    public String toString() {
        return "CourseTeacher{" +
                "courseTeacherID=" + courseTeacherID +
                '}';
    }
}
