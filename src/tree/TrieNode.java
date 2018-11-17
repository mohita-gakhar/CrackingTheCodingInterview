package tree;

import java.util.HashMap;
/**
 * Each node has it's own hashmap of children
 * @author Mohita
 *
 */
public class TrieNode {
	
	private HashMap<Character, TrieNode> children;
	private boolean terminates = false;
	private char character;
	
	public TrieNode() {
		this.children = new HashMap<>();
	}
	
	public TrieNode(char character) {
		this.character = character;
	}
	
	public void addWord(String word) {
		if(null == word || word.isEmpty()) {
			return;
		}
		char firstChar = word.charAt(0);
		TrieNode child = getChild(firstChar);
		if(null == child) {
			child = new TrieNode(firstChar);
			children.put(firstChar, child);
		}
		if(word.length() > 1) {
			child.addWord(word.substring(1));
		} else {
			child.setTerminates(true);
		}
	}
	
	public char getChar() {
		return character;
	}
	
	public boolean terminates() {
		return terminates;
	}
	
	public void setTerminates(boolean terminates) {
		this.terminates = terminates;
	}
	
	public TrieNode getChild(char c) {
		return children.get(c);
	}

}
