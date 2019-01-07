package munoz_nunez.Exceptions;


/**
 * La clase EventoInexistente es una excepciòn que se lanza cuando no se encuentra el evento buscado
 *@author Muñoz Lucas
 *@author Nuñez Lucas
 *@version 1.0.0
 */

public class EventoInexistente extends Exception{
    public EventoInexistente(){};

    public EventoInexistente(String s){
        super(s);
    }
}
