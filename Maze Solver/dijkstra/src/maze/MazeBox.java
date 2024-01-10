package dijkstra.src.maze;

import dijkstra.src.graph.Vertex;

public abstract class MazeBox implements Vertex{
    private final int x ;
    private final int y ;
    private final String type ;
    private final boolean blocked ;

protected MazeBox (int x, int y, String type, boolean blocked){
    this.x = x ;
    this.y = y ;
    this.type = type ;
    this.blocked = blocked ;
}

/** 
  *returs the value of the x-coordinate
  *@return x-coordinate of a vertex
  */
public final int getx () {
    return x ;
}

/** 
  *returs the value of the x-coordinate
  *@return x-coordinate of a vertex
  */
public final int gety () {
    return y ;
}

/** 
  *returs the value of the type
  *@return type of a vertex
  */
public final String getType () {
    return type ;
}

/** 
  *returns the value of blocked
  *@return true if the box is blocked (Wall) else false 
  */
public final boolean getBlocked () {
    return blocked ;
}

}
