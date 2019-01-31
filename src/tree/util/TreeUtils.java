package tree.util;

import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class TreeUtils {
	
	public static TreeNode createTreeFromArray(int[] arr) {
		if(arr.length <= 0) {
			return null;
		}
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean done = false;
		int i=1;
		while(!done) {
			TreeNode node = queue.peek();
			if(node.left == null) {
				node.left = new TreeNode(arr[i]);
				i++;
				queue.add(node.left);
			} else if(node.right == null) {
				node.right = new TreeNode(arr[i]);
				i++;
				queue.add(node.right);
			}else {
				queue.remove();
			}
			
			if (i == arr.length) {
				done = true;
			}
		}
		return root;
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static TreeNode randomBST(int N, int min, int max) {
		int d = randomIntInRange(min, max);
		TreeNode root = new TreeNode(d);
		for (int i = 1; i < N; i++) {
			root.insertInOrder(randomIntInRange(min, max));
		}
		return root;
	}

}
