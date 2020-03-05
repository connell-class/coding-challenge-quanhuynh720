package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Item;
import com.grocery.model.Item;
import com.grocery.service.ItemService;
import com.grocery.service.ListService;

@Controller
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemService is;

	
	@RequestMapping(method = RequestMethod.POST, value = "/addItem.app", consumes = "application/json")
	public ResponseEntity<Item> save(@RequestBody Item Item) {
		is.save(Item);
		return new ResponseEntity<Item>(Item, HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/ItemList.app", produces = "application/json")
	public ResponseEntity<List<Item>> findAll() {
		return new ResponseEntity<List<Item>>(is.findAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem.app", produces = "application/json")
	public ResponseEntity<Item> updateItem(@RequestBody Item Item) {
		return new ResponseEntity<>(is.update(Item), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/deleteItem.app")
	public void delete(@PathVariable int id) {
		is.delete(id);
	}
}
