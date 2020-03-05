package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dao.ListDao;
import com.grocery.model.GroceryList;
import com.grocery.model.Item;


@Service
public class ListService {
	
	@Autowired
    ListDao ld;

	@Autowired
	public void setld(ListDao ld) {
		this.ld = ld;
	}

	public GroceryList save(GroceryList GroceryList) {
		return ld.save(GroceryList);
	}

	public GroceryList findById(int id) {
		return ld.findById(id);
	}

	public GroceryList update(GroceryList list) {
		return ld.update(list);
	}
	
	public List<GroceryList> findAll() {
		return ld.findAll();
	}

	public void delete(int id) {
		ld.delete(id);
	}
    
	
}
