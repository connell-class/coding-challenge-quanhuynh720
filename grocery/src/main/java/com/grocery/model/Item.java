package com.grocery.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int itemId;
	
	@Column
	private String itemType;
	
	@ManyToOne
	@JoinColumn(name = "listName")
	@Column
	private String itemName;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, itemType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId && Objects.equals(itemName, other.itemName)
				&& Objects.equals(itemType, other.itemType);
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", " + (itemType != null ? "itemType=" + itemType + ", " : "")
				+ (itemName != null ? "itemName=" + itemName : "") + "]";
	}

	public Item(int itemId, String itemType, String itemName) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemName = itemName;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
