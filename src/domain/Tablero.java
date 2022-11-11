package domain;
import java.util.*;
import java.awt.*;
public class Tablero {
    private ArrayList<Jugador> jugadores;

    public Tablero(){
        jugadores = new ArrayList<Jugador>();
    }
    public void addJugador(String nombre, Color color, int turn) throws TantFantException{
        if(jugadores.size() <= 2 && notSameName(nombre) && notSameColor(color) && notSameTurn(turn)){
            Jugador jugador = new Jugador(nombre, color, turn);
            jugadores.add(jugador);
        }else{
            if(!notSameName(nombre)) throw new TantFantException(TantFantException.NO_MISMOS_NOMBRES_NI_COLORES);
            if(!notSameColor(color)) throw new TantFantException(TantFantException.NO_MISMOS_NOMBRES_NI_COLORES);
            
            else{ throw new TantFantException(TantFantException.NO_MAS_DOS_JUGADORES);}

        }
    }
    
    //METODOS PRIVADOS
    private boolean notSameTurn(int turn){
        boolean res = true;
        for(Jugador a: jugadores){
                if(a.getPlayer() == turn){
                    res=false;
            }
        }
        return res;

    }
    private boolean notSameName(String nombre){
        boolean res = true;
        for(Jugador a: jugadores){
                if(a.getName() == nombre){
                    res=false;
            }
        }
        return res;
    }
    private boolean notSameColor(Color color){
        boolean res = true;
        for(Jugador a: jugadores){
                if(a.getColor() == color){
                    res=false;
            }
        }
        return res;
    }
}
