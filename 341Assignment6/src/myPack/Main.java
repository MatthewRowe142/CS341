
package myPack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in;
		File file = new File("/C:/Users/Computer Science/Desktop/delete.txt");

		in = new Scanner(file);
		try {
			System.out.print(count(in));
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public static String count(Scanner in) {
		int lines = 0;
		Stack stck = new Stack();
		String[] keywords = { "public", "int", "if", "catch", "import" };
		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
		Map<String, Integer> keywordTreeMap = new TreeMap<>();
		String ans = "";
		String temp = "";
		String hold = "";
		String ansHold = "";
		String word = "";
		int inds = -1;
		int indsHold = 0;
		int i = 0;
		int val;
		while (in.hasNext()) {
			lines++;
			hold = temp;
			temp = in.nextLine().trim();

			if (temp.equals("")){
				lines--;
			}else if (temp.equals("{")) {
				i = hold.indexOf(' ');
				if (i == -1) {
					i = hold.indexOf('(');
					if (i == -1) {
						word = hold;
					}else {
						word = hold.substring(0, i);						
					}
				} else {
					word = hold.substring(0, i);
				}
				if (keywordSet.contains(word)) {
					if (!keywordTreeMap.containsKey(word)) {
						keywordTreeMap.put(word, 1);

					} else {
						val = keywordTreeMap.get(word);
						val++;
						keywordTreeMap.put(word, val);
					}
				}
				stck.push(hold);
				inds++;
			} else if (temp.equals("}")) {
				ansHold = ans;
				indsHold = inds;
				ans = "";
				while (indsHold > 0) {
					ans += "     ";
					indsHold--;
				}
				ans += stck.pop() + "\n" + ansHold;
				inds--;
			}else if (temp.substring(0,2).equals("//")) {
				lines--;
			} 
		}	
		keywordTreeMap.forEach((k, v) -> System.out.println(k + "\t" + v));
		System.out.println("Lines: "+lines);
		return ans;
	}
}
