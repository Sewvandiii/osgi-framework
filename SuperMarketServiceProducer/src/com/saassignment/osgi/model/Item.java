package com.saassignment.osgi.model;
//Item model class
public class Item {
	private int itemId;
	private String itemName;
	private double itemPrice;
	private double discount;
	private double finalPrice;
	
	public Item(int itemId, String itemName, double itemPrice, double discount) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.discount = discount;
		calculateFinalPrice();
		
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
		calculateFinalPrice();
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
		calculateFinalPrice();
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void calculateFinalPrice() {
		this.finalPrice = itemPrice * ((100.00- discount)/100.00) ;
	}
}
