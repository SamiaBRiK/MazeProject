package interfaceutilisateur;

import java.awt.event.*;


public class HexBoxMouseListener extends MouseAdapter implements MouseListener ,MouseMotionListener{
    private MazeApp mazeApp;
    private HexGrid hexGrid;

    public HexBoxMouseListener(MazeApp mazeApp, HexGrid hexGrid) {
		super();
 		this.mazeApp = mazeApp ;
        this.hexGrid = hexGrid ;
	}

    public final void mouseReleased(MouseEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        String selectedType = mazeAppModel.getSelectedType();
       
        int x0 = e.getX() ;
        int y0 = e.getY() ;

        try{
            HexBox hexBox = BoxContaining(x0, y0);
            int x = hexBox.getBox().getX();
            int y = hexBox.getBox().getY();
            
            switch(selectedType){
                case "Arrival" :
                    mazeAppModel.setBox(x, y, "A");
                    break;
                case "Departure" :
                    mazeAppModel.setBox(x, y, "D");
                    break;
                case "Empty" :
                    mazeAppModel.setBox(x, y, "E");
                    break;
                case "Wall" :
                    mazeAppModel.setBox(x, y, "W");
                    break;
            }
        }catch(NullPointerException ex){}
    }


    public final void mouseDragged(MouseEvent e) {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        String selectedType = mazeAppModel.getSelectedType();
    
        int x0 = e.getX();
        int y0 = e.getY();

        try{
            HexBox hexBox = BoxContaining(x0, y0);
            int x = hexBox.getBox().getX();
            int y = hexBox.getBox().getY();
      
            switch(selectedType){
                case "Empty" :
                    mazeAppModel.setBox(x, y, "E");
                    break;
                case "Wall" :
                    mazeAppModel.setBox(x, y, "W");
                    break;
            }
        }catch(NullPointerException ex){}
    }

    /**
      *returns the hexagone containing a given dot
      *@param x the x-coordinate of the dot
      *@param y the y-coordinate of the dot
      *@return the hexagone containing the dot of coordinates (x,y)
      */
    public HexBox BoxContaining(int x, int y){
        HexBox[][] hexagons = hexGrid.getHexagons(); 
        int height = hexagons.length;
        int width = hexagons[0].length;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if ( hexagons[i][j].contains(x,y)){
                    return hexagons[i][j];
                }
            }
        }
        return null ;
    }

}
