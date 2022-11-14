package domain;
import java.awt.*;
public class tantFant {
    private int x;
    private Tablero board;
    public tantFant() throws TantFantException{
        board = new Tablero();
        board.addJugador("nombre1", Color.black, 1);
        board.addJugador("nombre2", Color.red, 2);
    }

}
