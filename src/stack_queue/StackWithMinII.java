package stack_queue;

/**
 * Here we are storing the mins
 * in a stack
 * Its space efficient that previous 
 * one as we are just storing a bunch of mins
 * @author Mohita
 *
 */
public class StackWithMinII extends Stack<Integer>{
	
	private Stack<Integer> mins;
	
	public StackWithMinII() {
		mins=new Stack<>();
	}
	
	public void push(int value) {
		if(value <= min()) {
			mins.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		Integer value = super.pop();
		if(value == min()) {
			mins.pop();
		}
		return value;
	}

	public int min() {
		if(mins.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return mins.peek();
	}

	public static void main(String[] args) {
		StackWithMinII stack = new StackWithMinII();
		int[] array = {0,2, 1, 3, 1};
		for (int value : array) {
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		System.out.println("Mins stack size "+stack.mins.size());
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop() + ", and min value is " + stack.min());
		}
	}

}
