package oloo.mass_data_generator.hibernate.dao;

import oloo.mass_data_generator.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import oloo.mass_data_generator.hibernate.HibernateUtil;

public class EmployeeDAO {
    public void save(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
