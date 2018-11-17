package tree;

import java.util.ArrayList;

/**
 * Used to look up if a word is a prefix 
 * of any other words in a dictionary
 * (or a list of valid words)
 * @author Mohita
 *
 */
public class Trie {
	
	private TrieNode root;
	
	public Trie(ArrayList<String> words) {
		root = new TrieNode();
		for(String word: words) {
			root.addWord(word);
		}
	}
	
	public Trie(String[] words) {
		root = new TrieNode();
		for(String word: words) {
			root.addWord(word);
		}
	}
	
	public boolean contains(String prefix, boolean exact) {
		TrieNode node = root;
		for(int i=0;i<prefix.length();i++) {
			node = node.getChild(prefix.charAt(i));
			if(node == null) {
				return false;
			}
		}
		
		return !exact || node.terminates();
	}
	
	public boolean contains(String prefix) {
		return contains(prefix, false);
	}
	
	public TrieNode getRoot() {
		return root;
	}

}
