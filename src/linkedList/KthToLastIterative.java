package linkedList;

/**
 * More optimal but less straightforward iteratively
 * Runner technique
 * Time complexity is O(N)
 * and space complexity is O(1)
 * @author Mohita
 *
 */
public class KthToLastIterative {
	
	private static Node kthToLast(Node head, int k) {
		Node fast = head;
		Node slow = head;
		for(int i=0;i<k;i++) {
			if(fast==null) {
				return null;
			}
			fast=fast.getNext();
		}
		while(fast != null) {
			fast=fast.getNext();
			slow=slow.getNext();
		}
		return slow;
	}

	public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		for(int i=1;i<=arr.length;i++) {
			System.out.println("The element at "+i+ " position from last "+kthToLast(list.getHead(), i).getData());
		}
	}

}
