package mazeSolver;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author Saleema Qazi and Kelsey Porter
 * 
 * This program takes a text file representing a randomly generated maze and produces a text file 
 * representing the same maze with the shortest possible solution path displayed.
 *
 */
public class PathFinder {

	/**
	 * This method creates a graph from the data in a txt file representing a maze. It uses a helper method to 
	 * find the shortest path from start to goal. Then it creates an output maze file depicting the path found.
	 * 
	 * @param inputFile  - the file path to the input maze
	 * @param outputFile - the file path to the output maze
	 */
	public void solveMaze(String inputFile, String outputFile) {
		try {
			// convert file to graph
			Graph maze = new Graph(new File(inputFile));
			// Find solution path
			ArrayList<Node> path = findShortestPath(maze);
			// print solution to a new file
			PrintWriter output = new PrintWriter(new FileWriter(outputFile));
			output.print(maze.length + " " + maze.width);
			output.println();
			// print solution row by row
			for (Node[] graphRow : maze.graph) {
				for (Node node : graphRow) {
					// for each node, if its part of the path print an 'x'
					if (path.contains(node)) {
						output.print("x");
					}
					// otherwise print its symbol
					else {
						output.print(node.symbol);
					}
				}
				//start the next row of the graph on a new line
				output.println();
			}
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This is a helper method used to find a path of the shortest length possible from S to G and returns an
	 * ArrayList of Nodes on the path. The list is in reverse order from G to S and
	 * does not contain G or S. If no path exists then returns an empty array list.
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Node> findShortestPath(Graph maze) {
		// create queue to keep track of nodes that haven't been visited
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(maze.start);
		maze.start.visited = true;
		Node current = maze.start;

		// go down the queue until you find G or run out of spaces to explore
		while (!queue.isEmpty() && current.symbol != 'G') {

			// find the four nodes that are one away from the current node
			// add them to a list called neighbors
			Node[] neighbors = maze.getNeighbors(current);

			// add to the queue each neighbor given that it has not been visited and is not
			// a wall
			for (Node neighbor : neighbors) {
				if (neighbor.symbol != '=' && !neighbor.visited) {
					queue.addLast(neighbor);
					// update the graph to keep track of the path followed
					neighbor.cameFrom = current;
					neighbor.visited = true;
				}
			}

			// advance down the queue
			current = queue.removeFirst();
		}

		// if G is found construct path back to S
		ArrayList<Node> path = new ArrayList<Node>();
		if (current.symbol == 'G') {
			while (current.cameFrom != maze.start) {
				current = current.cameFrom; // get previous node
				path.add(current); // add node to path
			}
		}

		return path;

	}

}