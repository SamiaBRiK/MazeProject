package interfaceutilisateur;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tp04.src.graph.Dijkstra;
import tp04.src.graph.ShortestPaths;
import tp04.src.graph.Vertex;
import tp04.src.maze.Maze;
import tp04.src.maze.MazeBox;
import tp04.src.maze.MazeReadingException;

public class MazeAppModel {
    private int height = 10;
    private int width = 12;
	private String selectedType = "E";
    private Box[][] grid;
    private boolean modified = false ;
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();

    public MazeAppModel() {
		grid =new Box[height][width];
		for(int x = 0 ; x<height ; x++) {
			for(int y = 0 ; y< width ; y++) {
				grid[x][y] = new Box(x,y,"E");
			}
		}
	}

    public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}

    public void stateChanges() {
		ChangeEvent evt = new ChangeEvent(this);
		for(ChangeListener listener : listeners) {
			listener.stateChanged(evt);
		}
	}

    public int getHeight() {return height;}
    public int getWidth() {return width;}
	public String getSelectedType() {return selectedType;}
    public Box[][] getGrid() {return grid;}
	
    public void setHeight(int height) {
		if (this.height != height) {
			this.height = height ;
			modified = true ; 
			stateChanges();
        }
    }

	public void setWidth(int width) {
		if(this.width != width) {
			this.width = width ;
			modified = true ; 
			stateChanges();
		}
	}

	public void setSelectedType(String selectedType) {
		if(this.selectedType != selectedType) {
			this.selectedType = selectedType;
			modified = true ; 
			stateChanges();
		}
	}
    public void setGrid(Box[][] grid) {
		this.grid = grid;
		modified = true ; 
		stateChanges();
	}

    public void setBox(int x, int y, String type) {
		this.grid[x][y] = new Box(x,y,type);
		modified = true ;
		stateChanges();
	}

    public boolean isModified() {
		return modified;
	}

    /**
      *initiats the maze from a text file
      *@param fileName the name of the text file 
      *@throws MazeReadingException
	  *@throws FileNotFoundException
      */
    public void importFrom(String fileName) throws FileNotFoundException, MazeReadingException {
		Maze labymaze = new Maze(null);
		labymaze.initFromTextFile(fileName);
		MazeBox[][] maze = labymaze.getMaze() ;
		int width = maze[0].length;
		int height = maze.length;
		Box[][] grid0 = new Box[height][width];
		for(int x = 0 ; x<height ; x++) {
			for(int y = 0 ; y<width ; y++) {
				grid0[x][y] = new Box(x,y,maze[x][y].getType());
			}
		}
		this.width = width ;
		this.height = height ;
		this.setGrid(grid0);
	}

	/**
      *saves the maze in a text file
      *@param fileName the name of the text file
      */
    public void save(String fileName){
        try (
			FileOutputStream fos = new FileOutputStream(fileName) ;
            PrintWriter      pw  = new PrintWriter(fos) ;
		){
            for(Box[] row : grid) {
                for(Box box : row) {
                    pw.print(box.getType());
                }
                pw.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
      *solves the maze by finding the shortest path 
      *@return true if the maze has a solution else false  
      */
    public boolean solve() throws FileNotFoundException, MazeReadingException{
		save("tp04/data/savedmaze");

		try ( 
			BufferedReader br = new BufferedReader(new FileReader("tp04/data/savedmaze")) ;
			PrintWriter pw = new PrintWriter(new FileOutputStream("tp04/data/temp"))
			){ 
				String line;
				for (int i=0;i<height;i++){
					line = br.readLine();
					if(line.contains(".")){
						String newline = line.replace(String.valueOf("."),"E");
                		pw.println(newline);
            		}
					else{pw.println(line);}
				}
			} catch (Exception e) {e.printStackTrace();}
        File file = new File("tp04/data/savedmaze");
        file.delete();
        new File("tp04/data/temp").renameTo(file);
		// the previous part helps to refresh the path after when clicking solve

		Maze labymaze = new Maze(null);
		labymaze.initFromTextFile("tp04/data/savedmaze");	
		MazeBox departure = (MazeBox) labymaze.getDeparture();
		MazeBox arrival = (MazeBox) labymaze.getArrival ();
		
		try{
			ShortestPaths shortestPaths =  Dijkstra.dijkstra( labymaze , departure , arrival);
			ArrayList<Vertex> path = shortestPaths.getShortestPathTo(arrival);
			labymaze.showPath(labymaze, path);
			this.importFrom("tp04/data/solution");
			return true;
			}
			catch(NullPointerException e){
				return false;
			}
	}

	/**
      *creates a new maze
      *@param height the height of the maze
	  *@param width the width of the maze
      */
    public void newMaze(int height , int width){
        this.height = height ;
        this.width = width ;
		this.selectedType = "E";
		
		Box[][] grid0 =new Box[height][width];
		for(int x = 0 ; x<height ; x++) {
			for(int y = 0 ; y< width ; y++) {
				grid0[x][y] = new Box(x , y , "E");
			}
		}
		this.setGrid(grid0);
	}

	/**
      *deletes the found path 
      */
	public void clearPath() throws MazeReadingException, FileNotFoundException{
		save("tp04/data/savedmaze");

		try ( 
			BufferedReader br = new BufferedReader(new FileReader("tp04/data/savedmaze")) ;
			PrintWriter pw = new PrintWriter(new FileOutputStream("tp04/data/temp"))
			){ 
				String line;
				for (int i=0;i<height;i++){
					line = br.readLine();
					if(line.contains(".")){
						String newline = line.replace(String.valueOf("."),"E");
                		pw.println(newline);
            		}
					else{pw.println(line);}
				}
			} catch (Exception e) {e.printStackTrace();}
        File file = new File("tp04/data/savedmaze");
        file.delete();
        new File("tp04/data/temp").renameTo(file);

		Maze labymaze = new Maze(null);
		labymaze.initFromTextFile("tp04/data/savedmaze");
		this.importFrom("tp04/data/savedmaze");
	}
	// i added this method just because sometimes the user will want to clear the path before modifying his maze
}


