package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.Deduction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class DeductionDAO {
    public void save(Deduction deduction) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(deduction);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}