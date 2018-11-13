package linkedList;

/**
 * One way to check if a linked list is palindrome
 * by comparing the original list to reversed one
 * @author Mohita
 *
 */
public class IsPalindromeReverse {
	
	/**
	 * Time and space complexity is O(n)
	 * @param list
	 * @return
	 */
	private static boolean isPalindrome(LinkedList list) {
		LinkedList reversed = reverseList(list);
		return isEqual(list,reversed);
	}

	private static boolean isEqual(LinkedList one, LinkedList two) {
		Node headOne = one.getHead();
		Node headTwo = two.getHead();
		while(headOne != null && headTwo != null) {
			if(headOne.getData() != headTwo.getData()) {
				return false;
			}
			headOne = headOne.getNext();
			headTwo = headTwo.getNext();
		}
		return headOne == null && headTwo == null;
	}

	private static LinkedList reverseList(LinkedList list) {
		LinkedList reversed = new LinkedList();
		Node newHead = null;
		Node head= list.getHead();
		while(head != null) {
			Node node = new Node(head.getData());
			node.setNext(newHead);
			newHead = node;
			head = head.getNext();
		}
		reversed.setHead(newHead);
		return reversed;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,3,2,1,0};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		list.printList();
		System.out.println("is Palindrome "+isPalindrome(list));
	}

}
