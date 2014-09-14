package ar.com.jorgesaw.gui.dialogo;

import java.util.HashMap;

import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

public class PreguntaGUI implements InterModeloPregunta {
	public static final String TIT_INFO = "Info";
	
	public static int getRespuesta(javax.swing.JFrame padre, String titulo, 
			String mensaje) {
	
		InterfazVistaPregunta vistaPregunta = 
				new DialogoPregunta(padre, titulo, mensaje); 
		ControlDialogoPregunta controlPregunta = new ControlDialogoPregunta(
				vistaPregunta); 
		vistaPregunta.setControlador(controlPregunta);
		vistaPregunta.init();
		
		return controlPregunta.getRespuesta();
	}
	
	public static int getRespuesta(javax.swing.JFrame padre, HashMap<String, Object> mapDatos) {
	
		InterfazVistaPregunta vistaPregunta = 
				new DialogoPregunta(padre, (String) mapDatos.get(GenericMsg.TIT), 
						(String) mapDatos.get(GenericMsg.MSG));
		
		ControlDialogoPregunta controlPregunta = new ControlDialogoPregunta(
				vistaPregunta); 
		vistaPregunta.setControlador(controlPregunta);
		vistaPregunta.init();
		
		return controlPregunta.getRespuesta();
	}
	
	public static void main(String[] args) {
		
		System.out.println("RESPUESTA: " + PreguntaGUI.getRespuesta(
				null, PreguntaGUI.TIT_INFO, "¿Qué desea hacer?"));
	}

	@Override
	public void enviarEventoSeleccionado(int evento) {
		
	}
}
