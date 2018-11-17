package tree;

/**
 * Included all traversals
 * @author Mohita
 *
 */
public class Traversals {
	
	public static void visit(TreeNode node) {
		if(node != null) {
			System.out.print(node.data+" ");
		}
	}
	
	public static void inOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}
	
	public static void preOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public static void postOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		inOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);
	}

}
