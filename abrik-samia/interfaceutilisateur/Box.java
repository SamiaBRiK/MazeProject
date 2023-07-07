package interfaceutilisateur;

public class Box {
    private int x;
    private int y;
    private String type;

    public Box(int x, int y, String type){
    this.x = x;
    this.y = y;
    this.type = type;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public String getType(){return type;}

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setType(String type){this.type = type;}
}