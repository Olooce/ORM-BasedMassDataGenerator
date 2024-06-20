
package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.Allowance;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class AllowanceDAO {
    public void save(Allowance allowance) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(allowance);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}