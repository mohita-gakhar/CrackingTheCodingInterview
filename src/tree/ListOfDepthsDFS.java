package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import tree.util.TreeUtils;

/**
 * Time complexity is O(N)
 * Space complexity is O(N)
 * recursive stack : O(LogN)
 * @author Mohita
 *
 */
public class ListOfDepthsDFS {
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root)
	{
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevelLinkedList(root,lists,0);
		return lists;
	}

	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,int level) {
		if(root == null) {
			return;
		}
		LinkedList<TreeNode> list;
		if(lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeUtils.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
