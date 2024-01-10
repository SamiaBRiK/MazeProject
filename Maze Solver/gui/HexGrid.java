package interfaceutilisateur;

import javax.swing.JPanel;
import java.awt.*;

public class HexGrid extends JPanel{
    private int originX = 40;
    private int originY = 10;
    private int panelWidth = 1000;
    private int panelHeight = 670;
    private HexBox[][] hexagons;
    private int size = 12 ;
    private MazeApp mazeApp;
    HexBoxMouseListener hexBoxMouseListener;

    public int getOriginX(){return originX;}
    public int getOriginY(){return originY;}
    public HexBox[][] getHexagons() {return hexagons;}

    public HexGrid(MazeApp mazeApp) {

        this.mazeApp = mazeApp ;

        this.hexBoxMouseListener= new HexBoxMouseListener(mazeApp,this);
        addMouseListener(hexBoxMouseListener);
        addMouseMotionListener(hexBoxMouseListener);

        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        int height = mazeAppModel.getHeight();
        int width = mazeAppModel.getWidth();
       
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        
        int hexagonWidth = (int)(panelWidth / (1.5*width + 0.5));
        int hexagonHeight = (int)(panelHeight / (1.5*height + 0.5));
        this.size = Math.min(hexagonWidth, hexagonHeight) / 2;

        Box[][] boxes = mazeAppModel.getGrid();
        hexagons = new HexBox[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                hexagons[i][j] = new HexBox(mazeApp,boxes[i][j],size);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (HexBox[] row : hexagons) {
            for (HexBox hexbox : row ) {
                hexbox.paintComponent(g);
            }
        }   
    }

    public void gridrepaint(){
        this.removeAll();

        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        int height = mazeAppModel.getHeight();
        int width = mazeAppModel.getWidth();
 
        Box[][] boxes = mazeAppModel.getGrid();
        hexagons = new HexBox[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                hexagons[i][j] = new HexBox(mazeApp,boxes[i][j],size);
            }
        }
        revalidate();
        repaint();
    }

    public void notifyForUpdate() {
        MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
        if(mazeAppModel.isModified()){
            int height = mazeAppModel.getHeight();
            int width = mazeAppModel.getWidth();

            int hexagonWidth = (int)(panelWidth / (1.5*width + 0.5));
            int hexagonHeight = (int)(panelHeight / (1.5*height + 0.5));
            this.size = Math.min(hexagonWidth, hexagonHeight) / 2;

            gridrepaint();
        }
    }

}
