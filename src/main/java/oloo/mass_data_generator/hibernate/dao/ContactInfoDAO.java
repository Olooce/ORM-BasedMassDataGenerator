// ContactInfoDAO.java
package oloo.mass_data_generator.hibernate.dao;

import com.example.hibernate.entity.ContactInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

public class ContactInfoDAO {
    public void save(ContactInfo contactInfo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(contactInfo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}






// TaxDAO.java
package com.example.hibernate.dao;

import com.example.hibernate.entity.Tax;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.hibernate.HibernateUtil;

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


