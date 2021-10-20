package com.reimbursement.service;

import java.util.List;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.repository.ReimbursementRepo;

public class ReimbursementService {

private ReimbursementRepo reimbursementDao;
	
	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementRepo();
	}

	public List<Reimbursement> findAllRecipesAlphabetical(){
		List<Reimbursement> allemployee = this.reimbursementDao.findAll();
		
		return null;
	}
	
	public List<Reimbursement> findAll(){
		return this.reimbursementDao.findAll();
	}
	
	public void save(Reimbursement employee) {
		this.reimbursementDao.save(employee);
	}
}


