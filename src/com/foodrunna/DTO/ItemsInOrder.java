package com.foodrunna.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEMS_IN_ORDER")
public class ItemsInOrder {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="ITEMS_ORDER_ID")
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ORDER_ID")
	private OrderDetails order;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ITEM_ID")
	private ItemDetails item;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="DESCRIPTION", length = 32600)
	private String description;
	
	public ItemsInOrder() {
	}

	public ItemsInOrder(OrderDetails order, ItemDetails item,
			int quantity, String description) {
		this.order = order;
		this.item = item;
		this.quantity = quantity;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderDetails getOrder() {
		return order;
	}

	public void setOrder(OrderDetails order) {
		this.order = order;
	}

	public ItemDetails getItem() {
		return item;
	}

	public void setItem(ItemDetails item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
