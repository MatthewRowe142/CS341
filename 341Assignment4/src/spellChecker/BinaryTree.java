package spellChecker;

import spellChecker.WordNode;

public class BinaryTree {
	
	private WordNode root;
	private WordNode ptr;
	
	BinaryTree(){
		root = null;
		WordNode ptr = root;
	}
	public void add(String word) {
		int val;
		if(root==null) {
			root = new WordNode(word);
		}else {
			WordNode temp = new WordNode(word);
			ptr = root;
			while(true) {
				val = ptr.getWord().compareToIgnoreCase(word);
				if(val>0) {
					if(ptr.getLeft()==null) {
						ptr.setLeft(temp);
						break;
					}else {
						ptr = ptr.getLeft();
					}
				}else if(val==0){
					break;
				}else {
					if(ptr.getRight()==null) {
						ptr.setRight(temp);
						break;
					}else {
						ptr = ptr.getRight();
					}
				}
			}
		}
		
		
	}
	public String callIn() {
		return inOrder(root,"");
	}
	public boolean isWord(String word) {
		ptr = root;
		while(true) {
			if(ptr.getWord().equalsIgnoreCase(word)) {
				return true;
			}
			if(ptr.getWord().compareToIgnoreCase(word)>0) {
				if(ptr.getLeft()==null) {
					return false;
				}
				ptr = ptr.getLeft();
			}else {
				if(ptr.getRight()==null) {
					return false;
				}
				ptr = ptr.getRight();
			}
		}
	}
	
	public String inOrder(WordNode ptr, String sol) {
				
		if(ptr.getLeft()!=null) {
			sol += inOrder(ptr.getLeft(), "");
		}
		sol+=ptr.getWord()+"\n";
		if(ptr.getRight()!=null) {
			return sol += inOrder(ptr.getRight(),"");
		}else {
			return sol;
		}
			
		
	}

}
