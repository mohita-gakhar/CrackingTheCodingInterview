package tree;

public class ValidateBSTII {
	
	public static Integer last_printed = null;
	
	public static boolean checkBST(TreeNode root) {
		return checkBST(root, true);
	}
	
	//An equal value to parent is only allowed for the left child
	private static boolean checkBST(TreeNode root, boolean isLeft) {
		if(root == null) {
			return true;
		}
		if(!checkBST(root.left,true)) {
			return false;
		}
		
		if(last_printed != null) {
			if(isLeft) {
				if(root.data < last_printed) {
					return false;
				}
			}else {
				if(root.data >= last_printed) {
					return false;
				}
			}
			
		}
		
		last_printed = root.data;
		if(!checkBST(root.right, false)) {
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));

		test();
	}

	public static void test() {
		TreeNode node;
		boolean condition;
		System.out.println("test cases for equals condition.");

		/* Expect true: for left child: node.data <= last_printed.
   2
  / \
 /   \
 2   3
      \
      4
		*/
		int[] array2 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array2);
		node.left.data = 2;
		node.print();
		last_printed = null;
		condition = checkBST(node);
		System.out.println("should be true: " + condition);

		/* Expect false: for right child: node.data <= last_printed.
   2
  / \
 /   \
 1   2
      \
      4
		 */
		int[] array3 = {1, 2, 3, 4};
		node = TreeNode.createMinimalBST(array3);
		node.right.data = 2;
		node.print();
		last_printed = null;
		System.out.println("should be false: " + condition);
	}
}
