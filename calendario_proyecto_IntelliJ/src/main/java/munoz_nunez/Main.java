package munoz_nunez;

import java.util.GregorianCalendar;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GregorianCalendar n= new GregorianCalendar(2016, 11, 32);

		//5 es el campo del dia
		
		
		System.out.println(n.get(5)+" "+n.get(2)+" "+n.get(1));
	}

}
