import java.util.ArrayList;
import java.util.Random;

/**
 * Main class that creates weighted graphs and checks cheapest and shortest
 * distances.
 * 
 * @author n-c0de-r
 * @author AlexanderStae
 * @version 11.07.2021
 */
public class RandomGraph extends WeightedGraph {

	/**
	 * Constructor to make a new random Graph with given
	 * number of vertices and edges. Subclass to WeightedGraph.
	 * 
	 * @param v Number of vertices.
	 * @param e Number of Edges.
	 */
	public RandomGraph(int v, int e) {
		super();
		generateMatrix(v, e);
	}

	/**
	 * Generates edges for the matrix.
	 * 
	 * @param num Number of edges to create.
	 */
	private void generateEdges(int num) {
		edges = new ArrayList<Edge>();

		for (int i = 0; i < num; i++) {
			Random rng = new Random();
			int v1 = rng.nextInt(vertices.size());
			int v2 = rng.nextInt(vertices.size());
			int w = rng.nextInt(42) + 1;

			// If the edge already exists, regenerate numbers
			while (matrix[v1][v2] != 0 || matrix[v2][v1] != 0) {
				v1 = rng.nextInt(vertices.size());
				v2 = rng.nextInt(vertices.size());
			}
			edges.add(new Edge(vertices.get(v1), vertices.get(v2), w));
		}
	}
	
	/**
	 * Generates Ends for a path in the matrix.
	 * @param num	Number of vertices to chose from.
	 */
	private void generateEnds(int v) {
		Random rng = new Random();
		
		while (start == end) {
			start = rng.nextInt(v);
			end = rng.nextInt(v);
		}
	}
	
	/**
	 * Generates a new matrix of edges and vertices
	 * 
	 * @param v Number of vertices to create.
	 * @param e Number of edges to create.
	 */
	private void generateMatrix(int v, int e) {
		// Create a new quadratic matrix of size of all vertices
		matrix = new int[v][v];

		generateVertices(v);
		generateEdges(e);
		generateEnds(v);

		// Fill the matrix with weights of the edges
		for (int i = 0; i < e; i++) {
			Edge currentEdge = edges.get(i);
			Vertex startVertex = currentEdge.startVertex;
			Vertex endVertex = currentEdge.endVertex;
			int weight = currentEdge.weight;

			matrix[vertices.indexOf(startVertex)][vertices.indexOf(endVertex)] = weight;
			matrix[vertices.indexOf(endVertex)][vertices.indexOf(startVertex)] = weight;
		}
	}

	/**
	 * Generates vertices for the matrix.
	 * 
	 * @param num Number of vertices to create.
	 */
	private void generateVertices(int num) {
		NameGenerator n = new NameGenerator();
		ArrayList<String> names = n.getNames();

		vertices = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Random rng = new Random();
			int r = rng.nextInt(names.size());
			vertices.add(new Vertex(names.get(r)));
			names.remove(r);
		}
	}
}
