// AllowanceDAO.java
package com.example.hibernate.dao;

import com.example.hibernate.entity.Allowance;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

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