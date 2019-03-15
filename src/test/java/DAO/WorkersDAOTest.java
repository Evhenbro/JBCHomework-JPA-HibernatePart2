package DAO;

import CreateExamples.CreateDepartmentsAndWorkersForTest;
import entity.Availability;
import entity.Workers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WorkersDAOTest {

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
        session.close();
    }

    @Test
    void getWorkersByDepartmentIdAndAvialiabilityUsingHQLPositive() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Workers> workers = workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingHQL(3, Availability.FULL_TIME);
        assertEquals(2, workers.size());
    }

    @Test
    void getWorkersByDepartmentIdAndAvialiabilityUsingHQLNegative() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Workers> workers = workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingHQL(3, Availability.FULL_TIME);
        assertNotEquals(false, workers.size()==2);
    }

    @Test
    void getWorkersByDepartmentIdAndAvialiabilityUsingCriteriaPositive() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Workers> workers = workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingCriteria(3, Availability.FULL_TIME);
        assertEquals(2, workers.size());
    }

    @Test
    void getWorkersByDepartmentIdAndAvialiabilityUsingCriteriaNegative() {
        WorkersDAO workersDAO = new WorkersDAO(session);
        CreateDepartmentsAndWorkersForTest.createDepatmentsAndWorkers(session);
        List<Workers> workers = workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingCriteria(3, Availability.FULL_TIME);
        assertNotEquals(false, workers.size()==2);
    }
}