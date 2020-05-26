package com.saassignment.osgi.cashierserviceimpl;

import java.util.List;

import com.saassignment.osgi.cashierservice.CashierService;
import com.saassignment.osgi.datastore.DataStore;
import com.saassignment.osgi.model.Item ;

public class CashierServiceImpl implements CashierService {
	private List<Item> itemList = DataStore.itemsList;//Item list details in the supermarket 
	private double bill;//to store the bill value
	private String[][] billdetails = new String[1000][4]; //To store the purchased item's details ,Assumption:only 1000 different items are allowed for an order
	private int count = -1; //to store the item count [starts from 0]

	@Override
	public List<Item> displayItems() {
		return DataStore.itemsList;
		
	}
	public int generateBill(int id,int qty) {
		
		boolean valid = false;
		Item currentItem = null;
		for (Item tempItem : itemList) {
			if(id == tempItem.getItemId()) {
				currentItem = tempItem;
				valid = true;
				count++;
				break;
			}
		}
		if(valid) {
			
		this.bill = this.bill + (currentItem.getFinalPrice() * qty); 
			
		billdetails[count][0]= Integer.toString(id);
		billdetails[count][1]= currentItem.getItemName();
		
		billdetails[count][2]= Integer.toString(qty);
		billdetails[count][3]= Double.toString((currentItem.getFinalPrice() * qty));
			
		return 1;
		}
		else {
			return -1;
		}
	}
	public double displayFinalBillAmount() {
		double finalBill = this.bill;
		newBill();
		
		return finalBill;
		
	}
	public String[][] dispalybillDetails(){
		
		return billdetails;
	}
	public void newBill() {//To reset all relevant fields to default values 
		this.bill = 0;
		this.count=-1;		
	}
}
