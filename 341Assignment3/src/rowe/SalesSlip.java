
package rowe;

import java.util.ArrayList;

public class SalesSlip {
	private ArrayList<SalesItem> slip;
	public SalesSlip(){
		slip = new ArrayList<SalesItem>();
	}
	public String toString() {
		ArrayList<SalesItem> copy = (ArrayList<SalesItem>) slip.clone();
		String str = "";
		while(!copy.isEmpty()) {
			str += copy.get(0) +"\n";
			copy.remove(0);
		}
		
		return str;
	}
	public String total() {
		ArrayList<SalesItem> copy = (ArrayList<SalesItem>) slip.clone();
		String str = "";
		double val = 0;
		while(!copy.isEmpty()) {
			val += copy.get(0).getSalesItemPrice()*copy.get(0).getSalesItemQuantity();
			copy.remove(0);
		}
		
		return "$"+String.valueOf(val);
		
	}
	public void addItem(String name, double price, int quantity) {
		System.out.println(name+" "+price+" "+quantity);
		slip.add(new SalesItem(name,price,quantity));
	}
}
