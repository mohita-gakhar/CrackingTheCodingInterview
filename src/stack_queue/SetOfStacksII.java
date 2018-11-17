package stack_queue;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacksII {
	
	private List<StackOfNodes> stacks = new ArrayList<>();
	private int capacity;
	
	public SetOfStacksII(int capacity) {
		this.capacity=capacity;
	}
	
	public int popAt(int index) {
		return leftShift(index , true);
	}
	
	public void push(int value) {
		StackOfNodes lastStack = getLastStack();
		if(lastStack != null && !lastStack.isFull()) {
			lastStack.push(value);
		}else {
			StackOfNodes newStack = new StackOfNodes(capacity);
			newStack.push(value);
			stacks.add(newStack);
		}
	}

	private StackOfNodes getLastStack() {
		if(stacks.isEmpty()) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}

	private int leftShift(int index, boolean removeFromTop) {
		StackOfNodes stack = stacks.get(index);
		int value;
		if(removeFromTop) {
			value = stack.pop();
		}else {
			value = stack.removeBottom();
		}		
		if(stack.isEmpty()) {
			stacks.remove(index);
		}else if(stacks.size() > (index+1)) {
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return value;
	}

	public static void main(String[] args) {
			int capacity_per_substack = 5;
			SetOfStacksII set = new SetOfStacksII(capacity_per_substack);
			for (int i = 0; i < 34; i++) {
				set.push(i);
			}
			for (int i = 5; i >=0; i--) {
				System.out.println("Popped " + set.popAt(i));
			}		
	}

}
