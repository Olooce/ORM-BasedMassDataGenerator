// BankDetailsDAO.java
package com.example.hibernate.dao;

import com.example.hibernate.entity.BankDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

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