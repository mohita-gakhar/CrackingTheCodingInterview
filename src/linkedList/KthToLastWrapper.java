package linkedList;

/**
 * As discussed, we can't return the node and counter at the same time
 * One way to do is create a wrapper class
 * @author Mohita
 *
 */
public class KthToLastWrapper {
	
	public static Node kthToLast(Node head, int k) {
		Index index= new Index();
		return kthToLast(head, k, index);
	}

	private static Node kthToLast(Node head, int k, Index index) {
		if(head==null) {
			return null;
		}
		Node node = kthToLast(head.getNext(), k, index);
		index.value+=1;
		if(index.value == k) {
			return head;
		}
		return node;
	}

	public static void main(String[] args) {
		int arr[] = {0,1,2,3,4,5,6};
		LinkedList list = LinkedListUtils.createFromArray(arr);
		for(int i=1;i<=arr.length;i++) {
			System.out.println("The element at "+i+ " position from last "+kthToLast(list.getHead(), i).getData());
		}

	}

}

class Index {
	public int value=0;
}
