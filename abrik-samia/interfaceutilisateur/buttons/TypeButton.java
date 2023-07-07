package interfaceutilisateur.buttons;

import javax.swing.JButton;
import java.awt.event.*;

import interfaceutilisateur.MazeApp;
import interfaceutilisateur.MazeAppModel;

public class TypeButton extends JButton implements ActionListener{

    private final MazeApp mazeApp;

    public TypeButton(MazeApp mazeApp,String type){
        super(type);
        this.mazeApp = mazeApp;  
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        String type = this.getText();
        mazeAppModel.setSelectedType(type);
    }
}
