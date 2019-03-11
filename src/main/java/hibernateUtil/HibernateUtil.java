package hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;


    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return session;
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }

    public static void closeSession() {
        session.close();
    }

    public static void closeSessionFactoryAndSession() {
        session.close();
        sessionFactory.close();
    }
}
