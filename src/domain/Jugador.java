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
    public void gane(){
        for(Ficha a: fichas){
            for(Ficha b: fichas){
                for(Ficha c: fichas){

                    if((a.getPosx()== 0 && a.getPosy() == 0 )&&(b.getPosx()==1 && b.getPosy()==1)&&(c.getPosx()==2 && c.getPosy()==2)){

                    }
                    if((a.getPosx()== 2 && a.getPosy() == 0 )&&(b.getPosx()==1 && b.getPosy()==1)&&(c.getPosx()==0 && c.getPosy()==2)){

                    }
                    if((a.getPosx()== 0 && a.getPosy() == 0 )&&(b.getPosx()==1 && b.getPosy()==0)&&(c.getPosx()==2 && c.getPosy()==0)){

                    }
                    if((a.getPosx()== 0 && a.getPosy() == 2 )&&(b.getPosx()==1 && b.getPosy()==2)&&(c.getPosx()==2 && c.getPosy()==2)){

                    }
                    if((a.getPosx()== 1 && a.getPosy() == 0 )&&(b.getPosx()==1 && b.getPosy()==1)&&(c.getPosx()==1 && c.getPosy()==2)){

                    }



                }
            }
        }

    }
    public void moveFicha(int ficha, int posx, int posy) throws TantFantException{

        fichas.get(ficha).changePos(posx, posy);

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
