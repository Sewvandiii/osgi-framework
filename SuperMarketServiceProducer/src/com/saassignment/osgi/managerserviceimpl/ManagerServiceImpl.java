package com.saassignment.osgi.managerserviceimpl;
import java.util.List;
import java.util.Scanner;

import com.saassignment.osgi.datastore.DataStore;
import com.saassignment.osgi.managerservice.ManagerService;
import com.saassignment.osgi.model.Item;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public synchronized int  addItems(String itemName,double itemPrice,double itemDiscount) {

		Item newItem = new Item(DataStore.itemsList.size() + 1, itemName, itemPrice, itemDiscount);
		DataStore.itemsList.add(newItem);

	return 1;		
	}

	@Override
	public  synchronized int updateItems(String updatedItemName,double updatedItemPrice,double updatedItemDiscount) {
		Item itemToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Item tempItem : DataStore.itemsList) {
			count++;
			if (tempItem.getItemName().equalsIgnoreCase(updatedItemName)) {

				itemToBeUpdated = tempItem;
				invalid = false;
				break;
			}
		
		}
		if (!invalid) {

			itemToBeUpdated.setItemName(updatedItemName);
			itemToBeUpdated.setItemPrice(updatedItemPrice);
			itemToBeUpdated.setDiscount(updatedItemDiscount);
			itemToBeUpdated.calculateFinalPrice();

			DataStore.itemsList.set(count, itemToBeUpdated);
			return 1;

		} else {
			return -1;
		}
				
	}

	@Override
	public  synchronized int removeItems(String itemName) {

		boolean invalid = true;
		int count = -1;
		for (Item tempItem :DataStore.itemsList) {
			count++;
			if (tempItem.getItemName().equalsIgnoreCase(itemName)) {
			
				invalid = false;
				break;
			}
		}
		if (!invalid) {

			DataStore.itemsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}

	@Override
	public int searchitems(String itemName) {
		boolean valid = false;
	
		for (Item tempItem : DataStore.itemsList) {
		
			if (tempItem.getItemName().equalsIgnoreCase(itemName)) {

				valid = true;
				break;

			}			

		}
		if(valid) {
			return 1;
			
		}
		else {
			return -1;
		}
		
	}

	@Override
	public List<Item> listItems() {

		return DataStore.itemsList;
	}
}
