package com.grocery.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "GroceryList")
public class GroceryList {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private int listId;
	
	@Column
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "GroceryList", orphanRemoval = true)
	@JsonIgnore
	private String listName;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "GroceryList", orphanRemoval = true)
//	@JsonIgnore
//	private List<Item> items = new ArrayList<Item>();

	public GroceryList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(listId, listName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		return  listId == other.listId && Objects.equals(listName, other.listName);
	}

	@Override
	public String toString() {
		return "GroceryList [listId=" + listId + ", " + (listName != null ? "listName=" + listName + ", " : "") + "]";
	}

//	public GroceryList(int listId, String listName, List<Item> items) {
//		super();
//		this.listId = listId;
//		this.listName = listName;
//		this.items = items;
//	}

	public GroceryList(int listId, String listName) {
		super();
		this.listId = listId;
		this.listName = listName;
	}
	
	
}
