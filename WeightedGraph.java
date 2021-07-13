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
		for (int i=0; i<vertex; i++) {
			System.out.println("Current Vertex is " + vertices.get(i).getName());
			System.out.println("Vertex Distance is " + vertices.get(i).getDistance());
			for (int j=0; j<vertex; j++) {
				if (matrix[i][j] <10) {
					System.out.print("0" + matrix[i][j] + " ");
				} else {
					System.out.print(matrix[i][j] + " ");
				}
				int thisDist = vertices.get(i).getDistance();
				if (matrix[i][j]!=0 && thisDist<thisDist+matrix[i][j]) {
					vertices.get(j).setPrevious(vertices.get(i));
					vertices.get(j).setDistance(vertices.get(i).getDistance()+matrix[i][j]);
					
					System.out.println("Distance to " + vertices.get(j).getName() + " is " + vertices.get(j).getDistance());
				}
			}
			System.out.println();
		}
	}
	
}
