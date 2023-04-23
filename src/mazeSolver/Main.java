package mazeSolver;

public class Main {
	
	/**
	 * This is the launch pad for this package of programs. The main method 
	 * creates a randomly generated 30x30 maze with 30% wall density. Then it 
	 * solves the maze and displays the solution if one exists. Both the original
	 * maze and the solution can be viewed in maze.txt and solution.txt respectively. 
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//create instances of the classes need to produce and solve a maze
		MazeGen mg = new MazeGen();
		PathFinder pf = new PathFinder();
		
		//generate a random maze of dimension 30 and a wall density of 30%
		//the maze can be viewed in the file maze.txt
		mg.randomMaze("maze.txt", 30, 0.3);
		//solve the maze and display the solution in the file solution.txt
		pf.solveMaze("maze.txt", "solution.txt");	
	}
}
