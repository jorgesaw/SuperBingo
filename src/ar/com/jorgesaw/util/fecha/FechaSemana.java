package ar.com.jorgesaw.util.fecha;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class FechaSemana {
	
//	new Locale("es_ES")
	public static Calendar calendario = GregorianCalendar.getInstance(Locale.getDefault());
	
	/**
	 * 
	 * @param fecha 
	 * @return Retorna un<B>int</B> entre 1 y 7. Domingo es igual a 1.
	 */
	public static int getNumDiaSemana(java.util.Date fecha) {
		calendario.setTime(fecha);
		
		return calendario.get(Calendar.DAY_OF_WEEK);
	}
	
	public static String getDiaSemana(java.util.Date fecha) {
		calendario.setTime(fecha);
		SimpleDateFormat formato = new SimpleDateFormat("EEEEEEEEEEE");
		
		return formato.format(calendario.getTime());
	}
	
	public static void main(String[] args) {
		System.out.println(getDiaSemana(new java.util.Date()));
	}
}
