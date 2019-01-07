package munoz_nunez.tests;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import org.junit.Test;
import munoz_nunez.*;

public class UsuarioTest {

	@Test
	public void testAgregarCalendario() {
		Usuario persona = new Usuario("lucasema21@gmail.com");
		
		Calendario nuevoCalendario = new Calendario();
		
		persona.agregarCalendario(nuevoCalendario);
		
		boolean resultadoReal = persona.getCalendarios().contains(nuevoCalendario);
		boolean resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultadoReal);
	}

	@Test
	public void testVistaDeAgenda() {
		Calendario nuevoCalendario = new Calendario();
		
		Evento evento1 = new Evento("evento1");
	
		
		evento1.setInicio(new GregorianCalendar(2018,6,11));
		evento1.setFin(new GregorianCalendar(2018,7,11));
		

		nuevoCalendario.crearEvento(evento1);
		
        String resultadoReal = evento1.toString();
        String resultadoEsperado = "Desde el 11/6/2018 hasta el 11/7/2018 evento1";
        
        assertEquals(resultadoEsperado, resultadoReal);
        
		
	}

}
