import DAO.DepartmentDAO;
import DAO.WorkersDAO;
import entity.Availability;
import util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        DepartmentDAO departmentDAO = new DepartmentDAO(session);
//        departmentDAO.delete(3);
//        departmentDAO.save(new Department("Mary", true));
//        System.out.println(departmentDAO.findAll());
//        System.out.println(departmentDAO.getAllActiveDepartmentsUsingHQL());
//        System.out.println(departmentDAO.getAllActiveDepartmentsUsingCriteria());

        WorkersDAO workersDAO = new WorkersDAO(session);
//        workersDAO.delete(8);
//        workersDAO.save(new Workers(27, Availability.FULLTIME, "Yevhe_Yarema"));
//        System.out.println(workersDAO.findAll());
//        System.out.println(workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingHQL(3, Availability.FULL_TIME));
//        System.out.println(workersDAO.getWorkersByDepartmentIdAndAvialiabilityUsingCriteria(3, Availability.FULL_TIME));
        session.getTransaction().commit();
        HibernateUtil.closeSessionFactoryAndSession();
    }
}
