package org.example.FinalProdject.Impls;

import org.example.FinalProdject.Dao.StudentDao;
import org.example.FinalProdject.Tabels.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    EntityManagerFactory emf;
    EntityManager em;

    public StudentDaoImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }

    @Override
    public void add(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Student student) {
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    @Override
    public Student getByID(int studentID) {
        return em.find(Student.class, studentID);
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public List<Student> getByName(String name) {
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE CONCAT(s.firstName, ' ', s.lastName) LIKE :name", Student.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
