package stack_queue;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * Flexible division of array
 * when one stack exceeds its initial capacity, we 
 * grow the allowable capacity and shifts elements as necessary
 * array is circular such that final stack can start at the end of 
 * the array and wrap around at the beginning
 * @author Mohita
 *
 */
public class MultiStack {
	
	private class StackInfo{
		public int start,size,capacity;
		public StackInfo(int start, int capacity) {
			this.start=start;
			this.capacity=capacity;
		}
		public boolean isFull() {
			return size == capacity;
		}
		public int lastCapacityIndex() {
			return adjustIndex(start+capacity-1);
		}
		public boolean isWithinCapacity(int index) {
			if(index<0 || index>=values.length) {
				return false;
			}
			int contiguousIndex = index<start? index+values.length: index;
			int end = start+capacity;
			return start<=contiguousIndex && contiguousIndex<end;
		}
		public int lastElementIndex() {
			return adjustIndex(size+start-1);
		}
		public boolean isEmpty() {
			return size==0;
		}
	}
	
	private StackInfo[] info;
	private int[] values;
	
	public MultiStack(int numberOfStacks, int defaultSize) {
		info = new StackInfo[numberOfStacks];
		for(int i=0;i<numberOfStacks;i++) {
			info[i]= new StackInfo(i*defaultSize, defaultSize);
		}
		values = new int[numberOfStacks*defaultSize];
	}
	
	public void push(int stackNum, int value) throws FullStackException {
		System.out.println("Pushing element "+value+" in stack "+stackNum);
		if(areAllStacksFull()) {
			throw new FullStackException();
		}
		StackInfo stack = info[stackNum];
		if(stack.isFull()) {
			expand(stackNum);
		}
		stack.size++;
		values[stack.lastElementIndex()] = value;
	}
	
	public int pop(int stackNum) throws EmptyStackException{
		System.out.println("Popping element from stack "+stackNum);
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()){
			throw new EmptyStackException();
		}
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}
	
	public int peek(int stackNum) throws EmptyStackException{
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return values[stack.lastElementIndex()];
	}

	private void expand(int stackNum) {
		System.out.println("Expanding stack "+ stackNum);
		shift((stackNum+1)%info.length);
		info[stackNum].capacity++;
	}

	private void shift(int stackNum) {
		System.out.println("Shifting stack "+stackNum);
		StackInfo stack = info[stackNum];
		
		if(stack.size>=stack.capacity) {
			shift((stackNum+1)%info.length);
			stack.capacity++;
		}
		
		int index= stack.lastCapacityIndex();
		while(stack.isWithinCapacity(index)) {
			values[index]=values[previousIndex(index)];
			index=previousIndex(index);
		}
		
		values[stack.start]=0;
		stack.start=nextIndex(stack.start);
		stack.capacity--;
	}

	private int nextIndex(int start) {
		return adjustIndex(start+1);
	}

	private int previousIndex(int index) {
		return adjustIndex(index-1);
	}

	private boolean areAllStacksFull() {
		return numberOfElements() == values.length;
	}

	private int numberOfElements() {
		int totalSize=0;
		for(StackInfo stInfo : info) {
			totalSize+=stInfo.size;
		}
		return totalSize;
	}
	
	private int adjustIndex(int index) {
		int max=values.length;
		return ((index%max)+max)%max;
	}
	
	private void printStacks() {
		System.out.println(Arrays.toString(values));
	}

	public static void main(String[] args) throws Exception {
		MultiStack stacks = new MultiStack(3, 4);
		stacks.printStacks();
		stacks.push(0, 10);
		stacks.printStacks();
		stacks.push(1, 20);
		stacks.printStacks();
		stacks.push(2, 30);
		stacks.printStacks();
		
		stacks.push(1, 21);
		stacks.printStacks();
		stacks.push(0, 11);
		stacks.printStacks();
		stacks.push(0, 12);
		stacks.printStacks();
		
		stacks.pop(0);
		stacks.printStacks();
		
		stacks.push(2, 31);
		stacks.printStacks();
		
		stacks.push(0, 13);
		stacks.printStacks();
		stacks.push(1, 22);
		stacks.printStacks();
		
		stacks.push(2, 31);
		stacks.printStacks();
		stacks.push(2, 32);
		stacks.printStacks();
		stacks.push(2, 33);
		stacks.printStacks();
		stacks.push(2, 34);
		stacks.printStacks();
		
		stacks.pop(1);
		stacks.printStacks();
		stacks.push(2, 35);
		stacks.printStacks();
	}

}
