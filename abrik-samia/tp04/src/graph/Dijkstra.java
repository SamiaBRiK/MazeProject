package tp04.src.graph;

import java.util.ArrayList;

public class Dijkstra {
    
    public static ShortestPaths dijkstra(Graph graph, Vertex startVertex, Vertex endVertex){

        ProcessedVertexes processedVertexes = new ProcessedVertexesImpl();
        MinDistance minDistance = new MinDistanceImpl();
        ShortestPathsImpl shortestPaths = new ShortestPathsImpl();

        processedVertexes.addVertex(startVertex);
        Vertex pivot = startVertex;
        minDistance.setMinDistance(startVertex , 0);
        ArrayList<Vertex> allVertexes = graph.getAllVertexes();

        for ( Vertex vertex : allVertexes){
            if (vertex != startVertex){
                minDistance.setMinDistance(vertex,Integer.MAX_VALUE);
            }
        }

        while(!processedVertexes.containsVertex(endVertex)){

            ArrayList<Vertex> pivotSuccessors = graph.getSuccessors(pivot);

            for ( Vertex succVertex : pivotSuccessors ){
                if ( !processedVertexes.containsVertex(succVertex) ){
                    int x = minDistance.getMinDistance(pivot)+graph.getDistance(pivot, succVertex );
                    if ( x < minDistance.getMinDistance(succVertex) ){
                        minDistance.setMinDistance(succVertex,x);
                        shortestPaths.setPrevious(succVertex, pivot);
                    }
                 }
            }

            Vertex v = null;
            int minDist = Integer.MAX_VALUE;
            for(Vertex vertex : allVertexes){
                if(!processedVertexes.containsVertex(vertex) && minDistance.getMinDistance(vertex)<minDist){
                    minDist = minDistance.getMinDistance(vertex);
                    v = vertex ;
                }
            }
            pivot = v;
            processedVertexes.addVertex(pivot);
        }
        return shortestPaths;
    }
}

