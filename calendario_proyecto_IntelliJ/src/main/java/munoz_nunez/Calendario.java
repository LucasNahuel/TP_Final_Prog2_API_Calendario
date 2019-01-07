package munoz_nunez;


import munoz_nunez.Exceptions.CampoInvalido;
import munoz_nunez.Exceptions.EventoInexistente;

import java.util.*;

/**
 * La clase Calendario permite ligar eventos a un calendario específico, visualizar todos los eventos que pertenezcan al calendario y editar un evento en particular del calendario
 * @author MuñozLucas
 * @author NuñezLucas
 * @version 1.0.0
 *
 */
public class Calendario {

	/**
	 * Nombre del calendario
	 */
	private String nombre;


	/**
	 * Contenedor de eventos
	 */
	private HashSet<Evento> eventos=new HashSet<Evento>();



	/**
	 * Construye un calendario por defecto
	 */
	public Calendario() {};


	/**
	 * Construye un calendario con un nombre especco
	 * @param nombre Nombre del calendario
	 */
	public Calendario(String nombre){
		this.nombre=nombre;
	}



	/**
	 * Retorna el contenedor (HashSet<Evento>) de eventos del calendario
	 * @see Evento
	 * @return Contenedor (HashSet<Evento>) de eventos del calendario
	 *
	 */
	public HashSet<Evento> getEventos() {
		return eventos;
	}



	/**
	 * Setea el contenedor (HashSet<Evento>) de eventos ,dado, al calendario
	 * @param eventos Contenedor (HashSet<Evento>) de eventos del calendario
	 */
	public void setEventos(HashSet<Evento> eventos) {
		this.eventos = eventos;
	}


	/**
	 * Retorna el nombre del calendario
	 * @return Nombre del calendario
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * Setea el nombre ,dado, al calendario
	 * @param nombre Nombre del calendario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * Retorna el contenedor (HashSet<Evento>) de eventos del calendario que contiene los eventos del día dado por un objeto GregorianCalendar
	 *  @param fecha Objeto GregorianCalendar que indica la fecha de la cual mostrar los eventos
	 *  @return Contenedor HashSet<Evento> que contiene todos los eventos del día dado
	 */
	public HashSet<Evento> eventosPorDia(GregorianCalendar fecha){
		HashSet<Evento> eventosDelDia= new HashSet<Evento>();

		for(Evento e: eventos){

			if(e.getInicio().compareTo(fecha)==0 || e.getInicio().compareTo(fecha)==-1 ){
				if(e.getFin().compareTo(fecha)==0 || e.getFin().compareTo(fecha)==1){
					eventosDelDia.add(e);
				}
			}

		}
		
	return eventosDelDia;
	}




	/**
	 * Retorna el contenedor (HashSet<Evento>) de eventos del calendario que contiene los eventos desde el día dado hasta dos días más,dado un objeto GregorianCalendar
	 *  @param fecha Objeto GregorianCalendar que indica la fecha desde la cual se va a empezar a mostrar los eventos
	 *  @return Contenedor HashSet<Evento> que contiene todos los eventos de los tres días
	 */
	public HashSet<Evento> eventosPorTresDias(GregorianCalendar fecha){
		
		HashSet<Evento> tresDias= new HashSet<Evento>();
		
		for(int i=0; i<3; i++){
		tresDias.addAll(eventosPorDia(new GregorianCalendar(fecha.get(1), fecha.get(2), fecha.get(5)+i)));
		}
		
		return tresDias;
	}




	/**
	 * Retorna el contenedor (HashSet<Evento>) del calendario que contiene todos los eventos de toda la semana del dia de la fecha recibida por parámetro
	 *  @param fecha Objeto GregorianCalendar que indica la fecha del dia del cual se desea conocer los eventos de su semana
	 *  @return Contenedor HashSet<Evento> que contiene todos los eventos de la semana
	 */
	public HashSet<Evento> eventosPorSemana(GregorianCalendar fecha){
		
		HashSet<Evento> semana= new HashSet<Evento>();

		while (fecha.get(fecha.DAY_OF_WEEK) > fecha.getFirstDayOfWeek()) {
			fecha.add(Calendar.DATE, -1);
		}

		for(int i=0; i<7; i++){
			semana.addAll(eventosPorDia(new GregorianCalendar(fecha.get(1), fecha.get(2), fecha.get(5)+i)));
		}
		
		return semana;
	}




