package gui;

import javax.swing.*;

import interfaceutilisateur.buttons.ButtonsPanel;

import java.awt.*;
import java.io.IOException;

public class WindowPanel extends JPanel {

    
    private final HexGrid hexGrid;
    private final ButtonsPanel buttonsPanel;

    public WindowPanel(MazeApp mazeApp) throws IOException {
        setLayout(new BorderLayout());

        add(hexGrid = new HexGrid(mazeApp), BorderLayout.CENTER);
        add(buttonsPanel = new ButtonsPanel(mazeApp), BorderLayout.EAST);
        setBackground(Color.lightGray);
    }

    public void notifyForUpdate() throws IOException{
        hexGrid.notifyForUpdate() ;
     }
}
