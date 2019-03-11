package DAO;

import entity.Department;
import entity.Workers;
import org.hibernate.Session;

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
}
