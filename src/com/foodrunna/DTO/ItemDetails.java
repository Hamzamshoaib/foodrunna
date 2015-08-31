package com.foodrunna.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "ITEM_DETAILS")
public class ItemDetails {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="ITEM_ID")
	private int item_id;
	
	@Column(name="RESTAURANT_NAME")
	private String RestaurantName;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_COST")
	private int itemCost;
	
	/*@ManyToMany
	@JoinTable(name="ITEMS_IN_ORDER",
	joinColumns={@JoinColumn(name="ITEM_ID")},
	inverseJoinColumns={@JoinColumn(name="ORDER_ID")})*/
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<ItemsInOrder> itemsInOrder;

	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<ItemsInOrder> getItemsInOrder() {
		return itemsInOrder;
	}

	public void setItemsInOrder(List<ItemsInOrder> itemsInOrder) {
		this.itemsInOrder = itemsInOrder;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}


}
