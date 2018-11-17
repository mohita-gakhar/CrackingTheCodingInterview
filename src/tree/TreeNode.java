package tree;

/**
 * One Node of a binary tree 
 * @author Mohita
 *
 */
public class TreeNode {
	
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int data;
	public int size;
	
	public TreeNode(int data) {
		this.data=data;
		size=1;
	}
	
	public void setLeftChild(TreeNode left) {
		this.left= left;
		if(left!=null) {
			this.left.parent=this;
		}
	}
	
	public void setRightChild(TreeNode right) {
		this.right = right;
		if(right!=null) {
			this.right.parent=this;
		}
	}
	
	public static TreeNode createMinimalBST(int[] arr) {
		return createMinimalBST(arr ,0 ,arr.length-1);
	}

	private static TreeNode createMinimalBST(int[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = start+(end-start)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.setLeftChild(createMinimalBST(arr, start, mid-1));
		node.setRightChild(createMinimalBST(arr, mid+1, end));
		return node;
	}

}
