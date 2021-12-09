package myPack;

public class Main {

	public static void main(String[] args) {
		Library lib = new Library("");
		lib.addBook(1234, "cock and balls", 100, 23);
//		String[] str = lib.dispBook(1234);
//		System.out.println(str[0]);
//		System.out.println(str[1]);
//		System.out.println(str[2]);
//		System.out.println(str[3]);
		lib.addBook(234, "pee", 23, 100);
		System.out.println(lib.dispAll());
		

	}

}
