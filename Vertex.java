/**
 * Class creating Vertices. Each storing their name
 * the previous vertex in the path and distance to it.
 * 
 * @author	n-c0de-r
 * @author	AlexanderStae
 * @version	11.07.2021
 */
public class Vertex {

	private String name;
	private Vertex previous;
	private int distance;
	private boolean visited;
	
	/**
	 * Full constructor of the Vertex class.
	 * 
	 * @param str	Contains the name of the Vertex.
	 * @param prev	Contains the previous neighboring Vertex.
	 * @param dist	The minimum distance to this Vertex.
	 * @param visit	Boolean if the Vertex is visited.
	 */
	public Vertex (String str, Vertex prev, int dist, boolean visit) {
		name = str;
		previous = prev;
		distance = dist;
		visited = visit;
	}
	
	/**
	 * Smaller constructor of the Vertex class, name only.
	 * 
	 * @param str	Contains the name of the Vertex.
	 */
	public Vertex (String str) {
		this(str, null, Integer.MAX_VALUE, false);
	}
	
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
	 * Get the visited status of this vertex.
	 * @return Visited status of the Vertex.
	 */
	public boolean isVisited() {
		return visited;
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
	
	/**
	 * Set the visited status of this vertex.
	 * @param visit	Set if this Vertex was visited.
	 */
	public void setVisited(boolean visit) {
		visited = visit;
	}
}
