package DAO;

import entity.Availability;
import entity.Department;
import entity.Workers;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.query.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class WorkersDAO implements DAOImpl<Workers,Integer> {

    private Session session;

    public WorkersDAO(Session session) {
        this.session = session;
    }

    @Override
    public Workers save(Workers entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(Integer integer) {
        session.delete(findById(integer));
    }

    @Override
    public Workers findById(Integer integer) {
        return session.load(Workers.class, integer);
    }

    @Override
    public List<Workers> findAll() {
        return (ArrayList<Workers>) session.createQuery("from Workers").list();
    }

    public List<Workers> getWorkersByDepartmentIdAndAvialiabilityUsingHQL(Integer id, Availability availability) {
        Query query = session.createQuery("from Workers w where w.departmentId.id = :id and w.availability = :availability");
        query.setParameter("id", id);
        query.setParameter("availability", availability);
        return query.list();
    }

    public List<Workers> getWorkersByDepartmentIdAndAvialiabilityUsingCriteria(Integer id, Availability availability) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Workers> query = criteriaBuilder.createQuery(Workers.class);
        Root<Workers> root = query.from(Workers.class);
        query.select(root);
        Expression<Availability> availabilityExp = root.get("availability");
        Predicate availabilityPredicate = criteriaBuilder.equal(availabilityExp, availability);
        Expression<Integer> departmentIdExp = root.get("departmentId");
        Predicate departmentIdPredicate = criteriaBuilder.equal(departmentIdExp, id);
        Predicate all = criteriaBuilder.and(availabilityPredicate, departmentIdPredicate);
        query.where(all);
        return session.createQuery(query).getResultList();
    }
}
