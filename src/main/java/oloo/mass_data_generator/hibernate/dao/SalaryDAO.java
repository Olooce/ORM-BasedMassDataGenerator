package oloo.mass_data_generator.hibernate.dao;

import com.example.hibernate.entity.Salary;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

public class SalaryDAO {
    public void save(Salary salary) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(salary);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}