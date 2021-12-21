package org.example.FinalProdject.Dao;

import org.example.FinalProdject.Tabels.CourseTeacher;

import java.util.List;

public interface CourseTeacherDao {
    void add(CourseTeacher courseTeacher);

    void update(CourseTeacher courseTeacher);

    void delete(CourseTeacher courseTeacher);

    List<CourseTeacher> getAll();


}
