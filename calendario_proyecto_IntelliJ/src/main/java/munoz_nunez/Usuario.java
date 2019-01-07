package munoz_nunez;


import munoz_nunez.Exceptions.CalendarioInexistente;

import java.util.LinkedList;

/**
 * La clase Usuario permite customizar un usuario del programa
 * @author Muñoz Lucas
 * @author Nuñez Lucas
 * @version 1.0.0
 */
public class Usuario {

	/**
	 * Nombre de la cuenta del usuario
	 */
	private String nombreDeCuenta;


	/**
	 * Contenedor (LinkedList<Calendario>) de calendarios que posee el usuario
	 * @see Calendario
	 */
	private LinkedList<Calendario> calendarios= new LinkedList<Calendario>();


	/**
	 * Construye un usuario por defecto
	 */
	public Usuario(){};


	/**
	 * Construye un usuario con nombre de cuenta especco
	 * @param nombreDeCuenta Nombre de la cuenta del usuario
	 */
	public Usuario(String nombreDeCuenta){
		this.nombreDeCuenta=nombreDeCuenta;
	}



	/**
	 * Agrega un calendario al contenedor (LinkedList<Calendario>) de calendarios del usuario
	 * @param c Calendario a agregar al contenedor (LinkedList<Calendario>) de calendarios del usuario
	 */
	public void agregarCalendario(Calendario c){
		calendarios.add(c);
	}


	/**
	 * Retorna el nombre de la cuenta del usuario
	 * @return Nombre de la cuenta del usuario
	 */
	public String getNombreDeCuenta() {
		return nombreDeCuenta;
	}


	/**
	 * Setea el nombre de la cuenta ,dado, al usuario
	 * @param nombreDeCuenta Nombre de la cuenta del usuario
	 */
	public void setNombreDeCuenta(String nombreDeCuenta) {
		this.nombreDeCuenta = nombreDeCuenta;
	}


	/**
	 * Retorna el contenedor (LinkedList<Calendario>) de calendarios del usuario
	 * @see Calendario
	 * @return Contenedor (LinkedList<Calendario>) de calendarios del usuario
	 */
	public LinkedList<Calendario> getCalendarios() {
		return calendarios;
	}



	/**
	 * Setea el contenedor (LinkedList<Calendario>) de calendarios ,dado, al usuario
	 * @see Calendario
	 * @param calendarios Contenedor (LinkedList<Calendario>) de calendarios del usuario
	 */
	public void setCalendarios(LinkedList<Calendario> calendarios) {
		this.calendarios = calendarios;
	}





	/**
	 * Retorna un string con todos los eventos del calendario dado por medio del metodo toString() de la clase Evento
	 * @return String con todos los eventos del calendario
	 * @see Evento.toString()
	 * @param c Calendario del cual queremos ver todos sus eventos
	 */
	public String vistaDeAgenda(Calendario c){
		String vista =new String();
		for(Evento e:c.getEventos()){
			vista+=e.toString();
			vista+='\n';
		}
		return vista;
	}


	/**
	 * Busca entre los calendarios del usuario aquel cuyo nombre coincida con el string recibido
	 * @throws CalendarioInexistente cuando no exista un calendario con el nombre recibido
	 * @return Calendario solicitado
	 * @param nombre string contenedor del nombre del calendario que se desea buscar
	 */
	public Calendario getCalendarioPorNombre(String nombre) throws CalendarioInexistente{
		if(calendarios.contains(new Calendario(nombre))){
			return calendarios.get(calendarios.indexOf(new Calendario(nombre)));
		}
		throw new CalendarioInexistente("El calendario"+nombre+" no existe");
	}
}
