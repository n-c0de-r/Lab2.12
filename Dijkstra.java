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
	 * finding the cheapest path from start to goal.
	 * 
	 * @param start The vertex to start path from.
	 * @param goal  The goal vertex to get to.
	 */
	public void cheapestPath(int start, int goal) {
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

				// If the current vertices sum of distances is lower, update the current vertex
				if (g.matrix[nextCheck][i] != 0
					&& (thisDist + g.matrix[nextCheck][i]) < current.getDistance()
					&& !current.isVisited()) {
					current.setPrevious(thisVertex);
					current.setDistance(thisDist + g.matrix[nextCheck][i]);
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
		getPath("cheap", g.vertices.get(start), g.vertices.get(goal));
	}

	/**
	 * Checks any given matrix via Dijkstra's Algorithm
	 * finding the shortest path from start to goal.
	 * 
	 * @param start The vertex to start path from.
	 * @param goal  The goal vertex to get to.
	 */
	public void shortestPath(int start, int goal) {
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

				// If the current vertices sum of distances is lower, update the current vertex
				if (g.matrix[nextCheck][i] != 0
					&& (thisDist + 1) < current.getDistance()
					&& !current.isVisited()) {
					current.setPrevious(thisVertex);
					current.setDistance(thisDist + 1);
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
		getPath("short", g.vertices.get(start), g.vertices.get(goal));
	}
	
	public void cheapestPath() {
		cheapestPath(g.start, g.end);
	}
	
	public void shortestPath() {
		shortestPath(g.start, g.end);
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
