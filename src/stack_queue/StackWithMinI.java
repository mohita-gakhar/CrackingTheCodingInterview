package stack_queue;

/**
 * Here we are tracking min value
 * at evry node of the stack
 * @author Mohita
 *
 */
public class StackWithMinI extends Stack<NodeWithMin>{
	
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	/**
	 * Issue with this is that if we have
	 * a large stack we are wasting a lot of space
	 * by keeping track of min at every element
	 * @return
	 */
	public int min() {
		if(this.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return this.peek().min;
	}

	public static void main(String[] args) {
		StackWithMinI stack = new StackWithMinI();
		int[] array = {2, 1, 3, 1};
		for (int value : array) {
			stack.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop().value + "and min now is , " + stack.min());
		}
	}

}

class NodeWithMin
{
	int value;
	int min;
	
	public NodeWithMin(int value, int min) {
		this.value=value;
		this.min=min;
	}
}
