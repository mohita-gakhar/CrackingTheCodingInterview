package linkedList;

/**
 * Here you have two linked list which are 
 * representation of integral numbers in reverse
 * @author Mohita
 *
 */
public class SumListsReverse {
	
	private static Node addLists(LinkedList l1,LinkedList l2) {
		return addLists(l1.getHead(), l2.getHead(), 0);
	}
	
	/**
	 * Time and space complexity is O(N)
	 * where n is length of larger of linked list
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return
	 */
	private static Node addLists(Node l1,Node l2,int carry) {
		if(null==l1 && null==l2 && carry==0) {
			return null;
		}
		Node result= new Node();
		int value = carry;
		if(l1 != null) {
			value+=l1.getData();
		}
		if(l2 != null) {
			value+=l2.getData();
		}
		result.setData(value%10);
		if(l1 != null || l2!=null) {
			Node next= addLists(l1==null?null:l1.getNext(), l2==null?null:l2.getNext(), value>=10?1:0);
			result.setNext(next);
		}
		return result;
	}
	
	public static int linkedListToInt(Node list) {
		int value=0;
		if(list.getNext() != null) {
			value=10*linkedListToInt(list.getNext());
		}
		return value+list.getData();
	}

	public static void main(String[] args) {
		int[] arr1= {9,9,7};
		int[] arr2= {1,1};
		
		LinkedList l1= LinkedListUtils.createFromArray(arr1);
		LinkedList l2= LinkedListUtils.createFromArray(arr2);
		
		System.out.println("The number 1 "+linkedListToInt(l1.getHead()));
		System.out.println("The number 2 "+linkedListToInt(l2.getHead()));
		
		Node sum= addLists(l1, l2);
		System.out.println("Their sum is "+linkedListToInt(sum));

	}

}
