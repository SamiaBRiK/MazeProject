package gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.menustuff.MenuBar;
import dijkstra.src.maze.MazeReadingException;

public class MazeApp extends JFrame implements ChangeListener{
    public final MenuBar menuBar;
    public final WindowPanel windowPanel; 
    public  MazeAppModel mazeAppModel = new MazeAppModel();

    public MazeAppModel getMazeAppModel() {
        return mazeAppModel;
    }

    public MazeApp()throws IOException, MazeReadingException {
        super("Maze Game :)");
         
        setJMenuBar(menuBar = new MenuBar(this));
        setContentPane(windowPanel = new WindowPanel(this));

        mazeAppModel.addObserver(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public void stateChanged(ChangeEvent e) {
        try {
            windowPanel.notifyForUpdate() ;
        } catch (Exception ex) {
              ex.printStackTrace();
        }
    }
}
