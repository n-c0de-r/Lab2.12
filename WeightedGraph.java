import java.util.ArrayList;

/**
 * Main class that creates weighted graphs.
 * 
 * @author n-c0de-r
 * @author AlexanderStae
 * @version 11.07.2021
 */
public class WeightedGraph {

	protected int[][] matrix;
	
	protected int start = 0;
	protected int end = 0;

	protected ArrayList<Edge> edges;
	protected ArrayList<Vertex> vertices;
	
	/**
	 * Empty constructor.
	 */
	public WeightedGraph() {
		testGraph();
	}
	
	/**
	 * Creates a basic testing graph. Getting from A to E.
	 */
	private void testGraph() {
		// Create an ArrayList of vertices
		vertices = new ArrayList<>();
		vertices.add(new Vertex("A"));
		vertices.add(new Vertex("B"));
		vertices.add(new Vertex("C"));
		vertices.add(new Vertex("D"));
		vertices.add(new Vertex("E"));
		vertices.add(new Vertex("F"));
		vertices.add(new Vertex("G"));
		vertices.add(new Vertex("H"));

		// Create Edges connecting said vertices
		edges = new ArrayList<Edge>();
		edges.add(new Edge(vertices.get(0), vertices.get(3), 2));
		edges.add(new Edge(vertices.get(3), vertices.get(1), 15));
		edges.add(new Edge(vertices.get(1), vertices.get(4), 8));
		edges.add(new Edge(vertices.get(2), vertices.get(4), 6));
		edges.add(new Edge(vertices.get(2), vertices.get(0), 10));
		edges.add(new Edge(vertices.get(2), vertices.get(3), 5));
		edges.add(new Edge(vertices.get(3), vertices.get(5), 1));
		edges.add(new Edge(vertices.get(4), vertices.get(5), 1));
		edges.add(new Edge(vertices.get(0), vertices.get(6), 1));//Cheapest path
		edges.add(new Edge(vertices.get(1), vertices.get(6), 1));
		edges.add(new Edge(vertices.get(4), vertices.get(6), 1));
		edges.add(new Edge(vertices.get(0),vertices.get(4),27)); //Shortest path!
		edges.add(new Edge(vertices.get(5), vertices.get(7), 1));

		// Create a new quadratic matrix of size of all vertices
		matrix = new int[vertices.size()][vertices.size()];

		// Fill the matrix with weights of the edges
		for (int i = 0; i < edges.size(); i++) {
			Edge currentEdge = edges.get(i);
			Vertex startVertex = currentEdge.startVertex;
			Vertex endVertex = currentEdge.endVertex;
			int weight = currentEdge.weight;

			matrix[vertices.indexOf(startVertex)][vertices.indexOf(endVertex)] = weight;
			matrix[vertices.indexOf(endVertex)][vertices.indexOf(startVertex)] = weight;
		}
	}

}
