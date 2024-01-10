package interfaceutilisateur.menustuff;

import javax.swing.JMenuBar;

import interfaceutilisateur.MazeApp;

public class MenuBar extends JMenuBar {

    private final FileMenu fileMenu ;
	private final MazeMenu mazeMenu ;

    public MenuBar(MazeApp mazeApp){
        super();
        add(fileMenu = new FileMenu(mazeApp));
		add(mazeMenu = new MazeMenu(mazeApp));
    }
}
