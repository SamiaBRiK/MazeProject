package interfaceutilisateur.menustuff;

import javax.swing.JMenu;

import interfaceutilisateur.MazeApp;

public class FileMenu extends JMenu{

    
    private final QuitMenuItem quitMenuItem ;
    private final ImportMenuItem importMenuItem;
    private final SaveMenuItem saveMenuItem;

    public FileMenu(MazeApp mazeApp){
        super("File");
        add(quitMenuItem = new QuitMenuItem(mazeApp));
		add(importMenuItem = new ImportMenuItem(mazeApp));
		add(saveMenuItem = new SaveMenuItem(mazeApp));
    }
}
