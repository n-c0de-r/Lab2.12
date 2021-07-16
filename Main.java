
/**
 * Main running class.
 * 
 * @author	n-c0de-r
 * @author	AlexanderStae
 * @version	11.07.2021
 */
public class Main {

	/**
	 * Main method running the program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("----------Weighted Graph----------");
		Dijkstra w = new Dijkstra(new WeightedGraph());
		w.findPath(0, 4, "cheap");
		w.findPath(0, 4, "short");
		
		System.out.println("----------Random Graph----------");
		Dijkstra r = new Dijkstra(new RandomGraph(20,45));
		r.findPath("cheap");
		r.findPath("short");
	}
	
}
