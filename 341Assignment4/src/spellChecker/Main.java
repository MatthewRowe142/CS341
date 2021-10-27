package spellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		BinaryTree bin = new BinaryTree();
		File file = new File("/C:/Users/Computer Science/Desktop/delete.txt");
		Scanner in = new Scanner (file);
		
		while(in.hasNext()) {
			bin.add(in.next());
		}
		System.out.println(bin.isWord("all"));
	}

}
