package tp04.src.graph;

import java.util.HashSet;

public class ProcessedVertexesImpl extends HashSet<Vertex> implements ProcessedVertexes {

    public ProcessedVertexesImpl(){
        super();
    }
   
    /**
      *adds a vertex to the list of processed vertexes
      *@param vertex a vertex
      */
    public void addVertex(Vertex vertex) {

        add(vertex);
    }

    /**
      *tests if a vertex is in the list of processed vertexes
      *@param vertex a vertex
      *@return true if vertex is in the list of processed vertexes else false 
      */
    public boolean containsVertex(Vertex vertex) {
        
        return contains(vertex);
    }  
}
