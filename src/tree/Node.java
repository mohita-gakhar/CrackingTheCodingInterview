package tree;

import util.GraphNodeState;

public class Node {
	
	private Node[] adjacent;
	public int adjacentCount;
	private String vertex;
	public GraphNodeState state;
	
	public Node(String vertex, int adjacentLength) {
		this.vertex = vertex;
		this.adjacentCount = 0;
		this.adjacent = new Node[adjacentLength];
		this.state = GraphNodeState.Unvisited;
	}
	
	public void addAdjacent(Node node) {
		if(adjacentCount < adjacent.length) {
			adjacent[adjacentCount] = node;
			adjacentCount++;
		}else {
			System.out.println("No more vertext can be added");
		}
	}
	
	public Node[] getAdjacent() {
		return adjacent;
	}
	
	public String getVertex() {
		return vertex;
	}

}
