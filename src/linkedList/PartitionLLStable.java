package linkedList;


/**
 * Algo is to have two linkedList one which appears
 * before the element and other which appears after
 * then we can merge them
 * @author Mohita
 *
 */
public class PartitionLLStable {
	
	/**
	 * Time and space complexity is O(N)
	 * Rather than maintaining four variables, we can insert at the front
	 * (although not very stable)
	 * And then merge the list
	 * @param list
	 * @param x
	 * @return
	 */
	private static LinkedList partition(LinkedList list, int x) {
		LinkedList beforeHead= null;
		Node beforeTail= null;
		LinkedList afterHead = null;
		Node afterTail = null;
		Node node = list.getHead();
		while(node != null) {
			Node next = node.getNext();
			node.setNext(null);
			if(node.getData() < x) {
				if(beforeHead == null) {
					beforeHead = new LinkedList(node.getData());
					beforeTail = beforeHead.getHead();
				}else {
					beforeTail.setNext(node);
					beforeTail = node;
				}
			}else {
				if(afterHead == null) {
					afterHead = new LinkedList(node.getData());
					afterTail = afterHead.getHead();
				}else {
					afterTail.setNext(node);
					afterTail = node;
				}
			}
			node = next;
		}
		if(null == beforeHead) {
			return afterHead;
		}
		beforeTail.setNext(afterHead.getHead());
		return beforeHead;
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
