import java.util.Random;

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
		
		WeightedGraph g = new WeightedGraph();
		g.testGraph();
		g.cheapestPath(0,4);
		g.shortestPath(0, 4);
		
		//Generate random numbers as start and end points
//		Random rng = new Random();
//		int start = -1;
//		int end = -1;
//		while (start == end) {
//			start = rng.nextInt(20);
//			end = rng.nextInt(20);
//		}
//		WeightedGraph r = new WeightedGraph(20,45);
//		r.cheapestPath(start, end);
	}
	
}
