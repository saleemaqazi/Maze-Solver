# Maze Solver

Maze Solver is a collection of Java programs that generate random mazes and find the shortest path to solve them. This package includes the following files:

- Main.java: The entry point of the program.
- MazeGen.java: Generates a random maze of a specified size and density.
- PathFinder.java: Finds the shortest path through the maze.
- Graph.java: Represents the maze as a graph data structure.
- Node.java: Represents a space inside the maze.
- Maze.txt: The text file that contains the generated maze.
- Solution.txt: The text file that displays the solution path.

To see the programs in action, run the Main.java file. You can then view the generated maze in Maze.txt and the solution path in Solution.txt.

## Maze Generation

MazeGen.java is responsible for generating a random maze. The generated maze is always square with walls on all edge spaces. Each space inside the maze can be a wall, the start, the goal, or an empty space. Walls are represented by '=' sign, the start by 'S', the goal by 'G', and empty spaces by ' '. MazeGen allows you to specify the size and approximate density of the maze. The density refers to the approximate number of wall spaces inside the maze compared to the total number of spaces. Note that if the density is set too high, the maze may become unsolvable. MazeGen was written by Professor Daniel Kopta.

## Path Finding

PathFinder.java finds the shortest path from the start to the goal through the maze walls. It scans the Maze.txt file and creates a graph of nodes to represent the maze. Each node represents a space inside the maze and holds information about the type of space (wall, start, goal, empty), whether it has been visited, and the space from which it was visited. The Graph class is a two-dimensional array that holds nodes in the same positions as the maze. It also keeps track of the start space. PathFinder uses a priority queue to traverse the graph, starting from the start space, and attempts to visit each node until it finds the goal space. Once the goal is found, PathFinder reconstructs the shortest path back to the start by following the "visited-from" field in each node. The path is displayed in Solution.txt as a series of 'X' characters. PathFinder was implemented by Saleema Qazi and Kelsey Porter, the authors of this project.

## Usage

1. Compile and run the Main.java file.
2. View the generated maze in Maze.txt and the solution path in Solution.txt.

## Contact Information

For any questions or feedback regarding Maze Solver, please feel free to contact Saleema Qazi at saleemasqazi@gmail.com

I hope you enjoy using Maze Solver!
