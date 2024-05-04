package com.services;

import java.util.ArrayList;
import com.dao.CustomersDao;
import com.entities.Customer;


public class CustomersService implements ServiceInterface<Customer> {
	
	private static CustomersDao dao;
	
	public CustomersService() {
		dao = new CustomersDao();
	}
	
	public void delete(String id) {
		dao.delete(id);
	}
	
	public Customer findBySsn(String ssn) {
		return dao.findBySsn(ssn);
	}
	
	public Customer findByCustomerId(String id) {
		return dao.findByCustomerId(id);
	}
	
	public ArrayList<Customer> findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}
	
	public ArrayList<Customer> findAll() {
		return dao.findAll();
	}
	
	public ArrayList<Customer> findAllActive() {
		return dao.findAllActive();
	}

	public Customer findById(int id) {
		return dao.findById(id);
	}

	public void update(Customer obj) {
		dao.update(obj);
	}

	public Customer save(Customer obj) {
		return dao.save(obj);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public Customer findById(String id) {
		return dao.findById(id);
	}
}
