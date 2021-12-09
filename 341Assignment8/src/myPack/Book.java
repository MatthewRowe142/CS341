package myPack;

import java.io.Serializable;

public class Book implements Serializable {
	private Integer sku;
	private String title;
	private Integer price;
	private Integer quant;
	
	Book(Integer sku, String title, Integer price, Integer quant){
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quant = quant;
	}
	public String[] display() {
		String[] res = new String[4];
		res[0] = sku.toString();
		res[1] = title;
		res[2] = price.toString();
		res[3] = quant.toString();
		return res;
		
	}
	
	

}
