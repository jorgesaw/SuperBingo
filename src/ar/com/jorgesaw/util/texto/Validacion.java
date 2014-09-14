package ar.com.jorgesaw.util.texto;

public class Validacion {
	
	public static boolean longCadena(String cadena, int min, int max) {
		boolean retorno = false;;
		if (cadena.length() >= min && cadena.length() <= max) {
			retorno = true;
		}
		return retorno;
	}
	
	public static boolean esVacio(String cadena) {
		return cadena.length() == 0;
	}
	
	public static boolean esNull(Object objeto) {
		return objeto == null;
	}
	public static boolean soloNumeros(String cadena) {
		try {
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	public static boolean soloLetras(String cadena) {
		int i, lon = cadena.length();
		for (i = 0; i < lon;i++) {
			if (!Character.isAlphabetic(cadena.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int cad = (Integer) null;
		String a = String.valueOf(cad);
		System.out.println(Validacion.esNull(a));
	}

}
