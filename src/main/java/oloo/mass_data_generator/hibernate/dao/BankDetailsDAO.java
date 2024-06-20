package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.BankDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class BankDetailsDAO {

    public void save(BankDetails bankDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bankDetails);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
