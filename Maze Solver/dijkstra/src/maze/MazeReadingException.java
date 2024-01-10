package dijkstra.src.maze;

public class MazeReadingException extends Exception {
    public MazeReadingException (String fileName, int lineNum, String errorMsg){
        super("Erreur lors de la lecture du labyrinthe dans"+" "+fileName+"  à la ligne "+lineNum+" :"+errorMsg);
    }
}
