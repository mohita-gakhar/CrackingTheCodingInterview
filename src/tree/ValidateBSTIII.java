package tree;

import tree.util.TreeUtils;

public class ValidateBSTIII {
	
	public static boolean checkBST(TreeNode root) {
		return checkBST(root, null, null);
	}

	private static boolean checkBST(TreeNode root, Integer min, Integer max) {
		if(root == null) {
			return true;
		}
		if((min != null && root.data <= min) ||(max!=null && root.data > max)) {
			return false;
		}
		
		if(!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max)) {
			return false;
		}
		return true;
	}
	
	public static TreeNode createTestTree() {
		/* Create a random BST */
		TreeNode head = TreeUtils.randomBST(10, -10, 10); 
		
		/* Insert an element into the BST and potentially ruin the BST property */
		TreeNode node = head;
		do {
			int n = TreeUtils.randomIntInRange(-10, 10);
			int rand = TreeUtils.randomIntInRange(0, 5);
			if (rand == 0) {
				node.data = n;
			} else if (rand == 1) {
				node = node.left;
			} else if (rand == 2) {
				node = node.right;
			} else if (rand == 3 || rand == 4) {
				break;
			}
		} while (node != null);	
		
		return head;
	}
	
	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = {Integer.MIN_VALUE, 3, 5, 6, 10, 13, 15, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		node.left.data = 6; // "ruin" the BST property by changing one of the elements
		node.print();
		boolean isBst = checkBST(node);
		System.out.println(isBst);
	}

}
