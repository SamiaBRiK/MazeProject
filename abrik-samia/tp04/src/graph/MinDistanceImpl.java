package tp04.src.graph;

import java.util.HashMap;

public class MinDistanceImpl extends HashMap<Vertex,Integer> implements MinDistance {

    public MinDistanceImpl(){
        super();
    }

    /**
      *affects a value to the minimal distance between a vertex and the start vertex 
      *@param vertex a vertex
      *@param value an integer 
      */
    public void setMinDistance(Vertex vertex, int value) {
        put(vertex,value);
    }

     /**
      *returns minimal distance between a vertex and the start vertex 
      *@param vertex a vertex
      *@return minimal distance
      */
    public int getMinDistance(Vertex vertex) {
        return get(vertex);
    }
    
}
