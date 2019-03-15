package DAO;

import CreateExamples.CreateDepartmentsAndWorkersForTest;
import entity.Department;
import entity.Workers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDAOTest {

    private static Logger log = LogManager.getLogger(WorkersDAOTest.class);

    private static final SessionFactory sessionFactory;
    private Session session;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    @AfterAll
    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    @BeforeEach
    public void startSession() {
        session = sessionFactory.openSession();
    }

    @AfterEach
    public void closeSession() {
        session.beginTransaction();
        List<Workers> workers = session.createQuery("from Workers").list();
        List<Department> departments = session.createQuery("from Department").list();
        for (Workers worker : workers) {
            session.delete(session.load(Workers.class, worker.getId()));
        }
        for (Department department : departments) {
            session.delete(session.load(Department.class, department.getId()));
        }
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void getAllActiveDepartmentsUsingHQLPositive() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Department> departments = departmentDAO.getAllActiveDepartmentsUsingHQL();
        assertEquals(2, departments.size());
    }


    @Test
    void getAllActiveDepartmentsUsingHQLNegative() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Department> departments = departmentDAO.getAllActiveDepartmentsUsingHQL();
        assertNotEquals(false, departments.size()==2);
    }

    @Test
    void getAllActiveDepartmentsUsingCriteriaPositive() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Department> departments = departmentDAO.getAllActiveDepartmentsUsingCriteria();
        assertEquals(2, departments.size());
    }

    @Test
    void getAllActiveDepartmentsUsingCriteriaNegative() {
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Department> departments = departmentDAO.getAllActiveDepartmentsUsingCriteria();
        assertNotEquals(false, departments.size()==2);
    }
}