package mypackage;

public class LinkedList {
	private Node head;
	private double mean;
	private double stdv;
	private int size;
	
	public LinkedList() {
		head=null;
		size = 0;
		mean = 0;
		stdv = 0;
	}
	public void addNode(double val) {
		Node temp = new Node(val,head);
		if(head==null) {
			head = temp;
		}else {
			head = temp;
		}
		mean = (mean*size+val)/(size+1);
		stdv += (val-mean)*(val-mean);
		size++;
	}
	public double getStdv() {
		return Math.sqrt(stdv/size);
	}
	public double getMean() {
		return mean;
	}
	public String getList() {
		String res = "";
		Node tempNode = head;
		for(int i = 0; i< size; i++) {
			res += tempNode.getVal()+" ";
			tempNode = tempNode.getNext();
		}
		return res;
	}
}
