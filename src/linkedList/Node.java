package linkedList;

public class Node {
	
	private int data;
	private Node next;
	
	public Node(int data,Node next){
		this.data=data;
		this.next=next;
	}
	
	public Node(int data){
		this.data=data;
	}
	
	public Node() {
		
	}
	
	/**
	 * Useful when using a wrapper class 
	 * to store LinkedList head
	 * @param key
	 */
	public void setNext(int key){
		Node next=new Node(key);
		this.next=next;
	}
	
	/**
	 * Useful for basic implementation of singly LinkedList
	 * @param key
	 */
	public void appendToTail(int key){
		Node end= new Node(key);
		Node current=this;
		while(current.next!=null){
			current=current.next;
		}
		current.next=end;
	}

	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}
		
	public void setNext(Node next) {
		this.next = next;
	}

	public Node cloneNode(){
		Node newNode= new Node(data);
		newNode.setNext(next);
		return newNode;
	}
	
}
