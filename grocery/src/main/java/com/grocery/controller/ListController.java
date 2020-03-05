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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.GroceryList;
import com.grocery.service.ListService;


@Controller
@CrossOrigin(origins = "*")
public class ListController {
	
	@Autowired
	private ListService ls;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addGroceryList.app", consumes = "application/json")
	public ResponseEntity<GroceryList> save(@RequestBody GroceryList GroceryList) {
		ls.save(GroceryList);
		return new ResponseEntity<GroceryList>(GroceryList, HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/GroceryListList.app", produces = "application/json")
	public ResponseEntity<List<GroceryList>> findAll() {
		return new ResponseEntity<List<GroceryList>>(ls.findAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateGroceryList.app", produces = "application/json")
	public ResponseEntity<GroceryList> updateGroceryList(@RequestBody GroceryList GroceryList) {
		return new ResponseEntity<>(ls.update(GroceryList), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/deleteGroceryList.app")
	public void delete(@PathVariable int id) {
		ls.delete(id);
	}
	    
}
