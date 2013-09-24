package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Node {
	String data;
	boolean visited;

	List<Node> neighbours = new ArrayList<Node>();

	public Node(String data) {
		this.data = data;
	}

	public void addNeighBour(Node node) {
		neighbours.add(node);
		node.neighbours.add(this);
	}
}




class Graph {
	
	 List nodes = new ArrayList();


	public void breadthFirstTraversal(Node rootNode) {
		System.out.println("BFS:");
		
		LinkedList unvisitedNodes = new LinkedList();
		unvisitedNodes.add(rootNode);
		rootNode.visited = true;
		while (!unvisitedNodes.isEmpty()) {
			Node n = (Node) unvisitedNodes.poll();
			System.out.print(n.data + " ");
			for (Node adj : n.neighbours) {
				if (!adj.visited) {
					adj.visited = true;
					unvisitedNodes.add(adj);
				}
			}
		}

	}
	
	
	
	public void depthFirstTraversal(Node rootNode) {
		System.out.println("DFS:");
		
		Stack unvisitedNodes = new Stack();
		unvisitedNodes.push(rootNode);
		rootNode.visited = true;
		while (!unvisitedNodes.isEmpty()) {
			Node n = (Node) unvisitedNodes.pop();
			System.out.print(n.data + " ");
			for (Node adj : n.neighbours) {
				if (!adj.visited) {
					adj.visited = true;
					unvisitedNodes.push(adj);
				}
			}
			
		}

	}

}





class BfsDfs{
	
	public static void main(String[] args) {

		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");

		Graph g = new Graph();

		g.nodes.add(A);
		g.nodes.add(B);
		g.nodes.add(C);
		g.nodes.add(D);
		g.nodes.add(E);
		g.nodes.add(F);
		g.nodes.add(G);
		g.nodes.add(H);
		g.nodes.add(I);
		g.nodes.add(J);

		A.addNeighBour(C);
		A.addNeighBour(B);
		A.addNeighBour(E);

		B.addNeighBour(F);

		F.addNeighBour(I);

		I.addNeighBour(J);

		J.addNeighBour(E);
		J.addNeighBour(H);

		C.addNeighBour(G);
		C.addNeighBour(H);

		H.addNeighBour(D);

		g.breadthFirstTraversal(A);
		
		// commented since both DFS and BFS wont work one after another, 
		// since all nodes are changed to VISITED state.
		
		//g.depthFirstTraversal(A);
		
	}
}