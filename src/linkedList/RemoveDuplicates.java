package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mohita
 */
public class RemoveDuplicates {
	
	/**
	 * Temporary buffer(a set) is used to store unique elements
	 * Time Complexity is O(N) 
	 * @param list
	 */
	private static void removeDuplicates(LinkedList list){
		Set<Integer> set= new HashSet<>();
		Node current= list.getHead();
		Node previous= null;
		while(current != null) {
			int data = current.getData();
			if(!set.contains(data)){
				set.add(data);
				previous=current;
			}else {
				previous.setNext(current.getNext());
			}
			current=current.getNext();
		}
		
	}
	
	/**
	 * Though uses O(1) space but runs in O(N^2) time
	 * @param list
	 */
	private static void removeDuplicatesWithoutBuffer(LinkedList list) {
		Node current = list.getHead();
		while(current != null) {
			Node runner = current;
			while(runner.getNext() != null) {
				if(runner.getNext().getData() == current.getData()) {
					Node next = runner.getNext().getNext();
					runner.setNext(next);
				}
				else {
					runner= runner.getNext();
				}
			}
			current=current.getNext();
		}
	}

	public static void main(String[] args) {
		LinkedList head = new LinkedList(0); 
		for (int i = 1; i < 8; i++) {
			head.appendToTail(i%2);
		}
		head.printList();
		removeDuplicatesWithoutBuffer(head);
		head.printList();
	}

}
