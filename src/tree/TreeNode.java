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
	
	public boolean isBST() {
		if(left != null) {
			if(data < left.data || !left.isBST()) {
				return false;
			}
		}
		
		if(right != null) {
			if(data >= right.data || !right.isBST()) {
				return false;
			}
		}
		return true;
	}
	
	public int height() {
		int leftHeight= left != null? left.height(): 0;
		int rightHeight = right!=null ? right.height() :0;
		return 1+Math.max(leftHeight, rightHeight);
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
	
	public void insertInOrder(int d) {
		if(d <= data) {
			if(left == null) {
				setLeftChild(new TreeNode(d));
			}else {
				left.insertInOrder(d);
			}
		}else {
			if(right == null) {
				setRightChild(new TreeNode(d));
			}else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

}
