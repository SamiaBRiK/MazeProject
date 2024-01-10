package gui.menustuff;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import interfaceutilisateur.MazeApp;
import interfaceutilisateur.MazeAppModel;
import tp04.src.maze.MazeReadingException;

public class SolveMenuItem extends JMenuItem implements ActionListener{

    private final MazeApp mazeApp;

    public SolveMenuItem(MazeApp mazeApp){
        super("Solve");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        try {
            boolean s = mazeAppModel.solve();
            if(!s){
                JOptionPane.showMessageDialog(null, "No path solution for this maze !");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (MazeReadingException ex) {
            JOptionPane.showMessageDialog(null, "Number of departure or arrival are incorrect !");
        } 
    }

}
