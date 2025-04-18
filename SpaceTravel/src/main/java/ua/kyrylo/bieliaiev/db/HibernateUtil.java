package ua.kyrylo.bieliaiev.db;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.kyrylo.bieliaiev.model.Client;
import ua.kyrylo.bieliaiev.model.Planet;
import ua.kyrylo.bieliaiev.model.Ticket;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE;
    @Getter
    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
