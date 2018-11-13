package linkedList;

/**
 * This uses recursive approach to return kth element
 * Takes O(n) and is generally cleaner
 * Algo is traverse through the liked list and when it reaches end, return 0
 * each parent call will add 1 to this and when int equals k 
 * means we got the element
 * How do we return both the node and int through the stack
 * @author Mohita
 *
 */
public class KthToLast {
	
	/**
	 * Time and space complexity is O(N)
	 * k=1 means last element, k=2 means second last and so on
	 * @param head
	 * @param k
	 * @return
	 */
	private static int printKthToLast(Node head,int k) {
		if(head==null) {
			return 0;
		}
		int index = printKthToLast(head.getNext(), k)+1;
		if(index==k) {
			System.out.println("The element at "+k+" th from last is "+head.getData());
		}
		return index;
	}
	
	public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		for(int i=1;i<=arr.length;i++) {
			printKthToLast(list.getHead(), i);
		}

	}

}
