package tp04.src.graph;

import java.util.ArrayList;

public interface ShortestPaths {

    /**
      *defines a successions relation between two nodes
      *@param vertex the son node
      *@param previous the father node
      */
    public void setPrevious(Vertex vertex, Vertex previous);
    
    /**
      *returns the father of a vertex in the shortest path
      *@param vertex a vertex
      *@return the father node of vertex 
      */
    public Vertex getPrevious(Vertex vertex);

    /**
      *returs the list representing the shortest path to a vertex
      *@param vertex a vertex
      *@return the list of vertexes representing the shortest path to vertex
      */
    public ArrayList<Vertex> getShortestPathTo(Vertex vertex);
    
}