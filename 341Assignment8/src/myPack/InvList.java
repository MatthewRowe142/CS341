package myPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InvList {
	private Map<Integer, Book> list;
	String fileName;
	
	InvList(String fileName){
		if(fileName == "") {
			this.fileName = "/C:/Users/Computer Science/Desktop/bookList.txt";
		}else {
			this.fileName = fileName;
		}
		list = new HashMap<Integer,Book>();
		deserialize();
	}
	public boolean checkSku(int sku) {
		if(list!=null) {
			return (list.get(sku)==null);
			
		}else {
			return true;
		}
		//true if book isn't there
	}
	public void addBook(int sku, Book temp) {
		list.put(sku, temp);
	}
	public void removeBook(Integer sku) {
		//should check sku in library
		list.remove(sku);
	}
	public Book getBook(int sku) {
		return list.get(sku);
	}
	public ArrayList<Book> getInv() {
		return new ArrayList<Book>(list.values());
	}
	public void exit() {
		serialize();
	}
	private void serialize(){
		try
		{   
			//Saving of object in a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(list);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught1 "+ex);
		}


		//list = null;
	}		private void deserialize(){

		// Deserialization
		try
		{   
			// Reading the object from a file
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			list = (Map<Integer,Book>)in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
		}

		catch(IOException ex)
		{
			System.out.println("IOException is caught2");
		}

		catch(ClassNotFoundException ex)
		{
			System.out.println("ClassNotFoundException is caught");
		}

	}
}



