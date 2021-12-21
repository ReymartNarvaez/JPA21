package org.example.FinalProdject.Impls;

import org.example.FinalProdject.Dao.EducationDao;
import org.example.FinalProdject.Tabels.Education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EducationDaoImpl implements EducationDao {
    EntityManagerFactory emf;
    EntityManager em;

    public EducationDaoImpl() {
        emf = Persistence.createEntityManagerFactory("JPA21");
        em = emf.createEntityManager();
    }

    @Override
    public Education getByID(int id) {
        return em.find(Education.class, id);
    }

    @Override
    public void add(Education education) {
        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();
    }

    @Override
    public void update(Education education) {
        em.getTransaction().begin();
        em.merge(education);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Education education) {
        em.getTransaction().begin();
        em.remove(education);
        em.getTransaction().commit();
    }

    @Override
    public List<Education> getAll() {
        return em.createQuery("SELECT e FROM Education e", Education.class).getResultList();
    }

    @Override
    public List<Education> getByName(String name) {
        TypedQuery<Education> query = em.createQuery("SELECT e FROM Education e WHERE educationName LIKE :name", Education.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }


}
