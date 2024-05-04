package com.services;

import java.util.ArrayList;

import com.dao.UsersDao;
import com.entities.User;

public class UsersService implements ServiceInterface<User> {
	private static UsersDao dao;
	
	public UsersService() {
		dao = new UsersDao();
	}
	public ArrayList<User> findAll() {
		return dao.findAll();
	}

	public User findById(int id) {
		return dao.findById(id);
	}

	public void update(User obj) {
		dao.update(obj);
		
	}

	public User save(User obj) {
		return dao.save(obj);
	}

	public void delete(int id) {
		dao.delete(id);
		
	}

	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
