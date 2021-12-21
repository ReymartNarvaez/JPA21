package org.example.FinalProdject.Impls;

import org.example.FinalProdject.Dao.CourseDao;
import org.example.FinalProdject.Tabels.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseImpl implements CourseDao {
    EntityManagerFactory emf;
    EntityManager em;

    public CourseImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }


    @Override
    public void add(Course course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void update(Course course) {
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Course course) {
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }

    @Override
    public Course getByID(int courseID) {
        return em.find(Course.class, courseID);
    }

    @Override
    public List<Course> getAll() {
        return em.createQuery("SELECT e FROM Course e", Course.class).getResultList();
    }

    @Override
    public Course getByCourseID(int id) {
        return em.find(Course.class, id);
    }
}
