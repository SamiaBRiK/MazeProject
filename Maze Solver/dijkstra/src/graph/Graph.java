package tp04.src.graph;

import java.util.ArrayList;

public interface Graph {
     /**
       *returns all graph's vertexes
       *@return list of all graph's vertexes
       */
    public ArrayList<Vertex> getAllVertexes();
    
    /**
      *returns all neighbors of a vertex
      *@param vertex a vertex
      *@return list of neighbors
      */
    public ArrayList<Vertex> getSuccessors(Vertex vertex);
    
   /**
     *returns the weight of the edge between two vertexes
     *@param vertex1 first vertex
     *@param vertex2 second vertex
     *@return the weight 
     */
    public int getDistance(Vertex vertex1, Vertex vertex2);
    
}

