package stack_queue;

import java.util.Stack;

import util.Utils;

/**
 * Time complexity is O(N^2)
 * and sspace is O(N)
 * @author Mohita
 *
 */
public class SortStack {
	
	public static void sort(Stack<Integer> stack) {
		
		Stack<Integer> buffer = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			while(!buffer.isEmpty() && buffer.peek() > temp) {
				stack.push(buffer.pop());
			}
			buffer.push(temp);
		}
		
		while(!buffer.isEmpty()) {
			stack.push(buffer.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			int r = Utils.randomIntInRange(0,  1000);
			s.push(r);
		}
		
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

}
