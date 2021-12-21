package org.example.FinalProdject.Impls;

import org.example.FinalProdject.Dao.TeacherDao;
import org.example.FinalProdject.Tabels.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    EntityManagerFactory emf;
    EntityManager em;

    public TeacherDaoImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }

    @Override
    public void add(Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void update(Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Teacher teacher) {
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
    }

    @Override
    public Teacher getByID(int teacherId) {
        return em.find(Teacher.class, teacherId);
    }

    @Override
    public List<Teacher> getAll() {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public List<Teacher> getByName(String name) {
        TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t WHERE CONCAT(t.firstName, ' ', t.lastName) LIKE :name", Teacher.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }


}
