
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
		w.cheapestPath(0, 4);
		w.shortestPath(0, 4);
		
		System.out.println("----------Random Graph----------");
		Dijkstra r = new Dijkstra(new RandomGraph(20,45));
		r.cheapestPath();
		r.shortestPath();
	}
	
}
