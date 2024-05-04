package com.dao;

import java.util.ArrayList;


public interface DaoInterface<T> {
	
	ArrayList<T> findAll();
	
	// T findById(String id);
	// T findById(int id);
	
	void update(T obj);
	
	T save(T obj);

	T findById(int id);

	void delete(int id);

}