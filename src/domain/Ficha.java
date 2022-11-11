package domain;
import java.awt.*;
public class Ficha {
    
    private int id;
    private Color color;

    public Ficha(int id, Color color){
        this.id = id;
        this.color = color;
    }
    public int getId(){

        return id;
    }
    public Color getColor(){

        return color;

    }
}
