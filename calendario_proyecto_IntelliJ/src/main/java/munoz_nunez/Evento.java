package munoz_nunez;

import java.util.*;

/**
 * La clase Evento permite crear,customizar y eliminar un evento
 * @author MuñozLucas
 * @author Nuñez Lucas
 * @version 1.0.0
 */
public class Evento{



	/**Campo 1: titulo del evento*/
	private String titulo;

	/**Campo 2: color del evento*/
	private Color color;

	/**Campo 3: notificacion del evento*/
	private GregorianCalendar notificacion;

	/**Campo 4: fecha de inicio del evento*/
	private GregorianCalendar inicio;

	/**Campo 5: fecha de fin del evento*/
	private GregorianCalendar fin;

	/**Campo 6: invitados al evento*/
	private LinkedList<Usuario> invitados=new LinkedList<Usuario>();


	/** Calendario al que pertenece el evento*/
	private Calendario pertenencia;


	/**
	 * Construye un evento con un titulo específico
	 * @param titulo Titulo del evento
	 */
	public Evento(String titulo){
		this.titulo=titulo;
	}



	/**
	 *Retorna el titulo del evento
	 *@return Titulo del evento
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * Setea el titulo del evento ,dado, al evento
	 * @param titulo Titulo del evento
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	/**
	 * Retorna el color del envento. Los colores se obtienen del enum Color
	 * @see Color
	 * @return Color del evento
	 */
	public Color getColor() {
		return color;
	}




	/**
	 *Setea el color ,dado, al evento. Los colores se obtienen del enum Color
	 *@see Color
	 *@param color Color del evento
	 */
	public void setColor(Color color) {
		this.color = color;
	}



	/**
	 *Retorn un GregoriaCalendar que indica la fecha de la notificación el evento
	 *@return Objeto GregorianCalendar que indica la fecha de la notificación	 */
	public GregorianCalendar getNotificacion() {
		return notificacion;
	}





	/**
	 * Setea la fecha de la notificación dado un Objeto GregorianCalendar
	 * @param notificacion Objeto GregorianCalendar que indica la fecha de la notificación	 */
	public void setNotificacion(GregorianCalendar notificacion) {
		this.notificacion = notificacion;
	}






	/**
	 * Retorna un objeto GregorianCalendar que indica la fecha en la cual inicia el evento
	 * @return Objeto GregorianCalendar que indica la fecha en la cual inicia el evento
	 */
	public GregorianCalendar getInicio() {
		return inicio;
	}




	/**
	 * Setea la fecha en la cual inicia el evento dado un objeto GregorianCalendar
	 * @param inicio Objeto GregorianCalendar que indica la fecha en la cual inicia el evento
	 */
	public void setInicio(GregorianCalendar inicio) {
		this.inicio = inicio;
	}



	/**
	 * Retorna un objeto GregorianCalendar que indica la fecha en la cual finaliza el evento
	 * @return Objeto GregorianCalendar que indica la fecha en la cual finaliza el evento
	 */
	public GregorianCalendar getFin() {
		return fin;
	}



	/**
	 * Setea la fecha en la cual finaliza el evento dado un objeto GregorianCalendar
	 * @param fin Objeto GregorianCalenda que indica la fecha en la cual finaliza el evento
	 */
	public void setFin(GregorianCalendar fin) {
		this.fin = fin;
	}




	/**
	 * Retorna el contenedor (LinkedList <Usuario>) de invitados del evento
	 * @see Usuario
	 * @return Contenedor (LinkedList<Usuario>) de invitados del evento
	 */
	public LinkedList<Usuario> getInvitados() {
		return invitados;
	}



	/**
	 * Setea los invitados al evento dado un contenedor (LinkedList<Usuario>) de invitados
	 * @see Usuario
	 * @param invitados Contenedor (LinkedList<Usuario>) de invitados
	 */
	public void setInvitados(LinkedList<Usuario> invitados) {
		this.invitados = invitados;
	}




	/**
	 * Liga el evento con un calendario dado
	 * @param pertenencia Calendario al cual va a pertenecer el evento
	 */
	public void setPertenencia(Calendario pertenencia) {
		this.pertenencia = pertenencia;
	}





	/**
	 * Retorna un hash code para este evento. Equivale a la longitud del String del titulo
	 * @return  Valor del hash code del evento
	 */
	public int hashCode(){
		return titulo.length();
	}




	/**
	 * Compara este evento con un objeto especco. El resultado es true si los eventos tienen el mismo titulo y es false en caso contrario
	 * @param o el Object con el cual comparar
	 * @return true si son iguales, en otro caso false
	 */
	public boolean equals(Object o){
		Evento e=(Evento)o;
		return titulo.equals(e.titulo);
	}



	/**
	 * Agrega un invitado al contenedor (LinkedList<Usuario>) de invitados del evento
	 * @see Usuario
	 * @param u Usuario a agregar al contenedor de invitados del evento
	 */
	public void agregarInvitados(Usuario u){
		invitados.add(u);
	}




	/**
	 * Elimina un invitado del contenedor (LinkedList<Usuario>) de invitados del evento
	 * @see Usuario
	 * @param u Usuario a ser eliminado del contenedor (LinkedList<Usuario>) de invitados del evento
	 */
	public void removerInvitados(Usuario u){
		invitados.remove(u);
	}




	/**
	 * Elimina el evento del contenedor (HashSet<Evento>) de eventos del calendario al cual pertenece
	 */
	public void eliminarEvento(){
		pertenencia.getEventos().remove(this);
	}


	/**
	 * Retorna un String que representa el evento. por ejempolo: Desde el 7/12/2016 hasta el 8/12/2016 tituloDelEvento
	 * @return String que representa al evento
	 */
	public String toString(){
		return "Desde el "+inicio.get(5)+"/"+inicio.get(2)+"/"+inicio.get(1)+
				" hasta el "+fin.get(5)+"/"+fin.get(2)+"/"+fin.get(1)+" "+titulo;
	}
}
