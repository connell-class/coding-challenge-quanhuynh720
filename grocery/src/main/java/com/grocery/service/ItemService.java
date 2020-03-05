package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.dao.ItemDao;
import com.grocery.model.Item;

@Service
public class ItemService {
	
	@Autowired
	ItemDao id;

	@Autowired
	public void setid(ItemDao id) {
		this.id = id;
	}

	public Item save(Item Item) {
		return id.save(Item);
	}

	public List<Item> findAll() {
		return id.findAll();
	}

	public Item update(Item Item) {
		return id.update(Item);
	}

	public void delete(int ItemId) {
		id.delete(ItemId);
	}
    
}
