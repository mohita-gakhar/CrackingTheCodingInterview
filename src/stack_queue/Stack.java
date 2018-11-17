package stack_queue;

import java.util.EmptyStackException;

public class Stack<T> {
	private static class StackNode<T>{
		T data;
		StackNode<T> next;
		
		public StackNode(T data) {
			this.data=data;
		}
	}
	
	private StackNode<T> top;
	private int size;
	
	public void push(T item){
		StackNode<T> node = new StackNode<T>(item);
		node.next=top;
		top=node;
		size++;
	}
	
	public T pop() throws EmptyStackException{
		if(top==null){
			throw new EmptyStackException();
		}
		T item = top.data;
		top=top.next;
		size--;
		return item;
	}
	
	public T peek() throws EmptyStackException{
		if(top==null){
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public int size() {
		return size;
	}
}
