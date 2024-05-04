package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.entities.Customer;
import com.utilities.DbCon;

public class CustomersDao implements DaoInterface<Customer> {
	
	private static String TABLE = "Customers";

	public ArrayList<Customer> findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			String sql = "select * from "+ TABLE;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
				
				customers.add(customer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customers;
	}

	public Customer findById(int id) {
		Connection con = DbCon.getConnection();
		Customer customer = new Customer();
		
		try {
			String sql = "select * from "+ TABLE + " where customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}
	
	public Customer findById(String id) {
		Connection con = DbCon.getConnection();
		Customer customer = new Customer();
		
		try {
			String sql = "select * from "+ TABLE + " where customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}

	public void update(Customer obj) {
		Connection con = DbCon.getConnection();
		
		try {
			
			String qry = "update " + TABLE + " set ssn =?, first_name=?, last_name=?, dob=?, "
					+ "address1=?, address2=?, city=?, state=?, zipcode=?, customer_status=?, last_update=? where customer_id =?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getSsn());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getLastName());
			ps.setString(4, obj.getDob());
			ps.setString(5, obj.getAddressLine1());
			ps.setString(6, obj.getAddressLine2());
			ps.setString(7, obj.getCity());
			ps.setString(8, obj.getState());
			ps.setString(9, obj.getZipcode());
			ps.setString(10, obj.getCustomerStatus());
			ps.setTimestamp(11,  (Timestamp) obj.getLastUpdate());	
			ps.setString(12, obj.getId());
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
	}

	public Customer save(Customer obj) {
		Connection con = DbCon.getConnection();
		
		try {
			
			String qry = "insert into " + TABLE + " (customer_id, ssn, first_name, last_name, dob,"
					+ "address1, address2, city, state, zipcode, customer_status, last_update)" +
					" values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			
			ps.setString(1, obj.getId());
			ps.setString(2, obj.getSsn());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getDob());
			ps.setString(6, obj.getAddressLine1());
			ps.setString(7, obj.getAddressLine2());
			ps.setString(8, obj.getCity());
			ps.setString(9, obj.getState());
			ps.setString(10, obj.getZipcode());
			ps.setString(11, "active");
			ps.setTimestamp(12, (Timestamp) obj.getLastUpdate());	
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
		return obj;
	}

	public void delete(int id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "Delete from " + TABLE + " where customer_id =?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}
	
	public void delete(String id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "Delete from " + TABLE + " where customer_id =?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, id);
			
			ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbCon.closeConnection();
		}
		
	}
	
	public Customer findBySsn(String ssn) {
		Connection con = DbCon.getConnection();
		Customer customer = new Customer();
		
		try {
			String sql = "select * from "+ TABLE + " where ssn = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ssn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}
	
	public Customer findByCustomerId(String id) {
		Connection con = DbCon.getConnection();
		Customer customer = new Customer();
		
		try {
			String sql = "select * from "+ TABLE + " where customer_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customer;
	}
	
	public ArrayList<Customer> findByLastName(String lastName) {
		Connection con = DbCon.getConnection();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		lastName = "%" + lastName.toLowerCase() +"%";
		
		try {
			String sql = "select * from "+ TABLE + " where lower(last_name) like ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, lastName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
				
				customers.add(customer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customers;
	}
	
	public ArrayList<Customer> findAllActive() {
		Connection con = DbCon.getConnection();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		try {
			String sql = "select * from "+ TABLE + " where customer_status = 'active'";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setSsn(rs.getString(2));
				customer.setFirstName(rs.getString(3));
				customer.setLastName(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddressLine1(rs.getString(6));
				customer.setAddressLine2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setZipcode(rs.getString(10));
				customer.setCustomerStatus(rs.getString(11));
				customer.setLastUpdate(rs.getTimestamp(12));
				
				customers.add(customer);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		
		return customers;
	}
	
}
