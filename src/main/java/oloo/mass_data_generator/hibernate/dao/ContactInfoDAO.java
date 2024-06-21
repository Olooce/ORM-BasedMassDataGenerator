package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.ContactInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class ContactInfoDAO {
    public void save(ContactInfo contactInfo) {
        performTransaction(session -> session.save(contactInfo));
    }

    private void performTransaction(TransactionOperation operation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            operation.execute(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.getStatus().canRollback()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface TransactionOperation {
        void execute(Session session);
    }
}

