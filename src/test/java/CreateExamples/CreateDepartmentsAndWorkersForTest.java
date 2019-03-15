package CreateExamples;

import entity.Availability;
import entity.Department;
import entity.Workers;
import org.hibernate.Session;

public class CreateDepartmentsAndWorkersForTest {

    public static void createDepatmentsAndWorkers(Session session) {

        Department depar1 = new Department("Math", true);
        Department depar2 = new Department("English", true);
        Department depar3 = new Department("History", false);
        Workers worker1 = new Workers(17, Availability.FULL_TIME, "Mary", depar3);
        Workers worker2 = new Workers(32, Availability.FULL_TIME, "Vasyl", depar3);
        Workers worker3 = new Workers(28, Availability.PART_TIME, "Ivan", depar2);
        Workers worker4 = new Workers(20, Availability.FULL_TIME, "Lilia", depar1);

        session.getTransaction().begin();
        session.save(depar1);
        session.save(depar2);
        session.save(depar3);
        session.save(worker1);
        session.save(worker2);
        session.save(worker3);
        session.save(worker4);
        session.getTransaction().commit();

    }
}

