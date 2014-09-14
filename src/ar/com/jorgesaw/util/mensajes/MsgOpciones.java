package ar.com.jorgesaw.util.mensajes;

import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MsgOpciones {
	
	public static int elegirAceptar(Component padre, String titulo, String mensaje,
			int tipoMensaje) {
		Object[] opciones = { "  Aceptar  " };
		JOptionPane pane = new JOptionPane(mensaje,
				tipoMensaje, JOptionPane.OK_OPTION, null,
				opciones, opciones[0]);
		mostrarVentana(padre, pane, titulo);
		
		return getOpcionelegida(opciones, pane.getValue());
	}
	
	public static int elegirSiNo(Component padre, String titulo, String mensaje, 
			int tipoMensaje) {
		Object[] opciones = { "   Si   ", "   No   " };
		
		JOptionPane pane = new JOptionPane(mensaje,
				tipoMensaje, JOptionPane.YES_NO_OPTION, null,
				opciones, opciones[1]);
		mostrarVentana(padre, pane, titulo);
		
		return getOpcionelegida(opciones, pane.getValue());
	}
	
	public static int elegirSiNoCancelar(Component padre, String titulo, String mensaje, 
			int tipoMensaje) {
		Object[] opciones = { "   Si   ", "   No   ", "Cancelar" };
		JOptionPane pane = new JOptionPane(mensaje,
				tipoMensaje, JOptionPane.YES_NO_CANCEL_OPTION, null,
				opciones, opciones[2]);
		mostrarVentana(padre, pane, titulo);
		
		return getOpcionelegida(opciones, pane.getValue());
	}
	
	private static void mostrarVentana(Component padre, JOptionPane pane, String titulo) {
		JDialog dialog = pane.createDialog(padre, titulo);
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	private static int getOpcionelegida(Object[] opciones, Object selectedValue) {
		if (selectedValue == null) 
			return JOptionPane.CLOSED_OPTION; // -1
		//Si no es un array de botones de acción.
		if (opciones == null) {
			if(selectedValue instanceof Integer)
		          return ((Integer)selectedValue).intValue();
		       return JOptionPane.CLOSED_OPTION;
		}
		//Si es un array de botones de acción:
		for (int counter = 0, maxCounter = opciones.length; counter < maxCounter; counter++) {
			if (opciones[counter].equals(selectedValue))
				return counter;
		}
		return JOptionPane.CLOSED_OPTION;
	}
	
	public static void main(String[] args) {
		int valor = MsgOpciones.elegirSiNoCancelar(null, "Hola", "Hola Jorge", JOptionPane.PLAIN_MESSAGE);
		if (valor == JOptionPane.YES_OPTION)
			System.out.println("YES");
		else if (valor == JOptionPane.NO_OPTION)
			System.out.println("NO");
		else if (valor == JOptionPane.CANCEL_OPTION)
			System.out.println("CANCELAR");
	}
}
