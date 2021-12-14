package org.example.laboration4;

import javax.persistence.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    EntityManagerFactory emf;
    EntityManager em;

    public EmployeeDaoImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }

    @Override
    public void add(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
    }

    @Override
    public void update(Employee employee) {
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Employee employee) {
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
    }

    @Override
    public Employee getByID(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        return em.createQuery("SELECT emp FROM Employee emp", Employee.class).getResultList();
    }

    @Override
    public List<Employee> getByName(String name) {
        TypedQuery<Employee> query = em.createQuery("SELECT emp FROM Employee emp WHERE CONCAT(emp.firstName, ' ', emp.lastName) LIKE :name", Employee.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public List<Employee> getBySalary(int from, int to) {
        TypedQuery<Employee> query = em.createQuery("SELECT emp FROM Employee emp WHERE emp.salary BETWEEN :from AND :to", Employee.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }

    @Override
    public List<Employee> getByAge(int from, int to) {
        TypedQuery<Employee> query = em.createQuery("SELECT emp FROM Employee emp WHERE emp.age BETWEEN :from AND :to", Employee.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getResultList();
    }
}
