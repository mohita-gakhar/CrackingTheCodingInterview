package stack_queue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SetOfStacksI {
	
	List<Stack<Integer>> stacks = new ArrayList<>();
	private int capacity;
	
	public SetOfStacksI(int capacity) {
		this.capacity=capacity;
	}
	
	public void push(int value) {
		Stack<Integer> lastStack = getLastStack();
		if(lastStack != null && !isFull(lastStack)) {
			lastStack.push(value);
		}else {
			Stack<Integer> newStack = new Stack<>();
			newStack.push(value);
			stacks.add(newStack);
		}
	}
	
	public int pop() {
		Stack<Integer> stack = getLastStack();
		if(stack == null || stack.isEmpty()) {
			throw new EmptyStackException();
		}
		int value = stack.pop();
		if(stack.isEmpty()) {
			stacks.remove(stacks.size()-1);
		}
		return value;
	}
	
	private boolean isFull(Stack<Integer> lastStack) {
		return lastStack.size()==capacity;
	}

	private Stack<Integer> getLastStack() {
		if(stacks.isEmpty()) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}
	
	public boolean isEmpty() {
		Stack<Integer> stack = getLastStack();
		return stack==null || stack.isEmpty();
	}
	
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacksI set = new SetOfStacksI(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 35; i++) {
			System.out.println("Popped " + set.pop());
		}	

	}

}
