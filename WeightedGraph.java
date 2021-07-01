import java.util.ArrayList;

public class WeightedGraph {
	
	int vertex = 5;
	int[][] matrix = new int[vertex+1][vertex+1];
	
	ArrayList<Edge> edgeList;
	
	public WeightedGraph() {
		
	}
	
	public void setupGraph() {
		edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(1,4,2));
		edgeList.add(new Edge(4,2,15));
		edgeList.add(new Edge(2,5,8));
		edgeList.add(new Edge(3,5,6));
		edgeList.add(new Edge(3,1,10));
		edgeList.add(new Edge(3,4,5));
		
		for (int i=0; i<edgeList.size(); i++) {
			Edge currentEdge = edgeList.get(i);
			int startVertex = currentEdge.startVertex;
			int endVertex = currentEdge.endVertex;
			int weight = currentEdge.weight;
			
			matrix[startVertex][endVertex] = weight;
		}
	}
	
	public void checkMatrix() {
		for (int i=1; i<vertex+1; i++) {
			for (int j=1; j<vertex+1; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
