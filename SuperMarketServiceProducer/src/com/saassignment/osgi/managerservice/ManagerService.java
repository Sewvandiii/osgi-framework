package com.saassignment.osgi.managerservice;

import java.util.List;

import com.saassignment.osgi.model.Item;
//Provide the services which manager consumers need
public interface ManagerService {
	
	public  int  addItems(String itemName,double itemPrice,double itemDiscount);//Adds the new items to the item list
	public   int  updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount);//Updates the item details
	public   int removeItems(String itemName);//Removes the items from the list
	public   int searchitems(String itemName);//Searches and item by name
	public   List<Item> listItems();//Returns the item list
	
}
