package com.services;

import java.util.ArrayList;

public interface ServiceInterface<T> {
	ArrayList<T> findAll();
	
	T findById(String id);
	
	void update(T obj);
	
	T save(T obj);
	
	void delete(String id);
}
