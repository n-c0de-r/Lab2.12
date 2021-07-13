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
	
	int vertex = 5;
	int[][] matrix = new int[vertex][vertex];
	
	ArrayList<Edge> edgeList;
	ArrayList<Vertex> vertices;
	
	/**
	 * Empty constructor.
	 */
	public WeightedGraph() {
		
	}
	
	/**
	 * Creates a basic testing graph.
	 */
	public void setupGraph() {
		vertices = new ArrayList<>();
		vertices.add(new Vertex("A", null, 0));
		vertices.add(new Vertex("B"));
		vertices.add(new Vertex("C"));
		vertices.add(new Vertex("D"));
		vertices.add(new Vertex("E"));
		
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(vertices.get(0),vertices.get(3),2));
		edgeList.add(new Edge(vertices.get(3),vertices.get(1),15));
		edgeList.add(new Edge(vertices.get(1),vertices.get(4),8));
		edgeList.add(new Edge(vertices.get(2),vertices.get(4),6));
		edgeList.add(new Edge(vertices.get(2),vertices.get(0),10));
		edgeList.add(new Edge(vertices.get(2),vertices.get(3),5));
		
		for (int i=0; i<edgeList.size(); i++) {
			Edge currentEdge2 = edgeList.get(i);
			Vertex startVertex = currentEdge2.startVertex;
			Vertex endVertex = currentEdge2.endVertex;
			int weight = currentEdge2.weight;
			
			matrix[vertices.indexOf(startVertex)][vertices.indexOf(endVertex)] = weight;
			matrix[vertices.indexOf(endVertex)][vertices.indexOf(startVertex)] = weight;
		}
	}
	
	/**
	 * Checks the matrix created above.
	 */
	public void checkMatrix() {
		Vertex end = vertices.get(4);
		int nextCheck = 0;
		for (int i=nextCheck; i < vertex; i++) {
			int smallestDist = Integer.MAX_VALUE;

			Vertex thisVertex = vertices.get(i);
			int thisDist = thisVertex.getDistance();

			for (int j=0; j < vertex; j++) {
				Vertex current = vertices.get(j);
				
				if (matrix[i][j] !=0 && thisDist + matrix[i][j] < current.getDistance()) {
					current.setPrevious(thisVertex);
					current.setDistance(thisDist + matrix[i][j]);
					
					if (thisDist + matrix[i][j] < smallestDist) {
						smallestDist = thisDist + matrix[i][j];
						nextCheck = j;
					}
				}
			}
			if (!thisVertex.getName().equals(end.getName())) {
				i = nextCheck-1;
				
			} else {
				continue;
			}
		}
		for (Vertex v : vertices) {
			System.out.println("Distance to " + v.getName() + " is " + v.getDistance());
		}
		System.out.println("Shortest path to " + end.getName() + " is " + end.getDistance());
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
	
}