	/**
	 * Retorna el contenedor (HashSet<Evento>) de eventos del calendario que contiene los eventos de todo el mes pertinente a la fecha recibida
	 *  @param fecha Objeto GregorianCalendar que indica la fecha de la que se desea conocer los eventos de su respectivo mes
	 *  @return Contenedor HashSet<Evento> que contiene todos los eventos del mes
	 */
	public HashSet<Evento> eventosPorMes(GregorianCalendar fecha){
		
		HashSet<Evento> eventosMes= new HashSet<Evento>();
		
		int dias=fecha.getActualMaximum(5);
		
		for(int i=1; i<=dias; i++){

			eventosMes.addAll(eventosPorDia(new GregorianCalendar(fecha.get(1), fecha.get(2), i)));

		}
		
		return eventosMes;
		
	}





	/**
	 * Liga un evento ,dado, con el calendario y lo setea al contenedor de eventos del calendario
	 * @param a Evento a agregar al calendario
	 */
	public void crearEvento(Evento a){
		a.setPertenencia(this);
		eventos.add(a);
	}




	/**
	 * Permite editar un evento identificado por el título dado el campo del evento y el objeto que remplazará al antiguo.
	 * @param titulo Titulo del evento a modificar
	 * @param campo Campo del evento a modificar
	 * @param o Objeto nuevo que remplazar al antiguo.
	 * @see Evento
	 * @throws EventoInexistente No existe un evento con el título especificado en el calendario
	 * @throws CampoInvalido No existe el campo del evento especificado
	 */
	public void editarEvento(String titulo, int campo, Object o) throws EventoInexistente, CampoInvalido{
		try{
			Evento e=buscarEventoPorTitulo(titulo);

			switch(campo){
				case 1 :e.setTitulo((String)o);break;
				case 2 :e.setColor((Color) o);break;
				case 3 :e.setNotificacion((GregorianCalendar)o);break;
				case 4 :e.setInicio((GregorianCalendar)o);break;
				case 5 :e.setFin((GregorianCalendar)o);break;
				case 6 :e.agregarInvitados((Usuario)o);break;
				case 7 :e.removerInvitados((Usuario)o);break;
				default : throw new CampoInvalido("No existe el campo nro "+campo+" en la clase Evento");
			}
		}catch (EventoInexistente ei){
			ei.printStackTrace();
			throw ei;
		}catch (CampoInvalido ci){
			ci.printStackTrace();
			throw ci;
		}
	}




	/**
	 * Busca el evento en el contenedor de eventos dado el titulo del evento
	 * @param titulo Titulo del evento a buscar
	 * @return Evento buscado
	 * @throws EventoInexistente No existe un evento con el titulo especificado en el calendario
	 */
	public Evento buscarEventoPorTitulo(String titulo) throws EventoInexistente{
		if(eventos.contains(new Evento(titulo))){
			java.util.Iterator<Evento> it=eventos.iterator();

			while(it.hasNext()){
				Evento e=it.next();
				if(e.getTitulo().equals(titulo)){
					return e;
				}
			}
		}
		throw new EventoInexistente("No existe un evento con ese título");
	}




	/**
	 * Elimina el evento con el titulo especificado del contenedor de eventos del calendario
	 * @param titulo Titulo del evento a eliminar
	 * @throws EventoInexistente No existe un evento con el titulo especificado en el calendario
	 */
	public void eliminarEvento(String titulo) throws EventoInexistente{
		Evento e;
		try{
			e=buscarEventoPorTitulo(titulo);
		}catch (EventoInexistente ei){
			ei.printStackTrace();
			throw ei;
		}
		eventos.remove(e);
	}









	public boolean equals(Object o){
		Calendario c=(Calendario) o;

		return this.nombre.equals(c.nombre);
	}

}


