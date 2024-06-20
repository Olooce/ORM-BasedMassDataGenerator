package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.Tax;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class TaxDAO {
    public void save(Tax tax) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(tax);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}