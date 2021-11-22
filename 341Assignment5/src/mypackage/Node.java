package mypackage;

public class Node {
	private Node next;
	private double val;
	public Node(double val, Node next) {
		this.next = next;
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public double getVal() {
		return val;
	}

}
