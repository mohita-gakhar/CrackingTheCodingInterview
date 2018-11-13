package linkedList;


public class IntersectionNode {
	
	private static LinkedList getIntersectionNode(LinkedList list1, LinkedList list2) {
		if(list1 == null || list2 == null) {
			return null;
		}
		Node head1 = list1.getHead();
		Node head2 = list2.getHead();
		
		List l1 = getTailAndSize(head1);
		List l2 = getTailAndSize(head2);
		
		if(l1.tail != l2.tail) {
			return null;
		}
		
		Node longer= l1.size>l2.size?head1:head2;
		Node shorter= l1.size>l2.size?head2:head1;
		
		longer = getKthNode(longer,Math.abs(l1.size-l2.size));
		while(shorter != longer) {
			shorter = shorter.getNext();
			longer=longer.getNext();
		}
		return new LinkedList(shorter);		
	}

	private static Node getKthNode(Node head, int k) {
		Node current = head;
		while(k>0 && current != null) {
			current = current.getNext();
			k--;
		}
		return current;
	}

	private static List getTailAndSize(Node head1) {
		Node tail = head1;
		int size=1;
		while(tail.getNext() != null) {
			tail=tail.getNext();
			size++;
		}
		return new List(tail, size);
	}

	public static void main(String[] args) {
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedList list1 = LinkedListUtils.createFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedList list2 = LinkedListUtils.createFromArray(vals2);
		
		list2.getHead().getNext().setNext(list1.getHead().getNext().getNext().getNext().getNext()); 
		
		list1.printList();
		list2.printList();		
		
		LinkedList intersection = getIntersectionNode(list1, list2);
		
		intersection.printList();
	}

}

class List {
	Node tail;
	int size;
	
	public List(Node tail,int size) {
		this.tail=tail;
		this.size=size;
	}
	
}
