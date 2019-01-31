package tree;

/**
 * Only works if there are 
 * no duplicates in an array
 * @author Mohita
 *
 */
public class ValidateBSTI {
	
	private static int index = 0;
	
	private static void copyBST(TreeNode root, int[] arr) {
		if(root == null) {
			return;
		}
		copyBST(root.left, arr);
		arr[index] = root.data;
		index++;
		copyBST(root.right, arr);
	}
	
	private static boolean checkBST(TreeNode root, int size) {
		int[] arr = new int[size];
		copyBST(root, arr);
		for(int i=1;i<arr.length;i++) {
			if(arr[i-1] >= arr[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node,array.length));

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
		index=0;
		condition = checkBST(node,array2.length);
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
		index =0;
		condition = checkBST(node,array3.length);
		System.out.println("should be false: " + condition);
	}

}
