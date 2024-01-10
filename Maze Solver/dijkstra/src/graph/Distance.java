package tp04.src.graph;

public interface Distance {
    /**
      *returns the weight of the edge between two vertexes
      *@param vertex1 first vertex
      *@param vertex2 second vertex
      *@return the weight 
      */
    public int getDistance(Vertex vertex1, Vertex vertex2);
    
}
