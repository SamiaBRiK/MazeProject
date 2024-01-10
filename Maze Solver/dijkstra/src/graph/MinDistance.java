package tp04.src.graph;

public interface MinDistance {
    /**
      *affects a value to the minimal distance between a vertex and the start vertex 
      *@param vertex a vertex
      *@param value an integer 
      */
    public void setMinDistance(Vertex vertex, int value);
    
    /**
      *returns minimal distance between a vertex and the start vertex 
      *@param vertex a vertex
      *@return minimal distance
      */
    public int getMinDistance(Vertex vertex);
    
}
