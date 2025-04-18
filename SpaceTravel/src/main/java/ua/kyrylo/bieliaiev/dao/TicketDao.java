package ua.kyrylo.bieliaiev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.kyrylo.bieliaiev.db.HibernateUtil;
import ua.kyrylo.bieliaiev.model.Ticket;

import java.util.Optional;

public class TicketDao implements Dao<Ticket, Long> {

    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    @Override
    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(ticket);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Failed to create ticket", e);
            }
        }
    }

    @Override
    public Optional<Ticket> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.find(Ticket.class, id));
        }
    }

    @Override
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(ticket);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Failed to update ticket", e);
            }
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(ticket);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new DataProcessingException("Failed to delete ticket", e);
            }
        }
    }
}
