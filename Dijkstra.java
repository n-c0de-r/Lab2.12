/**
 * Path finding class finding the shortest and cheapest
 * way between two points according to the Dijkstra Algorithm.
 * 
 * @author n-c0de-r
 * @author AlexanderStae
 * @version 11.07.2021
 */
public class Dijkstra {
	
	private WeightedGraph g;
	
	public Dijkstra (WeightedGraph g) {
		this.g = g;
	}
	
	/**
	 * Checks any given matrix via Dijkstra's Algorithm
	 * finding the shortest or cheapest path from start to goal,
	 * depending on the String of mode given as a parameter.
	 * 
	 * @param start The vertex to start path from.
	 * @param goal  The goal vertex to get to.
	 * @param mode	The mode by which the algorithm is looking for
	 */
	public void findPath(int start, int goal, String mode) {
		// Initialize the amount of vertices to check
		int toVisit = g.vertices.size();

		// Initialize the start vertex
		Vertex thisVertex = g.vertices.get(start);
		thisVertex.setDistance(0);
		int thisDist = thisVertex.getDistance();

		int nextCheck = start;

		// While not all are checked
		while (toVisit != 0) {
			// Get the current vertex
			thisVertex = g.vertices.get(nextCheck);
			thisDist = thisVertex.getDistance();
			thisVertex.setVisited(true);

			// Check all neighboring vertices
			for (int i = 0; i < g.vertices.size(); i++) {
				Vertex current = g.vertices.get(i);
				
				// Checks if the shortest or cheapest path is looked for
				int currentWeight = 0;
				if (mode.toLowerCase().equals("short")) {
					currentWeight = 1;
				} else {
					currentWeight = g.matrix[nextCheck][i];
				}
				
				// If the current vertices sum of distances is lower, update the current vertex
				if (g.matrix[nextCheck][i] != 0
						&& (thisDist + currentWeight) < current.getDistance()
						&& !current.isVisited()) {
						current.setPrevious(thisVertex);
						current.setDistance(thisDist + currentWeight);
				}
			}

			int smallestDist = Integer.MAX_VALUE;

			// Find the next unvisited vertex with the smallest distance to check next
			for (int i = 0; i < g.vertices.size(); i++) {
				if (g.vertices.get(i).isVisited()) {
					continue;
				} else {
					if (g.vertices.get(i).getDistance() < smallestDist) {
						smallestDist = g.vertices.get(i).getDistance();
						nextCheck = i;
					}
				}
			}
			toVisit--;
		}
		getPath(mode, g.vertices.get(start), g.vertices.get(goal));
	}
	
	/**
	 * Overload method call to itself, with mode parameter only.
	 *
	 * @param mode	The mode by which the algorithm is looking for
	 */
	public void findPath(String mode) {
		findPath(g.start, g.end, mode);
	}
	
	/**
	 * Method that returns the resulting path.
	 * 
	 * @param end The goal vertex.
	 */
	private void getPath(String type, Vertex start, Vertex end) {

		// After all is done, print out all distances
//		for (Vertex v : g.vertices) {
//			System.out.println("Distance to " + v.getName() + " is: " + v.getDistance());
//		}

		// When all is finished print the cheapest or shortest path to the end
		System.out.println("The " + type + "est path from " + start.getName() + " to " + end.getName() + " is: "
				+ end.getDistance());

		String endName = end.getName();
		String path = endName;
		String lastName = "";
		Vertex checking = end;
		while (checking.getPrevious() != null) {
			checking = checking.getPrevious();
			lastName = checking.getName();
			path = lastName + " --> " + path;

		}
		System.out.println("The full " + type + "est path is: " + path);
		System.out.println();
		
		// After printout reset visited vertices for next method
		resetVisits();
	}
	
	/**
	 * Resets all vertices to unvisited.
	 */
	private void resetVisits() {
		for (Vertex v : g.vertices) {
			v.setVisited(false);
			v.setDistance(Integer.MAX_VALUE);
			v.setPrevious(null);
		}
	}
}
