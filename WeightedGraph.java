import java.util.ArrayList;

/**
 * Main class that creates weighted graphs
 * and checks cheapest and shortest distances.
 * 
 * @author	n-c0de-r
 * @author	AlexanderStae
 * @version	11.07.2021
 */
public class WeightedGraph {
	
	int[][] matrix;
	
	ArrayList<Edge> edgeList;
	ArrayList<Vertex> vertices;
	
	/**
	 * Constructor to make a new Graph with
	 * given number of vertices and edges.
	 * @param v	Number of vertices.
	 * @param e Number of Edges.
	 */
	public WeightedGraph(int v, int e) {
		generateVertices(v);
		generateEdges(e);
	}
	
	/**
	 * Empty constructor.
	 */
	public WeightedGraph() {
	}
	
	/**
	 * Checks any given matrix via Dijkstra's Algorithm.
	 * 
	 * @param start	The vertex to start path from.
	 * @param goal	The goal vertex to get to.
	 */
	public void checkMatrix(int start, int goal) {
		vertices.get(start).setDistance(0);
		Vertex end = vertices.get(goal);
		int nextCheck = 0;
		
		for (int i=nextCheck; i < vertices.size(); i++) {

			if (vertices.get(i).isVisited()) {
				i++;
			} else {
				
				int smallestDist = Integer.MAX_VALUE;
				
				Vertex thisVertex = vertices.get(i);

				int thisDist = thisVertex.getDistance();
				if (thisVertex.isVisited() && !(nextCheck == vertices.size()-1)) {
					nextCheck++;
					thisVertex = vertices.get(nextCheck);
				}
				
				
				for (int j=0; j < vertices.size(); j++) {
					
					Vertex current = vertices.get(j);
					
					if (matrix[i][j] !=0 && ((thisDist + matrix[i][j]) < current.getDistance()) && !thisVertex.isVisited()) {

						current.setPrevious(thisVertex);
						current.setDistance(thisDist + matrix[i][j]);

						if (thisDist + matrix[i][j] < smallestDist) {
							smallestDist = thisDist + matrix[i][j];
							nextCheck = j;
						}
					}
				}
				thisVertex.setVisited(true);
				i = nextCheck-1;
			}
		}
//		for (Vertex v : vertices) {
//			System.out.println("Distance to " + v.getName() + " is " + v.getDistance());
//		}
		System.out.println("Cheapest path to " + end.getName() + " is " + end.getDistance());
		String endName = end.getName();
		String path = endName;
		String lastName = "";
		Vertex checking = end;
		while (checking.getPrevious() != null) {
			checking = checking.getPrevious();
			lastName = checking.getName();
			path = path + " <-- " + lastName;
			
		}
		System.out.println("Path to " + endName + " is " + path);
	}
	
	private void generateEdges(int num) {
		edgeList = new ArrayList<Edge>();
		for (int i=0; i < num; i++) {
			
		}
	}
	
	private void generateVertices(int num) {
		vertices = new ArrayList<>();
	}
	
	/**
	 * Creates a basic testing graph.
	 */
	public void testGraph() {
		//Create an ArrayList of vertices
		vertices = new ArrayList<>();
		vertices.add(new Vertex("A"));
		vertices.add(new Vertex("B"));
		vertices.add(new Vertex("C"));
		vertices.add(new Vertex("D"));
		vertices.add(new Vertex("E"));
		vertices.add(new Vertex("F"));
		vertices.add(new Vertex("G"));
		
		//Create Edges connecting said vertices
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(vertices.get(0),vertices.get(3),2));
		edgeList.add(new Edge(vertices.get(3),vertices.get(1),15));
		edgeList.add(new Edge(vertices.get(1),vertices.get(4),8));
		edgeList.add(new Edge(vertices.get(2),vertices.get(4),6));
		edgeList.add(new Edge(vertices.get(2),vertices.get(0),10));
		edgeList.add(new Edge(vertices.get(2),vertices.get(3),5));
		edgeList.add(new Edge(vertices.get(3),vertices.get(5),1));
		edgeList.add(new Edge(vertices.get(4),vertices.get(5),1));
		edgeList.add(new Edge(vertices.get(0),vertices.get(6),1));
		edgeList.add(new Edge(vertices.get(1),vertices.get(6),1));
		edgeList.add(new Edge(vertices.get(4),vertices.get(6),1));
		edgeList.add(new Edge(vertices.get(0),vertices.get(4),27)); //Shortest path!
		
		//Create a new quadratic matrix of size of all vertices
		matrix = new int[vertices.size()][vertices.size()];
		
		//Fill the matrix with weights of the edges
		for (int i=0; i<edgeList.size(); i++) {
			Edge currentEdge2 = edgeList.get(i);
			Vertex startVertex = currentEdge2.startVertex;
			Vertex endVertex = currentEdge2.endVertex;
			int weight = currentEdge2.weight;
			
			matrix[vertices.indexOf(startVertex)][vertices.indexOf(endVertex)] = weight;
			matrix[vertices.indexOf(endVertex)][vertices.indexOf(startVertex)] = weight;
		}
	}

}
