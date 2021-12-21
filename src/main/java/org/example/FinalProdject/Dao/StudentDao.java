package org.example.FinalProdject.Dao;

import org.example.FinalProdject.Tabels.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);

    void update(Student student);

    void delete(Student student);

    Student getByID(int studentID);

    List<Student> getAll();

    List<Student> getByName(String name);
}
