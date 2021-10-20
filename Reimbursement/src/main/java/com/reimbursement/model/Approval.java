package com.reimbursement.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Approval")
public class Approval {
	
	@Id
	@Column(name="approvalId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "approvalId", sequenceName = "approvalId")
	private int approvalId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="approveBy")
	private String approveBy;
	
	
	public Approval() {
		super();
	
	}


	public Approval(int approvalId, String status, String approveBy) {
		super();
		this.approvalId = approvalId;
		this.status = status;
		this.approveBy = approveBy;
	}


	public int getApprovalId() {
		return approvalId;
	}


	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getApproveBy() {
		return approveBy;
	}


	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}


	@Override
	public int hashCode() {
		return Objects.hash(approvalId, approveBy, status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Approval other = (Approval) obj;
		return approvalId == other.approvalId && Objects.equals(approveBy, other.approveBy)
				&& Objects.equals(status, other.status);
	}


	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", status=" + status + ", approveBy=" + approveBy + "]";
	}
}
