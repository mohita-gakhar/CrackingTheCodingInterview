package linkedList;

public class FindBeginningLoopNode {
	
	/**
	 * Time complexity is O(N)
	 * Space is O(1)
	 * @param list
	 * @return
	 */
	private static Node findBeginningLoopNode(LinkedList list) {
		Node head = list.getHead();
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) {
				break;
			}
		}
		if(fast == null || fast.getNext() == null) {
			return null;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] arr= new int[100];
		for(int i=0;i<100;i++) {
			arr[i]=i;
		}
		
		LinkedList list = LinkedListUtils.createFromArray(arr);
		
		//LinkedListUtils.createLoopInLinkedList(list, 2);
		Node loop = findBeginningLoopNode(list);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.getData());
		}

	}

}
