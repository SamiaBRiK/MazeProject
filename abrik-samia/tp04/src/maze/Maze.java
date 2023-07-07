package tp04.src.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import tp04.src.graph.Graph;
import tp04.src.graph.Vertex;

public class Maze implements Graph{
    private int height ;
    private int width ;
    private MazeBox[][] maze;
    
    public Maze(MazeBox[][] maze){
        this.maze = maze;
		if (maze != null) {
			width= maze[0].length ;
			height = maze.length ;
		}
    }

    /**
      *returns the height of the maze
      *@return the height
      */
    public int getHeight(){
        return height;
    }

    /**
      *returns the width of the maze
      *@return the width
      */
    public int getWidth(){
        return width;
    }

    /**
      *returns the matrix of vertexes
      *@return a two dimension table of vertexes 
      */
    public MazeBox[][] getMaze(){
        return maze;
    }
    
     /**
       *returns all graph's vertexes
       *@return list of all graph's vertexes
       */
    public ArrayList<Vertex> getAllVertexes() {
        ArrayList<Vertex> allVertexes = new ArrayList<Vertex>();
        for(int i=0; i<this.height; i++){
            for(int j=0; j<this.width; j++){
                allVertexes.add(this.maze[i][j]);
            }
        }
        return allVertexes;
    }
    
