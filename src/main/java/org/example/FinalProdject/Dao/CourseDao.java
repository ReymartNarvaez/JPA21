package org.example.FinalProdject.Dao;

import org.example.FinalProdject.Tabels.Course;

import java.util.List;

public interface CourseDao {
    void add(Course course);

    void update(Course course);

    void delete(Course course);

    Course getByID(int courseID);

    List<Course> getAll();

    Course getByCourseID(int ID);
}
