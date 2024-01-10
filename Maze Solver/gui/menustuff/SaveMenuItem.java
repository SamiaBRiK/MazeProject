package gui.menustuff;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import interfaceutilisateur.MazeApp;
import interfaceutilisateur.MazeAppModel;

public class SaveMenuItem extends JMenuItem implements ActionListener{
    
    private final MazeApp mazeApp;
    
    public SaveMenuItem(MazeApp mazeApp){
        super("Save");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        JFileChooser fileChooser = new JFileChooser("tp04/data/");
        int result = fileChooser.showSaveDialog(mazeApp);
        if (result == JFileChooser.APPROVE_OPTION) {
            File sFile = fileChooser.getSelectedFile();
            mazeAppModel.save(sFile.getPath());
        }
    }
}
