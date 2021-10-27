package rowe;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SalesItem {

	private String name;
	private double price;
	private int quantity;
	
	public SalesItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public String getSalesItemName(){
		return this.name;
	}
	public double getSalesItemPrice(){
		return this.price;
	}
	public int getSalesItemQuantity(){
		return this.quantity;
	}
	public String toString() {
	    DecimalFormat df2 = new DecimalFormat("#.##");
		return (this.name+" $"+df2.format(price)+" "+quantity);
	}
}
