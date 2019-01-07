package munoz_nunez.Exceptions;



/**
 * La clase CampoInvalido es una excepciòn que se lanza cuando se ingresa un campo del Evento inexisteente
 *@see Evento
 *@author Muñoz Lucas
 *@author Nuñez Lucas
 *@version 1.0.0
 */
public class CampoInvalido extends Exception{


    public CampoInvalido(String s){
        super(s);
    }
}
