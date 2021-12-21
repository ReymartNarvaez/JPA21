package org.example.FinalProdject.TableID;

import org.example.FinalProdject.Tabels.Course;
import org.example.FinalProdject.Tabels.Teacher;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseTeacherID implements Serializable {
    @ManyToOne(targetEntity = Course.class, cascade = CascadeType.REMOVE)
    private Course courseID;
    @ManyToOne(targetEntity = Teacher.class, cascade = CascadeType.REMOVE)
    private Teacher teacherID;

    public CourseTeacherID() {
    }

    public CourseTeacherID(Course courseID, Teacher teacherID) {
        this.courseID = courseID;
        this.teacherID = teacherID;
    }

    public Course getCourseID() {
        return courseID;
    }

    public CourseTeacherID setCourseID(Course courseID) {
        this.courseID = courseID;
        return this;
    }

    public Teacher getTeacherID() {
        return teacherID;
    }

    public CourseTeacherID setTeacherID(Teacher teacherID) {
        this.teacherID = teacherID;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CourseTeacherID)) return false;
        CourseTeacherID courseTeacherID = (CourseTeacherID) obj;
        return Objects.equals(courseID, courseTeacherID.courseID) && Objects.equals(teacherID, courseTeacherID.teacherID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseID, teacherID);
    }
}
