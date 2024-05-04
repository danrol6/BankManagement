package com.entities;

import java.sql.Timestamp;

public class Account {
	private String accountId;
	private String customerId;
	private String accountType;
	private String status;
	private double balance;
	private Timestamp lastTransaction;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Timestamp getLastTransaction() {
		return lastTransaction;
	}
	public void setLastTransaction(Timestamp lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", customerId=" + customerId + ", accountType=" + accountType
				+ ", status=" + status + ", balance=" + balance + ", lastTransaction=" + lastTransaction + "]";
	}
	

}
