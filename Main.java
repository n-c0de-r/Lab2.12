import java.util.ArrayList;

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
		
		NameGenerator n = new NameGenerator();
		ArrayList<String> names = n.getNames();
		
		WeightedGraph g = new WeightedGraph();
		g.setupGraph();
		g.checkMatrix();
	}
	

}
