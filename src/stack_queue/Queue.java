package stack_queue;

import java.util.NoSuchElementException;

public class Queue<T> {

	private static class QueueNode<T>{
		T data;
		QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data=data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> node = new QueueNode<T>(item);
		if(last != null){
			last.next=node;
		}
		last=node;
		if(first == null){
			first=last;
		}
	}
	
	public T remove() throws NoSuchElementException{
		if(first == null){
			throw new NoSuchElementException();
		}
		T item = first.data;
		first=first.next;
		if(first == null){
			last = null;
		}
		return item;
	}
	
	public T peek() throws NoSuchElementException{
		if(first == null){
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
}
