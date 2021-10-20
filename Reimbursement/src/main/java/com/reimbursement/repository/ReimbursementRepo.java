package com.reimbursement.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.util.HibernateSessionFactory;

//This is my DAO layer. It has been rewritten with Hibernate.
public class ReimbursementRepo {

	public List<Reimbursement> findAll(){
		List<Reimbursement> reimburse = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			reimburse = s.createQuery("FROM Reimbursement", Reimbursement.class).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}catch(IllegalArgumentException ex) {

			ex.printStackTrace();
		}finally {
			s.close();
		}
		return reimburse;
	}
	
	
	
	public void save(Reimbursement reimburse) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(reimburse);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
}
