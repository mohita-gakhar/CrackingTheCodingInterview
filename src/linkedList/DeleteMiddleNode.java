package linkedList;

/**
 * The idea is that the node is given(not surely middle)
 * don't have access to the head and we need to delete it
 * doesn't include first and last element
 * @author Mohita
 *
 */
public class DeleteMiddleNode {
	
	private static boolean deleteMiddleNode(Node node) {
		if(node == null || node.getNext() == null) {
			return false;
		}
		node.setData(node.getNext().getData());
		node.setNext(node.getNext().getNext());
		return true;
	}

	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5,6};
		LinkedList list= LinkedListUtils.createFromArray(arr);
		list.printList();
		deleteMiddleNode(list.getHead().getNext().getNext().getNext().getNext());
		list.printList();
	}

}
