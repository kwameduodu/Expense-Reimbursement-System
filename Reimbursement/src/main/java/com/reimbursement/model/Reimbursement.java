package com.reimbursement.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.reimbursement.model.Reimbursement;



	@Entity
	@Table(name="Employees")
	public class Reimbursement {
		@Id
		@Column(name="EmployeeId")
		@GeneratedValue(strategy = GenerationType.AUTO)
		@SequenceGenerator(allocationSize = 1, name = "employeeId", sequenceName = "employeeId")
		private int employeeId;
		
		@Column(name="name")
		private String Name;
		@Column(name="amount")
		private String Amount;
		@Column(name="reason")
		private String Reason;
		
		public Reimbursement() {
			super();

		}
		public Reimbursement(int EmployeeId, String Name, String Amount, String Reason) {
			this.employeeId = EmployeeId;
			this.Name = Name;
			this.Amount = Amount;
			this.Reason = Reason;
		}
		public int getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		public String getAmount() {
			return Amount;
		}
		public void setAmount(String amount) {
			this.Amount = amount;
		}
		public String getReason() {
			return Reason;
		}
		public void setReason(String reason) {
			this.Reason = reason;
		}
		
		
		
		@Override
		public int hashCode() {
			return Objects.hash(Amount, employeeId, Name, Reason);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reimbursement other = (Reimbursement) obj;
			return Objects.equals(Amount, other.Amount) && employeeId == other.employeeId
					&& Objects.equals(Name, other.Name) && Objects.equals(Reason, other.Reason);
		}
		
		
		
		@Override
		public String toString() {
			return "Employee [employeeId=" + employeeId + ", name=" + Name + ", amount=" + Amount + ", reason=" + Reason
					+ "]";
		}

	}