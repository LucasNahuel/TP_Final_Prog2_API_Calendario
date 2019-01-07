package munoz_nunez.tests;
import java.util.GregorianCalendar;
import java.util.HashSet;


import static org.junit.Assert.*;
import munoz_nunez.*;

import munoz_nunez.Exceptions.CampoInvalido;
import munoz_nunez.Exceptions.EventoInexistente;
import org.junit.Test;

public class CalendarioTest {

    @Test
    public void testEventosPorDia1() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 12, 31));
        evento1.setFin(new GregorianCalendar(2017, 1, 2));

        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorDia(new GregorianCalendar(2017, 1, 1));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorDia2() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2017, 1, 2));
        evento1.setFin(new GregorianCalendar(2017, 1, 2));

        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorDia(new GregorianCalendar(2017, 1, 1));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = false;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorDia3() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2017, 1, 2));
        evento1.setFin(new GregorianCalendar(2017, 1, 2));

        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorDia(new GregorianCalendar(2017, 1, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }


    @Test
    public void testEventosPorTresDias1() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 12, 31));
        evento1.setFin(new GregorianCalendar(2017, 1, 1));

        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorTresDias(new GregorianCalendar(2017, 1, 1));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorTresDias2() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2017, 1, 3));
        evento1.setFin(new GregorianCalendar(2017, 1, 4));

        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorTresDias(new GregorianCalendar(2017, 1, 1));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorSemana1() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 10, 28));
        evento1.setFin(new GregorianCalendar(2016, 10, 29));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorSemana(new GregorianCalendar(2016, 11, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorSemana2() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 11, 5));
        evento1.setFin(new GregorianCalendar(2016, 11, 6));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorSemana(new GregorianCalendar(2016, 11, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = false;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorSemana3() {
        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 11, 4));
        evento1.setFin(new GregorianCalendar(2016, 11, 4));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorSemana(new GregorianCalendar(2016, 10, 28));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testEventosPorMes1() {

        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 11, 1));
        evento1.setFin(new GregorianCalendar(2016, 11, 1));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorMes(new GregorianCalendar(2016, 11, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);


    }


    @Test
    public void testEventosPorMes2() {

        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 11, 31));
        evento1.setFin(new GregorianCalendar(2016, 11, 31));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorMes(new GregorianCalendar(2016, 11, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = true;

        assertEquals(resultadoEsperado, resultadoReal);


    }

    @Test
    public void testEventosPorMes3() {

        Calendario calendario = new Calendario();


        Evento evento1 = new Evento("evento1");


        evento1.setInicio(new GregorianCalendar(2016, 10, 30));
        evento1.setFin(new GregorianCalendar(2016, 10, 30));


        calendario.crearEvento(evento1);

        HashSet<Evento> eventos = calendario.eventosPorMes(new GregorianCalendar(2016, 11, 2));

        boolean resultadoReal = eventos.contains(evento1);
        boolean resultadoEsperado = false;

        assertEquals(resultadoEsperado, resultadoReal);


    }


    @Test
    public void testCrearEvento1() {
        Calendario calendario = new Calendario();

        Evento evento1 = new Evento("evento1");

        calendario.crearEvento(evento1);

        assertEquals(true, calendario.getEventos().contains(evento1));
    }

    @Test
    public void testCrearEvento2() {
        Calendario calendario = new Calendario();

        Evento evento1 = new Evento("evento1");

        Evento evento2 = new Evento("evento1");


        calendario.crearEvento(evento1);
        calendario.crearEvento(evento2);

        assertEquals(1, calendario.getEventos().size());
    }


    @Test
    public void testEditarEvento1() {

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);


        try {
            c.editarEvento("evento1", 1, "evento1.1");
        }catch(Exception ex){};
        assertEquals("evento1.1", e.getTitulo());
    }

    @Test
    public void testEditarEvento2() {

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);
        try{
        c.editarEvento("evento1", 2, Color.TOMATO);
        }catch(Exception ex){};
        assertEquals(Color.TOMATO, e.getColor());
    }


    @Test
    public void testEditarEvento3(){

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        GregorianCalendar noti= new GregorianCalendar(2016, 11, 24);

        try{
        c.editarEvento("evento1", 3, noti);
        }catch(Exception ex){};
        assertEquals(e.getNotificacion(), noti);
    }

    @Test
    public void testEditarEvento4(){

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        GregorianCalendar inicio= new GregorianCalendar(2016, 11, 24);

        try {
            c.editarEvento("evento1", 4, inicio);
        }catch(Exception ex){};
        assertEquals(e.getInicio(), inicio);
    }


    @Test
    public void testEditarEvento5(){

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        GregorianCalendar fin= new GregorianCalendar(2016, 11, 24);

        try{
        c.editarEvento("evento1", 5, fin);
        }catch(Exception ex){};
        assertEquals(e.getFin(), fin);
    }

    @Test
    public void testEditarEvento6(){

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        Usuario invitado=new Usuario("usuario1");

        try{
        c.editarEvento("evento1", 6, invitado);
        }catch(Exception ex){};
        assertEquals(true, e.getInvitados().contains(invitado));
    }


    @Test
    public void testEditarEvento7(){

        Calendario c = new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        Usuario invitado=new Usuario("usuario1");

        e.agregarInvitados(invitado);
        try{
        c.editarEvento("evento1", 7, invitado);
        }catch(Exception ex){};
        assertEquals(false, e.getInvitados().contains(invitado));
    }

    @Test
    public void testEditarEvento8(){
        Calendario c= new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        try {
            c.editarEvento("evento1", 0, new Object());
        }catch(Exception ex){
            assertEquals(true, ex instanceof CampoInvalido);
        }

    }

    @Test
    public void testEditarEvento9(){
        Calendario c= new Calendario();

        Evento e = new Evento("evento1");

        c.crearEvento(e);

        try {
            c.editarEvento("evento2", 1, "evento2");
        }catch(Exception ex){
            assertEquals(true, ex instanceof EventoInexistente);
        }

    }

    @Test
    public void testEliminarEvento1(){
        Calendario c= new Calendario();

        Evento e=new Evento("evento1");

        c.crearEvento(e);

        try {
            c.eliminarEvento("evento1");
        }catch(Exception ex){};


        assertEquals(false, c.getEventos().contains(e));
    }

    @Test
    public void testEliminarEvento2(){
        Calendario c= new Calendario();

        try {
            c.eliminarEvento("evento1");
        }catch(Exception ex){
            assertEquals(true, ex instanceof EventoInexistente);
        }

    }
}
