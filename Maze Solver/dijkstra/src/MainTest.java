package dijkstra.src;

import java.io.IOException;
import java.util.ArrayList;

import dijkstra.src.maze.Maze;
import dijkstra.src.maze.MazeReadingException;
import dijkstra.src.graph.Dijkstra;
import dijkstra.src.graph.ShortestPaths;
import dijkstra.src.graph.Vertex;

public class MainTest {
    public static void main(String[] args) throws IOException, MazeReadingException {
    Maze labyMaze = new  Maze(null);
    labyMaze.initFromTextFile("tp04/data/labyrinthe.maze");
    
    ShortestPaths shortestPaths = Dijkstra.dijkstra(labyMaze,labyMaze.getDeparture(),labyMaze.getArrival());
    ArrayList<Vertex> path = shortestPaths.getShortestPathTo(labyMaze.getArrival());
	labyMaze.showPath(labyMaze, path);

    }
}
