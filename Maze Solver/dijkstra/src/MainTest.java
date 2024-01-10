package dijkstra.src;

import java.io.IOException;
import java.util.ArrayList;

import tp04.src.maze.Maze;
import tp04.src.maze.MazeReadingException;
import tp04.src.graph.Dijkstra;
import tp04.src.graph.ShortestPaths;
import tp04.src.graph.Vertex;

public class MainTest {
    public static void main(String[] args) throws IOException, MazeReadingException {
    Maze labyMaze = new  Maze(null);
    labyMaze.initFromTextFile("tp04/data/labyrinthe.maze");
    
    ShortestPaths shortestPaths = Dijkstra.dijkstra(labyMaze,labyMaze.getDeparture(),labyMaze.getArrival());
    ArrayList<Vertex> path = shortestPaths.getShortestPathTo(labyMaze.getArrival());
	labyMaze.showPath(labyMaze, path);

    }
}
