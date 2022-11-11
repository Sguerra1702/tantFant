package domain;

public class TantFantException extends Exception{
    
    static String NO_MAS_DOS_JUGADORES = "No se permiten mas de dos jugadores";
    static String NO_MISMOS_NOMBRES_NI_COLORES = "No se permite mismo nombre o color";
    static String TURNO_ERRONEO = "turno erroneo";
    static String FUERA_DE_RANGO = "salio del rango de juego";
    static String GANO= "FELICIDADES, HAS GANADO";

    public TantFantException(String message){

        super(message);

    }
}
