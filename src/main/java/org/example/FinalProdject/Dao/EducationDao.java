package org.example.FinalProdject.Dao;

import org.example.FinalProdject.Tabels.Education;

import java.util.List;

public interface EducationDao {

    void add(Education education);

    void update(Education education);

    void delete(Education education);

    Education getByID(int id);

    List<Education> getAll();

    List<Education> getByName(String name);
}
