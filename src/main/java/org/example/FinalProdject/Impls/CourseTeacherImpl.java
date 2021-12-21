package org.example.FinalProdject.Impls;

import org.example.FinalProdject.Dao.CourseTeacherDao;
import org.example.FinalProdject.Tabels.CourseTeacher;

import javax.persistence.*;
import java.util.List;

public class CourseTeacherImpl implements CourseTeacherDao {
    EntityManagerFactory emf;
    EntityManager em;

    public CourseTeacherImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }

    @Override
    public void add(CourseTeacher courseTeacher) {
        em.getTransaction().begin();
        em.persist(courseTeacher);
        em.getTransaction().commit();
    }

    @Override
    public void update(CourseTeacher courseTeacher) {
        em.getTransaction().begin();
        em.merge(courseTeacher);
        em.getTransaction().commit();
    }

    @Override
    public void delete(CourseTeacher courseTeacher) {
        em.getTransaction().begin();
        em.remove(courseTeacher);
        em.getTransaction().commit();
    }

    @Override
    public List<CourseTeacher> getAll() {
        return em.createQuery("SELECT ct FROM CourseTeacher ct", CourseTeacher.class).getResultList();
    }

}
