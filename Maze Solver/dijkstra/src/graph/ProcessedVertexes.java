package tp04.src.graph;

public interface ProcessedVertexes {

    /**
      *adds a vertex to the list of processed vertexes
      *@param vertex a vertex
      */
    public void addVertex ( Vertex vertex );

    /**
      *tests if a vertex is in the list of processed vertexes
      *@param vertex a vertex
      *@return true if vertex is in the list of processed vertexes else false 
      */
    public boolean containsVertex ( Vertex vertex);
    
}
