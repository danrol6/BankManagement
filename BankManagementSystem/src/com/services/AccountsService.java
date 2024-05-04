package com.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import com.entities.Account;
import com.entities.Transaction;
import com.dao.AccountsDao;

public class AccountsService implements ServiceInterface<Account>{
	
	private static AccountsDao dao;
	
	public AccountsService() {
		dao = new AccountsDao();
	}
	
	public ArrayList<Account> findAll() {
		return dao.findAll();
	}

	public Account findById(String id) {
		return dao.findById(id);
	}

	public void update(Account obj) {
		dao.update(obj);
	}

	public Account save(Account obj) {
		return dao.save(obj);
	}

	public void delete(String id) {
		dao.deleteByAccountId(id);
	}
	
	public boolean withdraw(String id, double amount) {
		return dao.withdraw(id, amount);
	}
	
	public boolean deposit(String id, double amount) {
		return dao.deposit(id, amount);
	}
	
	public boolean transfer(String id, double amount, String transfer) {
		return dao.transfer(id, amount, transfer);
	}

	public ArrayList<Account> findAccByCustomerId(String idString) {
		return dao.findAccByCustomerId(idString);
	}
	
	public ArrayList<Transaction> findAllTransaction() {
		return dao.findAllTransaction();
	}
	
	public ArrayList<Transaction> recentTransaction(String id, int num){
		return dao.recentTransaction(id, num);
	}
	
	public ArrayList<Transaction> findByStartEndDate(String id, Timestamp start, Timestamp end){
		return dao.findByStartEndDate(id, start, end);
	}
	
	public void deleteByCustomerId(String id) {
		dao.deleteByCustomerId(id);
	}
	
	public ArrayList<Transaction> findAllTransactionsByAccountId(String id) {
		return dao.findAllTransactionsByAccountId(id);
	}
	
	public void deleteTransactionsByAccountId(String id) {
		dao.deleteTransactionsByAccountId(id);
	}
	
	public void updateAccStatus(String accId, String status) {
		 dao.updateAccStatus(accId, status);
	}
}
