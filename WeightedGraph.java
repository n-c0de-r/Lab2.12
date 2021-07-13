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
		//Set the distance of the first vertex to zero.
		//And make it the next to be checked
		vertices.get(start).setDistance(0);
		int nextCheck = start;
		
		//Check the respective Vertex and it's connections
		for (int i=nextCheck; i < vertices.size(); i++) {
			
			//If it has been visited, check the next in line
			if (vertices.get(i).isVisited()) {
				i++; //Skip current vertex
				
			} else {
				//Set the smallest distance to infinity
				int smallestDist = Integer.MAX_VALUE;
				//Set the 
				Vertex thisVertex = vertices.get(i);
				
				//Get the distance of the currently checked vertex.
				int thisDist = thisVertex.getDistance();
				
				for (int j=0; j < vertices.size(); j++) {
					//Same as above for connected vertices
					Vertex current = vertices.get(j);
					
					//If the calculated distance is less than the current, recalculate it
					if (matrix[i][j] !=0 && ((thisDist + matrix[i][j]) < current.getDistance()) && !thisVertex.isVisited()) {
						
						//Set the checked vortex' predecessor to the main one accordingly
						//And recalculate the distance to sum of this vertex and the edges weight.
						current.setPrevious(thisVertex);
						current.setDistance(thisDist + matrix[i][j]);

						//re-calibrate the current rows smallest distance, to find the next vertex to check
						if (thisDist + matrix[i][j] < smallestDist) {
							smallestDist = thisDist + matrix[i][j];
							nextCheck = j;
						}
					}
				}
				//After all connections are checked, this main vertex is done & visited!
				thisVertex.setVisited(true);
				//Reduce by one, as auto-increment will correct in the next for-run
				i = nextCheck-1;
			}
		}
		getPath(vertices.get(goal));
	}
	
	/**
	 * Method that returns the resulting path.
	 * @param end	The goal vertex.
	 */
	private void getPath(Vertex end) {
		//After all is done, print out all distances. not really needed.
//		for (Vertex v : vertices) {
//			System.out.println("Distance to " + v.getName() + " is " + v.getDistance());
//		}
		
		//When all is finished print the cheapest path to the end
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
	
	/**
	 * Generates edges for the matrix.
	 * @param num	Number of edges to create.
	 */
	private void generateEdges(int num) {
		edgeList = new ArrayList<Edge>();
		for (int i=0; i < num; i++) {
			
		}
	}
	
	/**
	 * Generates vertices for the matrix.
	 * @param num	Number of vertices to create.
	 */
	private void generateVertices(int num) {
		NameGenerator n = new NameGenerator();
		ArrayList<String> names = n.getNames();
		
		vertices = new ArrayList<>();
	}
	
	/**
	 * Creates a basic testing graph.
	 * Getting from A to E.
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
			Edge currentEdge = edgeList.get(i);
			Vertex startVertex = currentEdge.startVertex;
			Vertex endVertex = currentEdge.endVertex;
			int weight = currentEdge.weight;
			
			matrix[vertices.indexOf(startVertex)][vertices.indexOf(endVertex)] = weight;
			matrix[vertices.indexOf(endVertex)][vertices.indexOf(startVertex)] = weight;
		}
	}

}
