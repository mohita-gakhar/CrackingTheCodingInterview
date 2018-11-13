package linkedList;

/**
 * Here linked lists are representation of
 * integral numbers, the idea is to sum them
 * Need a class to hold both Node and carry as
 * nodes are appended on the head this time
 * @author Mohita
 *
 */
public class SumListsForward {
	
	private static Node addLists(LinkedList l1, LinkedList l2) {
		int len1= length(l1);
		int len2 = length(l2);
		
		Node head1=l1.getHead();
		Node head2=l2.getHead();
		
		if(len1<len2) {
			head1=padList(head1,len2-len1);
		}else {
			head2=padList(head2, len1-len2);
		}
		PartialSum sum= addListsHelper(head1,head2);
		if(sum.carry!=0) {
			Node result= insertBefore(sum.sum, sum.carry);
			return result;
		}
		return sum.sum;
	}
	
	private static int length(LinkedList l2) {
		int size=0;
		Node node= l2.getHead();
		while(node != null) {
			size++;
			node= node.getNext();
		}
		return size;
	}
	
	private static Node padList(Node head, int len) {
		Node node= head;
		for(int i=0;i<len;i++) {
			node=insertBefore(node,0);
		}
		return node;
	}

	private static Node insertBefore(Node head, int data) {
		Node node= new Node(data);
		if(head!=null) {
			node.setNext(head);
		}
		return node;
	}
	
	private static PartialSum addListsHelper(Node l1, Node l2) {
		if(l1==null && l2==null) {
			return new PartialSum();
		}
		
		PartialSum sum= addListsHelper(l1.getNext(), l2.getNext());
		int val= sum.carry+l1.getData()+l2.getData();
		Node result = insertBefore(sum.sum, val%10);
		sum.sum = result;
		sum.carry = val/10;
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr1= {9,9,7};
		int[] arr2= {1,1};
		
		LinkedList l1= LinkedListUtils.createFromArray(arr1);
		LinkedList l2= LinkedListUtils.createFromArray(arr2);
		
		l1.printList();
		l2.printList();
		
		Node sum= addLists(l1, l2);
		LinkedList sumList = new LinkedList();
		sumList.setHead(sum);
		sumList.printList();

	}

}
