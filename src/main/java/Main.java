import DAO.DepartmentDAO;
import DAO.WorkersDAO;
import entity.Availability;
import entity.Department;
import entity.Workers;
import hibernateUtil.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

//        DepartmentDAO departmentDAO = new DepartmentDAO(session);
//        departmentDAO.delete(6);
//        departmentDAO.save(new Department("Mary", true));
//        System.out.println(departmentDAO.findAll());

//        WorkersDAO workersDAO = new WorkersDAO(session);
//        workersDAO.delete(8);
//        workersDAO.save(new Workers(27, Availability.FULLTIME, "Yevhe_Yarema"));
//        System.out.println(workersDAO.findAll());
        session.getTransaction().commit();
        HibernateUtil.closeSessionFactoryAndSession();
    }
}
