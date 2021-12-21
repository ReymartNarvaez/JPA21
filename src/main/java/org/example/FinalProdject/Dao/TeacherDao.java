package org.example.FinalProdject.Dao;

import org.example.FinalProdject.Tabels.Teacher;

import java.util.List;

public interface TeacherDao {
    void add(Teacher teacher);

    void update(Teacher teacher);

    void delete(Teacher teacher);

    List<Teacher> getAll();

    List<Teacher> getByName(String name);

    Teacher getByID(int teacherId);

}
