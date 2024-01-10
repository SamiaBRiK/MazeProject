package gui.menustuff;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import gui.MazeApp;
import gui.MazeAppModel;
import dijkstra.src.maze.MazeReadingException;

public class ClearPathMenuItem extends JMenuItem implements ActionListener{
    
    private final MazeApp mazeApp;
    
    public ClearPathMenuItem(MazeApp mazeApp){
        super("Clear Path");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        try {
            mazeAppModel.clearPath();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (MazeReadingException ex) {
            JOptionPane.showMessageDialog(null, "Number of departure or arrival are incorrect !");
        }
    }
}
