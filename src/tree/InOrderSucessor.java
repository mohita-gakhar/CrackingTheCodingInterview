package tree;

public class InOrderSucessor {
	
	public static TreeNode inOrderSucc(TreeNode root) {
		if(null == root) {
			return null;
		}
		
		if(root.parent == null || root.right != null) {
			return leftMostChild(root.right);
		}
		
		TreeNode node = root;
		TreeNode parent = root.parent;
		
		while(parent != null && parent.left != node) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}

	private static TreeNode leftMostChild(TreeNode node) {
		if(node == null) {
			return null;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inOrderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
