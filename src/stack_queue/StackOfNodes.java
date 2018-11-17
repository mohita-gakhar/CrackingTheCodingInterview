package stack_queue;

import java.util.EmptyStackException;

public class StackOfNodes {
	
	private Node top;
	private Node bottom;
	private int capacity;
	private int size;
	
	public StackOfNodes(int capacity) {
		this.capacity=capacity;
	}
	
	public boolean isFull() {
		return capacity==size;
	}
	
	public boolean push(int value) {
		if(size >= capacity) {
			return false;
		}
		
		size++;
		Node node = new Node(value);
		if(size == 1) {
			bottom = node;
		}
		join(node, top);
		top = node;
		return true;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		size--;
		Node node = top;
		top = top.below;
		top.above=null;
		return node.value;
	}
	
	public void join(Node above , Node below) {
		if(above != null) {
			above.below = below;
		}
		if(below != null) {
			below.above = above;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int removeBottom() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		Node node = bottom;
		bottom = bottom.above;
		if(bottom != null) {
			bottom.below=null;
		}
		size--;
		return node.value;
	}

}
