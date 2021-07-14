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
public class RandomGraph {

	private int[][] matrix;

	private ArrayList<Edge> edgeList;
	private ArrayList<Vertex> vertices;
	
	private int start = 0;
	private int end = 0;

	/**
	 * Constructor to make a new Graph with given number of vertices and edges.
	 * 
	 * @param v Number of vertices.
	 * @param e Number of Edges.
	 */
	public RandomGraph(int v, int e) {
		generateMatrix(v, e);
	}

	/**
	 * Checks any given matrix via Dijkstra's Algorithm
	 * finding the cheapest path from start to goal.
	 * 
	 * @param start The vertex to start path from.
	 * @param goal  The goal vertex to get to.
	 */
	private void cheapestPath(int start, int goal) {
		// Initialize the amount of vertices to check
		int toVisit = vertices.size();

		// Initialize the start vertex
		Vertex thisVertex = vertices.get(start);
		thisVertex.setDistance(0);
		int thisDist = thisVertex.getDistance();

		int nextCheck = start;

		// While not all are checked
		while (toVisit != 0) {
			// Get the current vertex
			thisVertex = vertices.get(nextCheck);
			thisDist = thisVertex.getDistance();
			thisVertex.setVisited(true);

			// Check all neighboring vertices
			for (int i = 0; i < vertices.size(); i++) {
				Vertex current = vertices.get(i);

				// If the current vertices sum of distances is lower, update the current vertex
				if (matrix[nextCheck][i] != 0
					&& (thisDist + matrix[nextCheck][i]) < current.getDistance()
					&& !current.isVisited()) {
					current.setPrevious(thisVertex);
					current.setDistance(thisDist + matrix[nextCheck][i]);
				}
			}

			int smallestDist = Integer.MAX_VALUE;

			// Find the next unvisited vertex with the smallest distance to check next
			for (int i = 0; i < vertices.size(); i++) {
				if (vertices.get(i).isVisited()) {
					continue;
				} else {
					if (vertices.get(i).getDistance() < smallestDist) {
						smallestDist = vertices.get(i).getDistance();
						nextCheck = i;
					}
				}
			}
			toVisit--;
		}
		getPath("cheap", vertices.get(start), vertices.get(goal));
	}
	
	public void cheapestPath() {
		cheapestPath(start, end);
	}

	/**
	 * Checks any given matrix via Dijkstra's Algorithm
	 * finding the shortest path from start to goal.
	 * 
	 * @param start The vertex to start path from.
	 * @param goal  The goal vertex to get to.
	 */
	private void shortestPath(int start, int goal) {
		// Initialize the amount of vertices to check
		int toVisit = vertices.size();

		// Initialize the start vertex
		Vertex thisVertex = vertices.get(start);
		thisVertex.setDistance(0);
		int thisDist = thisVertex.getDistance();

		int nextCheck = start;

		// While not all are checked
		while (toVisit != 0) {
			// Get the current vertex
			thisVertex = vertices.get(nextCheck);
			thisDist = thisVertex.getDistance();
			thisVertex.setVisited(true);

			// Check all neighboring vertices
			for (int i = 0; i < vertices.size(); i++) {
				Vertex current = vertices.get(i);

				// If the current vertices sum of distances is lower, update the current vertex
				if (matrix[nextCheck][i] != 0
					&& (thisDist + 1) < current.getDistance()
					&& !current.isVisited()) {
					current.setPrevious(thisVertex);
					current.setDistance(1);
				}
			}

			int smallestDist = Integer.MAX_VALUE;

			// Find the next unvisited vertex with the smallest distance to check next
			for (int i = 0; i < vertices.size(); i++) {
				if (vertices.get(i).isVisited()) {
					continue;
				} else {
					if (vertices.get(i).getDistance() < smallestDist) {
						smallestDist = vertices.get(i).getDistance();
						nextCheck = i;
					}
				}
			}
			toVisit--;
		}
		getPath("short", vertices.get(start), vertices.get(goal));
	}
	
	public void shortestPath() {
		shortestPath(start, end);
	}

	/**
	 * Generates edges for the matrix.
	 * 
	 * @param num Number of edges to create.
	 */
	private void generateEdges(int num) {
		edgeList = new ArrayList<Edge>();

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
			edgeList.add(new Edge(vertices.get(v1), vertices.get(v2), w));
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
			Edge currentEdge = edgeList.get(i);
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
	
	/**
	 * Method that returns the resulting path.
	 * 
	 * @param end The goal vertex.
	 */
	private void getPath(String type, Vertex start, Vertex end) {

		// After all is done, print out all distances. not really needed.
//		for (Vertex v : vertices) {
//			System.out.println("Distance to " + v.getName() + " is: " + v.getDistance());
//		}

		// When all is finished print the cheapest or shortest path to the end
		System.out.println("The " + type + "est path from " + start.getName() + " to " + end.getName() + " is: "
				+ end.getDistance());

		String endName = end.getName();
		String path = endName;
		String lastName = "";
		Vertex checking = end;
		while (checking.getPrevious() != null) {
			checking = checking.getPrevious();
			lastName = checking.getName();
			path = path + " <-- " + lastName;

		}
		System.out.println("The full " + type + "est path is: " + path);
		System.out.println();
		
		//Reset visited vertices after printout for next method
		resetVisits();
	}
	
	/**
	 * Resets all vertices to unvisited.
	 */
	private void resetVisits() {
		for (Vertex v : vertices) {
			v.setVisited(false);
			v.setDistance(Integer.MAX_VALUE);
		}
	}

}
