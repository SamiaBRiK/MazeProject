package gui.menustuff;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import gui.MazeApp;
import gui.MazeAppModel;
import dijkstra.src.maze.MazeReadingException;

public class ImportMenuItem extends JMenuItem implements ActionListener{
    
    private final MazeApp mazeApp;
    
    public ImportMenuItem(MazeApp mazeApp){
        super("Import");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

   @Override
    public void actionPerformed(ActionEvent e) {

        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();

        JFileChooser fc = new JFileChooser("tp04/data/");
        int result = fc.showOpenDialog(this);
		

        if(result==JFileChooser.APPROVE_OPTION){
            File sFile = fc.getSelectedFile();
            try{
                String fileToImport = sFile.getPath();
                mazeAppModel.importFrom(fileToImport);
            }  
            
            catch (FileNotFoundException | MazeReadingException ex){
                ex.printStackTrace();
            }
        }
        
    }
}
