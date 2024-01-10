package gui;

import java.awt.*;
import javax.swing.JPanel;

public class HexBox extends JPanel{
    private double sqrt3 = Math.sqrt(3);
    private int size ;
    private int originX = 40;
    private int originY = 10;
    private Box box;
    private MazeApp mazeApp;
    private int x1;
    private int y1;

    public Box getBox() {
        return box;
    }

    public HexBox(MazeApp mazeApp,Box box, int size){
        this.mazeApp = mazeApp;
        this.box=box;
        this.size=size;

        double i = box.getX();
        double j = box.getY();

        this.x1 = (int) (originX + 2*size*sqrt3*j + (i%2)*sqrt3*size);
        this.y1 = (int) (originY + i*3*size);
    }

    @Override
    public void paintComponent(Graphics g) {

        double i = box.getX();
        double j = box.getY();

        int x = (int) (originX + 2*size*sqrt3*j + (i%2)*sqrt3*size);
        int y =  (int) (originY + i*3*size);
       
        int[] xPoints = {(int)(x + sqrt3*size), (int)(x + 2*sqrt3*size), (int)(x + 2*sqrt3*size),(int)(x + sqrt3*size), x, x};
        int[] yPoints = {y, y+size, y+3*size, y+4*size, y+3*size, y+size};
        
        switch(box.getType()){
            case "A":
                g.setColor(Color.BLUE);
                break;
            case "D":
                g.setColor(Color.RED);
                break;
            case "E":
                g.setColor(Color.WHITE);
                break;
            case "W":
                g.setColor(Color.BLACK);
                break;
            case ".":
                g.setColor(Color.YELLOW);
                break;
            default :
                g.setColor(Color.WHITE);
        }
      
        g.fillPolygon(xPoints, yPoints, 6);
        g.setColor(Color.lightGray);
        g.drawPolygon(xPoints, yPoints, 6);
    }

    public void notifyForUpdate() {
		repaint();
	}

    /**
      *testes if an hexagone contains a dot
      *@param x the x-coordinate of the dot
      *@param y the y-coordinate of the dot
      *@return true if the dot of coordinates (x,y) is in the hexagone
      */
    public boolean contains(int x, int y) {

        int[] xPoints = {(int)(x1 + sqrt3*size), (int)(x1 + 2*sqrt3*size), (int)(x1 + 2*sqrt3*size),(int)(x1 + sqrt3*size), x1, x1};
        int[] yPoints = {y1, y1+size, y1+3*size, y1+4*size, y1+3*size, y1+size};
        return new java.awt.Polygon(xPoints,yPoints,xPoints.length).contains(x,y);
    }

}