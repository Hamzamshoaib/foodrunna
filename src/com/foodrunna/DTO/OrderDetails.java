package com.foodrunna.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "ORDER_DETAILS")
public class OrderDetails {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails userId;
	
	@Column (name="RESTAURANT_NAME")
	private String restaurantName;
	
	@Column (name="DELIVERY_TIME")
	private String deliveryTime;
	
	@Embedded
	@Column (name="DELIVERY_ADDRESS")
	private Address deliveryAddress;
	
	@Column(name="EXTRA_COST")
	private int extraCost;
	
	@Column(name="TOTAL_COST")
	private int totalCost;
	
	/*@ManyToMany
	@JoinTable(name="ITEMS_IN_ORDER",
			joinColumns={@JoinColumn(name="ORDER_ID")},
			inverseJoinColumns={@JoinColumn(name="ITEM_ID")})*/
	@OneToMany(mappedBy="order", fetch=FetchType.LAZY)
	private List<ItemsInOrder> itemsInOrder;	
	
	public OrderDetails() {
	}
	
	public OrderDetails(UserDetails userId, String restaurantName,
			String deliveryTime, Address deliveryAddress) {
		this.userId = userId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.deliveryAddress = deliveryAddress;
	}
	
	
	public OrderDetails(UserDetails userId, String restaurantName,
			String deliveryTime, Address deliveryAddress,
			List<ItemsInOrder> itemsInOrder) {
		this.userId = userId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.deliveryAddress = deliveryAddress;
		this.itemsInOrder = itemsInOrder;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserDetails getUserId() {
		return userId;
	}
	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<ItemsInOrder> getItemsInOrder() {
		return itemsInOrder;
	}
	public void setItemsInOrder(List<ItemsInOrder> itemsInOrder) {
		this.itemsInOrder = itemsInOrder;
	}
	public int getExtraCost() {
		return extraCost;
	}
	public void setExtraCost(int extraCost) {
		this.extraCost = extraCost;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	
	
}