    /**
      *returns all neighbors of a vertex
      *@param vertex a vertex
      *@return list of neighbors
      */
    public ArrayList<Vertex> getSuccessors(Vertex vertex) {
        
        ArrayList<Vertex> successors = new ArrayList<Vertex>();
        MazeBox box = (MazeBox) vertex;
        int x = box.getx();
        int y = box.gety();
        
        if(x%2==0){
        try {
            MazeBox voisin = maze[x][y+1];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        try {
            MazeBox voisin = maze[x-1][y];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        try {
            MazeBox voisin = maze[x-1][y-1];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        try {
            MazeBox voisin = maze[x][y-1];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        try {
            MazeBox voisin = maze[x+1][y];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        try {
            MazeBox voisin = maze[x+1][y-1];
            if(!voisin.getBlocked()){
                successors.add(voisin);
            }
        } catch (Exception e) {}
        }

        else{
            try {
                MazeBox voisin = maze[x][y+1];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            try {
                MazeBox voisin = maze[x-1][y];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            try {
                MazeBox voisin = maze[x-1][y+1];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            try {
                MazeBox voisin = maze[x][y-1];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            try {
                MazeBox voisin = maze[x+1][y];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            try {
                MazeBox voisin = maze[x+1][y+1];
                if(!voisin.getBlocked()){
                    successors.add(voisin);
                }
            } catch (Exception e) {}
            }
    return successors;
    }
    
    /**
      *returns the weight of the edge between two vertexes
      *@param vertex1 first vertex
      *@param vertex2 second vertex
      *@return the weight 
      */
    public int getDistance(Vertex vertex1, Vertex vertex2) {
        ArrayList<Vertex> successors1 = getSuccessors(vertex1);
        
        if(successors1.contains(vertex2)){ 
            return 1;
        }
        else{ return 0; } 
    }

    /**
      *returns the departure vertex
      *@return the vertex of type "D"
      *@throws MazeReadingException
      */
    public final Vertex getDeparture() throws MazeReadingException{
        for(int x=0 ; x < height ; x++){ 
            for(int y=0 ; y < width ; y++){
                Vertex box = maze[x][y];
                if(box.getType()=="D"){
                    return box ;
                }
            }
        }
        throw new MazeReadingException(null, 0,"Le labyrinthe ne contient pas de case de départ");
    }

    /**
      *returns the arrival vertex
      *@return the vertex of type "A"
      *@throws MazeReadingException
      */
    public final Vertex getArrival() throws MazeReadingException{
        for(int x=0 ; x < height ; x++){ 
            for(int y=0 ; y < width ; y++){
                Vertex box = maze[x][y];
                if(box.getType()=="A"){
                    return box ;
                }
            }
        }
        throw new MazeReadingException(null, 0,"Le labyrinthe ne contient pas de case d'arrivée");
    }

    /**
      *returns the height and the width of a maze
      *@param fileName the name of the text file 
      *@return a two dimension table containing the maze dimensions 
      *@throws MazeReadingException
      */
    private final int[] calculDimensions(String fileName) throws MazeReadingException{
        int[] dimensions = new int[2];
        try(
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            ) { 
                String currentLine = br.readLine();
                if(currentLine==null){
                br.close();
                throw new MazeReadingException(fileName,0," : Le fichier est vide !");
                }
                int width = currentLine.length();
                int height = 1;
                String line;
                while((line = br.readLine())!=null){ 
                    if(line.length()!=width){
                        throw new MazeReadingException(fileName, height, "ligne de longueur fausse");
                    }
                    else{height+=1;}
                }
                dimensions[0]= height;
                dimensions[1]= width;
                
                
        }catch (FileNotFoundException e) {
            e.printStackTrace();    
        }
        catch (IOException e){
        e.printStackTrace();    
         }
        return dimensions;
    }
    
    /**
      *initiats the maze from a text file
      *@param fileName the name of the text file 
      *@throws MazeReadingException
      */
    public final void initFromTextFile(String fileName) throws MazeReadingException{
        try(
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            ) { 
                int[] dimensions = calculDimensions(fileName);
                this.height = dimensions[0];
                this.width = dimensions[1];
                MazeBox[][] maze = new MazeBox[height][width];
                String line;          
                for(int i=0 ; i < height ; i++){
                    line = br.readLine();
                    for(int j=0 ; j < width ; j++){
                        char c_j = line.charAt(j);
                        switch(c_j){
                            case 'W' : 
                                maze[i][j] = new WallBox(i,j);
                                break;
                            case 'E' : 
                                maze[i][j] = new EmptyBox(i,j);
                                break;
                            case 'A' : 
                                maze[i][j] = new ArrivalBox(i,j);
                                break;
                            case 'D' : 
                                maze[i][j] = new DepartureBox(i,j);
                                break;
                            case '.' : 
                                maze[i][j] = new PathBox(i,j);
                                break;
                            default :
                                throw new MazeReadingException( fileName, i, "Caractère non reconnu" );
                        }
                    }
                }
                this.maze = maze ;

                int nbrDepartureBox = 0;
                int nbrArrivalBox = 0;
                for(int x=0 ; x < height ; x++){ 
                    for(int y=0 ; y < width ; y++){
                        String type = maze[x][y].getType();
                        if(type=="D"){ nbrDepartureBox++ ;}
                        else if(type=="A"){ nbrArrivalBox++ ;}
                    }
                }
                if(!(nbrDepartureBox==1 && nbrArrivalBox==1)){
                    throw new MazeReadingException(fileName, 0, "Nombre de case de départ ou d'arrivée incorrecte");
                }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();    
        }
        catch (IOException e){
        e.printStackTrace();    
         }
    }
    
    /**
      *saves the maze in a text file
      *@param fileName the name of the text file
      */
    public final void saveToTextFile(String fileName){
        try (
            FileOutputStream fos = new FileOutputStream(fileName) ;
            PrintWriter      pw  = new PrintWriter(fos) ;
            ){
            for( int x = 0 ; x<this.height ; x++) {
				for( int y = 0 ; y <this.width ; y++) {
					pw.print(this.maze[x][y].getType());
				}
				pw.println("");
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    /**
      *writes the solution of the maze in a text file
      *@param maze the maze to be solved 
      *@param path the path from the departure to the arrival
      *@throws MazeReadingException 
      */
    public void showPath(Maze maze, ArrayList<Vertex> path) throws MazeReadingException{
		PrintWriter pw;
        try {
            pw = new PrintWriter(new FileOutputStream("tp04/data/solution"));
            MazeBox departure =(MazeBox) maze.getDeparture() ;
            MazeBox arrival =(MazeBox) maze.getArrival() ;
            for( int x = 0 ; x< maze.getHeight() ; x++) {
                for( int y = 0 ; y <maze.getWidth() ; y++) {
                    MazeBox box = maze.getMaze()[x][y] ;
                    if( path.contains(box) && (box != departure) && (box != arrival)) {
                        pw.print(".");
                        System.out.print(".");
                    }
                    else{
                        pw.print(maze.getMaze()[x][y].getType());
                        System.out.print(maze.getMaze()[x][y].getType());
                        }
                    }
                pw.println("");
                System.out.println("");
                }
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}





