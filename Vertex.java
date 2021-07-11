/**
 * Class creating Vertices. Each storing their name
 * the previous vertex in the path and distance to it.
 * 
 * @author n-c0de-r
 * @author AlexanderStae
 * @version 11.07.2021
 */
public class Vertex {

	private String name;
	private Vertex previous;
	private int distance = Integer.MAX_VALUE;
	
//	public Vertex (String str, Vertex prev, int dist) {
//		name = str;
//		previous = prev;
//		distance = dist;
//	}
	
	/**
	 * Get the vertex's name.
	 * @return String with the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the vertex's previous neighbor.
	 * @return Vertex which came before.
	 */
	public Vertex getPrevious() {
		return previous;
	}
	
	/**
	 * Get the distance to this vertex.
	 * @return Integer value of distance.
	 */
	public int getDistance() {
		return distance;
	}
	
	/**
	 * Set the name of this vertex.
	 * @param str	String with the new name.
	 */
	public void setName(String str) {
		name = str;
	}
	
	/**
	 * Set the neighboring vertex to this one.
	 * @param prev	Vertex that came before.
	 */
	public void setPrevious(Vertex prev) {
		previous = prev;
	}
	
	/**
	 * Set the shortest distance to this vertex.
	 * @param dist	Integer value of shortest distance.
	 */
	public void setDistance(int dist) {
		distance = dist;
	}
}