package com.reimbursement.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.reimbursement.model.Approval;
import com.reimbursement.util.HibernateSessionFactory;

public class ApprovalRepo {
	public List<Approval> findAll(){
		List<Approval> approve = null;
		Session s = null;
		Transaction tx = null;

		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			approve = s.createQuery("FROM Approval", Approval.class).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}catch(IllegalArgumentException ex) {

			ex.printStackTrace();
		}finally {
			s.close();
		}
		return approve;
	}
	
	
	
	public void save(Approval approve) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			session.save(approve);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
}


