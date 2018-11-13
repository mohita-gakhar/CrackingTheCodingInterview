package linkedList;

public class LinkedList {
	
	private Node head;
	private int size=0;

	public Node getHead() {
		return head;
	}
	
	public LinkedList(int data) {
		Node node= new Node(data);
		head=node;
		size++;
	}
	
	public LinkedList(Node node) {
		this.setHead(node);
		size++;
	}
	
	public LinkedList() {
		
	}
	
	public void appendToHead(int data) {
		Node node = new Node(data);
		node.setNext(head);
		head= node;
		size++;
	}

	public void appendToTail(int data) {
		Node current= head;
		while(current.getNext() != null) {
			current=current.getNext();
		}
		current.setNext(new Node(data));
		size++;
	}
	
	public void setHead(Node head) {
		this.head=head;
	}
	
	public void printList(){
		if(head==null) {
			return;
		}
		Node current = head;
		while(current != null) {
			String sep = "->";
			if(current.getNext() == null) {
				sep="";
			}
			System.out.print(current.getData()+sep);
			current=current.getNext();
		}
		System.out.println();
	}
	
	public int getSize(){
		return size;
	}
}
