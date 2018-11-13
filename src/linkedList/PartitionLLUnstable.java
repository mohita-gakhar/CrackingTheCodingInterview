package linkedList;

/**
 * Algo is to create a new list 
 * and insert at the head and tail(doesn't preserve
 * the order)
 * @author Mohita
 *
 */
public class PartitionLLUnstable {
	
	private static LinkedList partition(LinkedList list, int x) {
		Node node = list.getHead();
		Node head = node;
		Node tail = node;
		while(node != null) {
			Node next = node.getNext();
			if(node.getData() < x) {
				node.setNext(head);
				head= node;
			}else {
				tail.setNext(node);
				tail= node;
			}
			node=next;
		}
		tail.setNext(null);
		LinkedList result = new LinkedList();
		result.setHead(head);
		return result;
	}

	public static void main(String[] args) {
		int[] vals = {33,9,2,3,10,10389,838,874578,5};
		LinkedList head = LinkedListUtils.createFromArray(vals);
		head.printList();
		
		/* Partition */
		LinkedList h = partition(head, 9);
		
		h.printList();
	}

}
