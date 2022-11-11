package domain;
import java.util.*; 
import java.awt.*;
public class Jugador {

    private int num;
    private String name;
    private Color color;
    private ArrayList<Ficha> fichas;

    public Jugador(String name,Color color, int num) throws TantFantException{
        this.name = name;
        this.color=color;
        this.fichas = new ArrayList<Ficha>();
        this.num = num;
        arrangeFichas();

    }
    public int getPlayer(){
        return num;
    }

    public String getName(){

        return name;

    }
    public Color getColor(){

        return color;
    }
    private void arrangeFichas() throws TantFantException{
        if(this.num <= 2){
            for(int i=1 ; i<=3; i++){
                Ficha ficha = new Ficha(i, this.color);
                fichas.add(ficha);
            }
        }
        else{

            throw new TantFantException(TantFantException.TURNO_ERRONEO);

        }


    }
    public ArrayList<Ficha> getFichas(){
        return fichas;

    }
}
