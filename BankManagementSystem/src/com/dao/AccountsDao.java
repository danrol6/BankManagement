package com.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.entities.Account;
import com.entities.Transaction;
import com.utilities.DbCon;

public class AccountsDao implements DaoInterface<Account> {
	private static String TABLE = "Accounts";
	private static String TRANSACTION = "Transactions";
	
	public ArrayList<Account> findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			String sql = "select * from " +TABLE;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account();

				account.setAccountId(rs.getString(1));
				account.setCustomerId(rs.getString(2));
				account.setAccountType(rs.getString(3));
				account.setStatus(rs.getString(4));
				account.setBalance(rs.getDouble(5));
				account.setLastTransaction(rs.getTimestamp(6));
				
				accounts.add(account);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return accounts;
	}

	public Account findById(String id) {
		Connection con = DbCon.getConnection();
		Account account = new Account();
		
		try {
			String sql = "select * from " +TABLE+" where account_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account.setAccountId(rs.getString(1));
				account.setCustomerId(rs.getString(2));
				account.setAccountType(rs.getString(3));
				account.setStatus(rs.getString(4));
				account.setBalance(rs.getDouble(5));
				account.setLastTransaction(rs.getTimestamp(6));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return account;
	}

	public void update(Account obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update " + TABLE + 
					" set customer_id=?, account_type=?, status=?, "
					+ "balance=?, last_transaction=? where account_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getCustomerId());
			ps.setString(2, obj.getAccountType());
			ps.setString(3, obj.getStatus());
			ps.setDouble(4, obj.getBalance());
			ps.setTimestamp(5, obj.getLastTransaction());
			ps.setString(6, obj.getAccountId());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}

	public Account save(Account obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "insert into " + TABLE + 
					" (account_id, customer_id, account_type, status, balance, last_transaction) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getAccountId());
			ps.setString(2, obj.getCustomerId());
			ps.setString(3, obj.getAccountType());
			ps.setString(4, obj.getStatus());
			ps.setDouble(5, obj.getBalance());
			ps.setTimestamp(6, obj.getLastTransaction());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public void deleteByAccountId(String id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "delete from " + TABLE + " where account_id = ?";
			System.out.println(qry);
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, id);
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
	
	public Transaction addTransaction(Transaction obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "insert into " + TRANSACTION + 
					" (transaction_id, account_id, dat, description, amount, balance) "
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getTransactionId());
			ps.setString(2, obj.getAccountId());
			ps.setTimestamp(3, obj.getDate());
			ps.setString(4, obj.getDescription());
			ps.setDouble(5, obj.getAmount());
			ps.setDouble(6, obj.getBalance());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return obj;
	}
	
	public boolean withdraw(String id, double amount) {
		Connection con = DbCon.getConnection();
		Account account = findById(id);
		double updated = 0;
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		if(account.getBalance() < amount) {
			return false;
		}
		
		try {
			updated = account.getBalance() - amount;
			String qry = "update " + TABLE + 
					" set balance=? where account_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setDouble(1, updated);
			ps.setString(2, account.getAccountId());
			
			Transaction tr = new Transaction();
			tr.setAccountId(account.getAccountId());
			tr.setDate(ts);
			tr.setDescription("Withdraw from " +account.getAccountId());
			tr.setAmount(amount);
			tr.setBalance(updated);
			
			addTransaction(tr);
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return true;
	}
	
	public boolean deposit(String id, double amount) {
		Connection con = DbCon.getConnection();
		Account account = findById(id);
		double updated = 0;
		
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		try {
			updated = account.getBalance() + amount;
			String qry = "update " + TABLE + 
					" set balance=? where account_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setDouble(1, updated);
			ps.setString(2, account.getAccountId());
			
			Transaction tr = new Transaction();
			tr.setAccountId(account.getAccountId());
			tr.setDate(ts);
			tr.setDescription("Deposit from " +account.getAccountId());
			tr.setAmount(amount);
			tr.setBalance(updated);
			
			addTransaction(tr);
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return true;
	}

	public boolean transfer(String id, double amount, String transferId) {
		boolean good = false;
		
		try {
			withdraw(id, amount);
			deposit(transferId, amount);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return good;
	}
	
	public ArrayList<Transaction> recentTransaction(String id, int num){
		Connection con = DbCon.getConnection();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		try {
			// select * from( select transaction_id, account_id, dat, description, amount, 
			// balance, row_number() over(order by dat desc) as r from Transactions) where account_id=? and r<=?;
			String sqlQuery = "select * from ( select transaction_id, account_id, dat, description, amount, balance, row_number() "+ 
			"over(order by dat desc) as r from "+TRANSACTION+ ") where account_id=? and r<=?";
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, id);
			ps.setInt(2, num);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setTransactionId(rs.getString(1));
				tr.setAccountId(rs.getString(2));
				tr.setDate(rs.getTimestamp(3));
				tr.setDescription(rs.getString(4));
				tr.setAmount(rs.getDouble(5));
				tr.setBalance(rs.getDouble(6));
				
				transactions.add(tr);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return transactions;
	}
	
	public ArrayList<Transaction> findByStartEndDate(String id, Timestamp start, Timestamp end){
		Connection con = DbCon.getConnection();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			//select * from Transactions where account_id = ? and (dat between ? and ?); 
			String sql = "select * from " +TRANSACTION+" where account_id = ? and (dat between ? and ? )";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setTimestamp(2, start);
			ps.setTimestamp(3, end);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction tr = new Transaction();
				tr.setTransactionId(rs.getString(1));
				tr.setAccountId(rs.getString(2));
				tr.setDate(rs.getTimestamp(3));
				tr.setDescription(rs.getString(4));
				tr.setAmount(rs.getDouble(5));
				tr.setBalance(rs.getDouble(6));
				
				transactions.add(tr);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return transactions;
	}

	public ArrayList<Account> findAccByCustomerId(String id){
		Connection con = DbCon.getConnection();
		ArrayList<Account> accountlist = new ArrayList<Account>();
		
		try {
			String sql = "select * from " +TABLE+" where customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Account account = new Account(); 
				account.setAccountId(rs.getString(1));
				account.setCustomerId(rs.getString(2));
				account.setAccountType(rs.getString(3));
				account.setStatus(rs.getString(4));
				account.setBalance(rs.getDouble(5));
				account.setLastTransaction(rs.getTimestamp(6));
				
				accountlist.add(account);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return accountlist;
		
	}
	
	public ArrayList<Transaction> findAllTransaction() {
		Connection con = DbCon.getConnection();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			String sql = "select * from " +TRANSACTION;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction transaction = new Transaction();

				transaction.setAccountId(rs.getString(1));
				transaction.setDate(rs.getTimestamp(2));
				transaction.setDescription(rs.getString(3));
				transaction.setAmount(rs.getDouble(4));
				transaction.setBalance(rs.getDouble(5));
				
				transactions.add(transaction);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return transactions;
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//delete account by customer id
	public void deleteByCustomerId(String id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "delete from " + TABLE + " where CUSTOMER_ID = ?";
			System.out.println(qry);
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, id);
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
	
	//delete transactions by account id
	public void deleteTransactionsByAccountId(String id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "delete from " + TRANSACTION + " where account_id = ?";
			System.out.println(qry);
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, id);
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
	
	//find all transactions by customerID
	public ArrayList<Transaction> findAllTransactionsByAccountId(String id) {
		Connection con = DbCon.getConnection();
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try {
			String sql = "select * from " +TRANSACTION + " where account_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction transaction = new Transaction();

				transaction.setAccountId(rs.getString(1));
				transaction.setDate(rs.getTimestamp(2));
				transaction.setDescription(rs.getString(3));
				transaction.setAmount(rs.getDouble(4));
				transaction.setBalance(rs.getDouble(5));
				
				transactions.add(transaction);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return transactions;
	}
	
	public void updateAccStatus(String accId, String status) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update " + TABLE + 
					" set status=? "
					+" where account_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, status);
			ps.setString(2, accId);
			
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
}
