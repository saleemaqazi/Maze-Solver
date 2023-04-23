package mazeSolver;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a data Structure to store information about a maze, including where
 * the start and goal of the maze are and the dimensions of the maze. It also 
 * holds what spaces are occupied by maze walls and which are open.
 * 
 * @author Saleema Qazi and Kelsey Porter
 *
 */

public class Graph {
	Node[][] graph;
	Node start;
	int length;
	int width;

	Graph(File inputFile) throws FileNotFoundException {
		Scanner sc = new Scanner(inputFile);

		length = sc.nextInt();
		width = sc.nextInt();
		sc.nextLine();
		graph = new Node[length][width];

		for (int i = 0; i < length; i++) {
			String row = sc.nextLine();
			for (int j = 0; j < width; j++) {
				if (row.charAt(j) == 'S') {
					start = new Node(row.charAt(j), i, j);
					graph[i][j] = start;
				} else
					graph[i][j] = new Node(row.charAt(j), i, j);
			}
		}
		sc.close();
	}
	
	/**
	 * Returns an array of the 4 nodes above, below, left, and right of the given node.
	 * @param node to find neighbors of
	 * @return array of neighboring nodes
	 */
	public Node[] getNeighbors(Node current){
		Node[] neighbors = {
				graph[current.height + 1][current.width],
				graph[current.height - 1][current.width],
				graph[current.height][current.width + 1],
				graph[current.height][current.width - 1]
		};
		return neighbors;
	}

}
