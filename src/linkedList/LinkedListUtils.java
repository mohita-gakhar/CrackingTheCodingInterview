package linkedList;

public class LinkedListUtils {
	
	public static LinkedList createFromArray(int[] arr) {
		LinkedList list= new LinkedList(arr[0]);
		for(int i=1;i<arr.length;i++) {
			list.appendToTail(arr[i]);
		}
		return list;
	}
	
	public static LinkedList createFromArray(int[] arr, Node head) {
		LinkedList list= new LinkedList(head);
		for(int i=0;i<arr.length;i++) {
			list.appendToTail(arr[i]);
		}
		return list;
	}
	
	public static int getLength(LinkedList list) {
		int size=0;
		Node head = list.getHead();
		while(head != null) {
			size++;
			head=head.getNext();
		}
		return size;
	}
	
	public static void createLoopInLinkedList(LinkedList list, int k) {
		Node current = list.getHead();
		while(--k>0) {
			current = current.getNext();
		}
		Node tail = list.getHead();
		while(tail.getNext() != null) {
			tail = tail.getNext();
		}
		
		tail.setNext(current);
	}

}
