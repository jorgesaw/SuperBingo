package ar.com.jorgesaw.util.texto;

import java.text.DecimalFormat;
import java.util.Locale;


public class FormatoNum {
	public static final boolean DEBUG = false;
	/**
	 * Hay cuatro salidas para DecimalFormat.java 
	 * cambiarFormato("###,###.###", 123456.789);
	 * cambiarFormato("###.##", 123456.789);
	 * cambiarFormato("000000.000", 123.78);
	 * cambiarFormato("$###,###.###", 12345.67); 
	 * 
	 * @author jorgesaw - javatutorials/tutorial/java/data/numberformat.html
	 * @param patron
	 * @param valor
	 */
	static public String cambiarFormato(String patron, double valor) {
        DecimalFormat miFormato = new DecimalFormat(patron);
        String salida = miFormato.format(valor);
        salida = salida.replace(",",".");
        
        //double d = (Double) Double.valueOf(salida.toString()).doubleValue();
        //Es más directo ya que devuelve un tipo primitivo.
        double d = Double.parseDouble(salida);
        if (DEBUG) {
        	System.out.println(valor + "  " + patron + "  " + salida + "  " + d);
        }
        return salida;
     }
	
	public static void main(String[] args) {
		
		System.out.println(FormatoNum.cambiarFormato("######.00", new Float(23.7677)));
	}
}
