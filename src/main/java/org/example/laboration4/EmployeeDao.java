package org.example.laboration4;

import java.util.List;

public interface EmployeeDao {

    void add(Employee employee);

    void update(Employee employee);

    void delete(Employee employee);

    Employee getByID(int id);

    List<Employee> getAll();

    List<Employee> getByName(String name);

    List<Employee> getBySalary(int from, int to);

    List<Employee> getByAge(int from, int to);

}
