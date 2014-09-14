package ar.com.jorgesaw.util.texto;

public class NumTexto {

	public static int[] arrayText2ArrayInt(String[] listNum) {
		int[] num = new int[listNum.length];
		int cant = listNum.length;
		
		try {
			for (int i = 0; i < cant;i++) {
				num[i] = Integer.parseInt(listNum[i]);
			}
		} catch(NumberFormatException ex) { 
			ex.printStackTrace();
			num = null;
		}
		
		return num;
	}
	
	/**
	 * Devuelve un array con una lista de enteros para mostrar hipotéticamente
	 * en un combo box.
	 * @param listNum
	 * @param diferencia entero que carga un valor igual al valor de la cadena menos el valor de la 
	 * 			diferencia. Ideal para cargar en un combo box a partir del índice cero.
	 * @return
	 */
	public static int[] arrayText2ArrayInt(String[] listNum, int diferencia) {
		int[] num = new int[listNum.length];
		int cant = listNum.length;
		
		try {
			for (int i = 0; i < cant;i++) {
				num[i] = Integer.parseInt(listNum[i]) - diferencia;
			}
		} catch(NumberFormatException ex) { 
			ex.printStackTrace();
			num = null;
		}
		
		return num;
	}
	
}
