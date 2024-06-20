

// DeductionDAO.java
package com.example.hibernate.dao;

import com.example.hibernate.entity.Deduction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

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