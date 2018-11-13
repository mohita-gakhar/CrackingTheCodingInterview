package linkedList;

public class IsPalindromeRecursive {
	
	private static Node head;
	private static Node left;
	
	/**
	 * Time and space complexity is O(n)
	 * @param list
	 * @return
	 */
	private static boolean isPalindrome(LinkedList list) {
		return isPalindrome(list.getHead());
	}
	
	private static boolean isPalindrome(Node right) {
		left = head;
		if(right==null) {
			return true;
		}
		
		boolean result = isPalindrome(right.getNext());
		if(!result) {
			return false;
		}
		boolean newResult = left.getData() == right.getData();
		left= left.getNext();
		return newResult;
	}

	public static void main(String[] args) {
		head = new Node(0);
		int[] arr = {1,2,3,3,2,1,0};
		LinkedList list = LinkedListUtils.createFromArray(arr,head);
		list.printList();
		System.out.println("is Palindrome "+isPalindrome(list));
	}

}
