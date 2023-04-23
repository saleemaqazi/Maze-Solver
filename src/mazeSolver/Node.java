package mazeSolver;

/**
 * This is a data type that represents a space within the maze. It is held within a graph. 
 * 
 * @author Saleema Qazi and Kelsey Porter
 *
 */
public class Node {

	char symbol;
	Boolean visited;
	Node cameFrom;
	//position in maze:
	int height;
	int width;
	
	Node(char c, int height, int width) {
		symbol = c;
		visited = false;
		this.height = height;
		this.width = width;
	}
	
}
