package DAO;

import entity.Department;
import entity.Workers;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements DAOImpl<Department, Integer> {

    private Session session;

    public DepartmentDAO(Session session) {
        this.session = session;
    }

    @Override
    public Department save(Department entity) {
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(Integer integer) {
        session.delete(findById(integer));
    }

    @Override
    public Department findById(Integer integer) {
        return session.load(Department.class, integer);
    }

    @Override
    public List<Department> findAll() {
        return (ArrayList<Department>) session.createQuery("from Department").list();
    }

    public List<Department> getAllActiveDepartmentsUsingHQL() {
        return (List<Department>) session.createQuery("from Department as department where department.status = true").list();
    }

    public List<Department> getAllActiveDepartmentsUsingCriteria() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Department> query = criteriaBuilder.createQuery(Department.class);
        Root<Department> root = query.from(Department.class);
        query.select(root);
        Expression<Boolean> statusExp = root.get("status");
        Predicate statusPredicate = criteriaBuilder.equal(statusExp, new Boolean(true));
        query.where(statusPredicate);
        return session.createQuery(query).getResultList();

    }

}
