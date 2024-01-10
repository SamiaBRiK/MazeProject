package gui.buttons;

import javax.swing.JPanel;

import interfaceutilisateur.MazeApp;

import java.awt.*;

public class ButtonsPanel extends JPanel {

    private final TypeButton typeA;
    private final TypeButton typeD;
    private final TypeButton typeE;
    private final TypeButton typeW;
    private final NewMazeButton newMaze;

    public ButtonsPanel(MazeApp mazeApp){
        
        setLayout(new GridLayout(5,1));
        

        setPreferredSize(new Dimension(100,100));
        setBackground(Color.lightGray);
        add(newMaze= new NewMazeButton(mazeApp));

        typeA = new TypeButton(mazeApp,"Arrival");
        typeA.setBackground(Color.BLUE);
        typeA.setForeground(Color.WHITE);
        add(typeA);

        typeD = new TypeButton(mazeApp,"Departure");
        typeD.setBackground(Color.RED);
        typeD.setForeground(Color.WHITE);
        add(typeD);

        typeE = new TypeButton(mazeApp,"Empty");
        typeE.setBackground(Color.WHITE);
        add(typeE);
        
        typeW = new TypeButton(mazeApp,"Wall");
        typeW.setBackground(Color.BLACK);
        typeW.setForeground(Color.WHITE);
        add(typeW);
        
    }

   
		
}
