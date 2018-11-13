package linkedList;

/**
 * The idea is to compare element i to n-i
 * where n is the length
 * @author Mohita
 *
 */
public class IsPalindromeRecursiveII {
	
	private static boolean isPalindrome(LinkedList list) {
		int length = LinkedListUtils.getLength(list);
		Node head = list.getHead();
		Result res = isPalindrome(head,length);
		return res.result;
	}
	
	private static Result isPalindrome(Node head, int length) {
		if(head == null || length <=0) {
			return new Result(head, true);
		}else if(length==1) {
			return new Result(head.getNext(), true);
		}
		Result res= isPalindrome(head.getNext(), length-2);
		if(!res.result || res.node == null) {
			return res;
		}
		res.result = head.getData() == res.node.getData();
		res.node= res.node.getNext();
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,3,2,1,0};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		list.printList();
		System.out.println("is Palindrome "+isPalindrome(list));
	}

}

class Result{
	boolean result;
	Node node;
	
	public Result(Node node, boolean result) {
		this.node=node;
		this.result=result;
	}
}

