package domain;
import java.awt.*;
public class Ficha {
    
    private int id;
    private Color color;
    private int posx, posy;
    public Ficha(int id, Color color){
        this.id = id;
        this.color = color;
    }
    public void changePos(int x, int y) throws TantFantException{
        if(x <3 || y<3){
        posx = x;
        posy = y;
        }else{

            throw new TantFantException(TantFantException.FUERA_DE_RANGO);

        }
    }
    public int getPosx(){
        return posx;
    }
    public int getPosy(){

        return posy;

    }
    public int getId(){

        return id;
    }
    public Color getColor(){

        return color;

    }
}
