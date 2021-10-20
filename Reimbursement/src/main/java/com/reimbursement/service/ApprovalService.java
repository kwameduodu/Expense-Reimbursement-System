package com.reimbursement.service;

import java.util.List;

import com.reimbursement.model.Approval;
import com.reimbursement.repository.ApprovalRepo;

public class ApprovalService {

	private ApprovalRepo approvalRepo;
	
	public  ApprovalService() {
		this.approvalRepo = new ApprovalRepo();
	}

	public List<Approval> findAllRecipesAlphabetical(){
		List<Approval> allapproval = this.approvalRepo.findAll();
		
		return null;
	}
	
	public List<Approval> findAll(){
		return this.approvalRepo.findAll();
	}
	
	public void save(Approval approve) {
		this.approvalRepo.save(approve);
	}
}




