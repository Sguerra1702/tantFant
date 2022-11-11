package domain;

public class TantFantException extends Exception{
    
    static String NO_MAS_DOS_JUGADORES = "No se permiten mas de dos jugadores";
    static String NO_MISMOS_NOMBRES_NI_COLORES = "No se permite mismo nombre o color";
    static String TURNO_ERRONEO = "turno erroneo";

    public TantFantException(String message){

        super(message);

    }
}
