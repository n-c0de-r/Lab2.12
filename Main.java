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
		System.out.println("----------Weighted Graph----------");
		System.out.println();
		WeightedGraph g = new WeightedGraph();
		g.cheapestPath(0, 4);
//		g.shortestPath(0, 4);
		
		System.out.println();
		System.out.println();
		System.out.println("----------Random Graph----------");
		System.out.println();
		
		//Generate random numbers as start and end points
		RandomGraph r = new RandomGraph(20,45);
		r.cheapestPath();
	}
	
}
