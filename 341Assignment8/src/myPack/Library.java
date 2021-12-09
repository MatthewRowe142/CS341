package myPack;

import java.util.ArrayList;

public class Library {
	InvList invList;
	Library(String fileName){
		invList = new InvList(fileName);
	}
	public void addBook(Integer sku, String title, Integer price, Integer quant){
		if(invList.checkSku(sku)) {
			Book temp = new Book(sku,title,price,quant);
			invList.addBook(sku, temp);
		}
	}
	public void remBook(Integer sku) {
		if(!invList.checkSku(sku)) {
			invList.removeBook(sku);
		}else {
			System.out.println("Book not in there");
		}
	}
	public String dispBook(Integer sku) {
		if(!invList.checkSku(sku)) {
			String[] preResult = invList.getBook(sku).display();
			String result = "";
			for(int i = 0; i<preResult.length;i++) {
				result += preResult[i]+ " ";
			}
			return result;
		}else {
			return "Null";
		}	
	}
	public String dispAll() {
		
		ArrayList<Book> res = invList.getInv();
		String result = "";
		for(int i = 0; i<res.size();i++) {
			Book temp = res.get(i);
			String[] tempStr = temp.display();
			for(int j = 0; j<4;j++) {				
				result += tempStr[j]+" ";
			}
			result += "\n";
		}
		return result;
	}
	public void exit() {
		invList.exit();
	}
}
