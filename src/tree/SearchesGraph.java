package tree;

import stack_queue.Queue;
import util.GraphNodeState;

/**
 * Implementation of Depth First search
 * and breadth first search in Graph
 * @author Mohita
 *
 */
public class SearchesGraph {
	
	private static void searchDFS(Node root) {
		if(null == root) {
			return;
		}
		visit(root);
		root.state = GraphNodeState.Visited;
		for(Node n : root.getAdjacent()) {
			if(n.state != GraphNodeState.Visited) {
				searchDFS(n);
			}
		}
	}
	
	private static void searchBFS(Node root) {
		Queue<Node> queue = new Queue<>();
		root.state = GraphNodeState.Visited;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			visit(node);
			for(Node n : node.getAdjacent()) {
				if(n.state != GraphNodeState.Visited) {
					n.state = GraphNodeState.Visited;
					queue.add(n);
				}
			}
		}
	}

	private static void visit(Node root) {
		System.out.print(root.getVertex()+" ");
	}

}
