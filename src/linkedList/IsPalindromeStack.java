package linkedList;

import java.util.Stack;

/**
 * Idea is to use stack to store first half of list
 * which will be retrieved in reverse order
 * and just compare it with second half
 * @author Mohita
 *
 */
public class IsPalindromeStack {
	
	/**
	 * Time and space complexity is O(n)
	 * @param list
	 * @return
	 */
	public static boolean isPalindrome(LinkedList list) {
		Node fast = list.getHead();
		Node slow = list.getHead();
		Stack<Integer> stack = new Stack<>();
		
		while(fast!=null && fast.getNext()!=null) {
			stack.push(slow.getData());
			slow=slow.getNext();
			fast=fast.getNext().getNext();
		}
		if(fast!=null) {
			slow=slow.getNext();
		}
		while(slow!=null) {
			int top = stack.pop().intValue();
			if(top != slow.getData()) {
				return false;
			}
			slow=slow.getNext();
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,3,2,1,0};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		list.printList();
		System.out.println("is Palindrome "+isPalindrome(list));
	}

}
