package ar.com.jorgesaw.util.mensajes;

/**
 * 
 * @author jorgesaw
 * Mensajes genéricos para dar aviso a los usuarios.
 *
 */
public class MensajeError {

	public static String mostrarError;

	public static final String NO_VALIDA = "Por favor ingrese correctamente "
			+ "los\ndatos que se piden.";
	public static final String NO_CANT_CARTONES = "Por favor ingrese la cantidad" +
			"\nde cartones a generar";
	
	public static final String[] ERROR = {
			// 0
			"No se pudo conectar a la base de datos.\n"
					+ "Por favor vuelva a intentarlo.",
			// 1
			"No se pudo realizar la consulta.\n"
					+ "Por favor vuelva a introducir el código.",
			// 2
			"Los datos no existen en la base de datos.\n"
					+ "Por favor cargue los datos en el catálogo.",
			// 3
			"No se pudieron guardar los datos.\n"
					+ "Por favor vuelva a intentarlo",
			// 4
			"Imposible guardar. Ya existen datos\n"
					+ "con ese código en la base de datos.",
			// 5
			"Imposible eliminar. No existe datos\n"
					+ "con ese código en la base de datos.",
			// 6
			"Imposible actualizar. No existen datos\n"
					+ "con ese código en la base de datos.",  
			// 7 
			"La transacción ha sido cancelada. Por favor\n"
							+"vuelva a intentarlo.",
			// 8
			"Imposible eliminar. El dato que intenta eliminar está\n"
					+"referenciado en otros datos guardados."
		};
			 
	
}
