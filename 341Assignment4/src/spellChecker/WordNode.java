package spellChecker;


public class WordNode {
	private String word;
	private WordNode left;
	private WordNode right;
	
	public WordNode(String word){
		this.word = word;
	}
	public WordNode getRight() {
		if(right==null) {
			return null;
		}
		return right;
	}
	public WordNode getLeft() {
		if(left==null) {
			return null;
		}
		return left;
	}
	public void setRight(WordNode temp) {
		this.right = temp;
	}
	public void setLeft(WordNode temp) {
		this.left = temp;
	}
	public String getWord() {
		return word;
	}
}
