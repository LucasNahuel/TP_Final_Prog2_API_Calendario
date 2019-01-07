package munoz_nunez.Exceptions;

/**
 * La clase CalendarioInexistente es una excepciòn que se lanza cuando no se encuentra el calendario buscado
 *@author Muñoz Lucas
 *@author Nuñez Lucas
 *@version 1.0.0
 */
public class CalendarioInexistente extends Exception {

    public CalendarioInexistente(String name){
        super(name);
    }
}
