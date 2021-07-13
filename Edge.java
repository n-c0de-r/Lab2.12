/**
 * Class creating objects of edges.
 * Containing vertices and weights.
 * 
 * @author	n-c0de-r
 * @author	AlexanderStae
 * @version 11.07.2021
 */

public class Edge {
	public Vertex startVertex;
	public Vertex endVertex;
	public int weight;
	
	/**
	 * Constructor of the class.
	 * 
	 * @param start		Starting Vertex.
	 * @param end		Neighboring Vertex.
	 * @param weight	Weight between two.
	 */
	public Edge (Vertex start, Vertex end, int weight) {
		startVertex = start;
		endVertex = end;
		this.weight = weight;
	}
}
