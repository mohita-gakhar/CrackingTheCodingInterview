package tree;

/**
 * Graph class
 * @author Mohita
 *
 */
public class Graph {
	
	public static int MAX_VERTICES = 6;	
	private Node[] vertices;
	public int count;
	
	public Graph() {
		count=0;
		vertices = new Node[MAX_VERTICES];
	}
	
	public void addNode(Node node) {
		if(count < vertices.length) {
			vertices[count] = node;
			count++;
		}else {
			System.out.println("Graph is Full");
		}
	}	
	
	public Node[] getNodes() {
        return vertices;
    }
}
