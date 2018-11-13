package stack_queue;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Implement 3 stacks from one array
 * Here the capacity of each stack is fixed
 * @author mmohita
 *
 */
public class FixedMultiStack {
	
	private int numberOfStacks=3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public FixedMultiStack(int stackCapacity){
		this.stackCapacity= stackCapacity;
		values = new int[stackCapacity*numberOfStacks];
		sizes= new int[numberOfStacks];
	}

	public void push(int stackNum,int item) throws FullStackException{
		if(isFull(stackNum)){
			throw new FullStackException();
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = item;
	}
	
	public int pop(int stackNum) throws EmptyStackException{
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		int topIndex=indexOfTop(stackNum);
		int value= values[topIndex];
		values[topIndex]=0;
		sizes[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws EmptyStackException{
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}

	private boolean isEmpty(int stackNum) {
		return sizes[stackNum]==0;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum*stackCapacity;
		int size= sizes[stackNum];
		return offset+size-1;
	}

	private boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	public int[] values(){
		return values;
	}
	
	public int[] getStackValues(int stackNum){
		int[] stack = new int[sizes[stackNum]];
		for(int i=0;i<stack.length;i++){
			stack[i]=values[stackNum*stackCapacity+i];
		}
		return stack;
	}
	
	public String stackToSTring(int stackNum){
		int[] items= getStackValues(stackNum);
		return Arrays.toString(items);
	}
	
	public void printStacks(){
		System.out.println(Arrays.toString(values));
	}
	
	
}
