package munoz_nunez.tests;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import munoz_nunez.*;

import org.junit.Test;

public class EventoTest {

	@Test
	public void testEqualsObject1() {
		Evento evento1 = new Evento("evento1");
		Evento evento2 = new Evento("evento1");
		
		boolean resultadoReal = evento1.equals(evento2);
		boolean resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultadoReal);
		
	}
	
	@Test
	public void testEqualsObject2() {
		Evento evento1 = new Evento("evento1");
		Evento evento2 = new Evento("evento2");
		
		boolean resultadoReal = evento1.equals(evento2);
		boolean resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultadoReal);
		
	}

	@Test
	public void testAgregarInvitados() {
		Evento nuevoEvento = new Evento("evento1");
		
		Usuario persona = new Usuario("lucasema21@gmail.com");
		
		nuevoEvento.agregarInvitados(persona);
		
		boolean resultadoReal = nuevoEvento.getInvitados().contains(persona);
		boolean resultadoEsperado = true;
		
		assertEquals(resultadoEsperado, resultadoReal);
	}


	@Test
	public void testRemoverInvitados() {
		Evento nuevoEvento = new Evento("evento1");
		
		Usuario persona = new Usuario("lucasema21@gmail.com");
		
		nuevoEvento.agregarInvitados(persona);
		nuevoEvento.removerInvitados(persona);
		
		boolean resultadoReal = nuevoEvento.getInvitados().contains(persona); 
		boolean resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultadoReal);

	}

	@Test
	public void testEliminarEvento() {
		Calendario nuevoCalendario = new Calendario();	
		
		Evento nuevoEvento = new Evento("evento1");
		
		nuevoCalendario.crearEvento(nuevoEvento);
		
		nuevoEvento.eliminarEvento();
		
		boolean resultadoReal = nuevoCalendario.getEventos().contains(nuevoEvento);
		boolean resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, resultadoReal);
	}

	@Test
	public void testToString() {
		
		Evento nuevoEvento = new Evento("evento1");
		
		nuevoEvento.setInicio(new GregorianCalendar(2017,4,5));
		
		nuevoEvento.setFin(new GregorianCalendar(2017,4,6));
		
		String resultadoReal = nuevoEvento.toString();
		String resultadoEsperado ="Desde el 5/4/2017 hasta el 6/4/2017 evento1";
		
		assertEquals(resultadoEsperado, resultadoReal);
	}

}
