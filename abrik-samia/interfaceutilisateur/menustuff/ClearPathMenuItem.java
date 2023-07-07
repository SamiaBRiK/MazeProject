package interfaceutilisateur.menustuff;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import interfaceutilisateur.MazeApp;
import interfaceutilisateur.MazeAppModel;
import tp04.src.maze.MazeReadingException;

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
