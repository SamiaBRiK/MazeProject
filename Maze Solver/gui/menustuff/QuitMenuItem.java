package interfaceutilisateur.menustuff;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import interfaceutilisateur.MazeApp;
import interfaceutilisateur.MazeAppModel;

public class QuitMenuItem extends JMenuItem implements ActionListener{
    
    private final MazeApp mazeApp;
    
    public QuitMenuItem(MazeApp mazeApp){
        super("Quit");
        this.mazeApp = mazeApp;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        if (mazeAppModel.isModified()) {
            int response = JOptionPane.showInternalOptionDialog(this,
                                                                "Maze not saved. Save it ?",
                                                                "Quit application",
                                                                JOptionPane.YES_NO_CANCEL_OPTION,
                                                                JOptionPane.WARNING_MESSAGE,
                                                                null,null,null) ;
            switch (response) {
               case JOptionPane.CANCEL_OPTION:
                  return;
               
               case JOptionPane.OK_OPTION:
               JFileChooser fileChooser = new JFileChooser("tp04/data/");
               int result = fileChooser.showSaveDialog(mazeApp);
               if (result == JFileChooser.APPROVE_OPTION) {
                   File sFile = fileChooser.getSelectedFile();
                   mazeAppModel.save(sFile.getPath());
               }
               break;
               
               case JOptionPane.NO_OPTION:
                  break ;
            }
         }
         mazeApp.dispose();
         mazeApp.setVisible(false);
    }
}
