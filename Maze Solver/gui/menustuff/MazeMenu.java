package gui.menustuff;

import javax.swing.JMenu;

import gui.MazeApp;

public class MazeMenu extends JMenu{

    private final SolveMenuItem solveMenuItem ;
    private final ClearPathMenuItem clearPathMenuItem ;
    
    public MazeMenu(MazeApp mazeApp){

        super("Maze");
        add(solveMenuItem = new SolveMenuItem(mazeApp));
		add(clearPathMenuItem = new ClearPathMenuItem(mazeApp));
    }
}
