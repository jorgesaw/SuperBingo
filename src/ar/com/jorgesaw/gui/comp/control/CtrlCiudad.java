package ar.com.jorgesaw.gui.comp.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.comp.MyJComboBox;
import ar.com.jorgesaw.gui.comp.MyJTextCadenaCiudad;
import ar.com.jorgesaw.modelo.buscadores.BusqCiuGUI;
import ar.com.jorgesaw.modelo.buscadores.BusqClassGUI;
import ar.com.jorgesaw.superbingo.vista.control.CtrlMainBingoImpl;
import ar.com.jorgesaw.superbingo.vista.control.CtrlVentana;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;
import ar.com.jorgesaw.util.mensajes.MsgOpciones;
import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

/**
 * @author jorgesaw 
 * 		Clase que se ocupa de seleccionar la ciudad adecuada según
 *      la provincia seleccionada por el usuario. Muestra la ciudades en una
 *      nueva ventana para permitir la selección del usuario.
 */
public class CtrlCiudad implements ActionListener, KeyListener {

	MyJTextCadenaCiudad txtCiudad;
	MyJComboBox<Object> comboProvincias;

	public CtrlCiudad(MyJTextCadenaCiudad txtCiudad,
			MyJComboBox<Object> comboProvincias) {
		this.txtCiudad = txtCiudad;
		this.comboProvincias = comboProvincias;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char caracter = e.getKeyChar();
		int tecla = e.getKeyCode();
		String nomComp = e.getComponent().getName();
		
		if (caracter == (char) KeyEvent.VK_ENTER
				&& nomComp.equals(IPanelDireccTel.BTN_CIUDAD)) {
			this.buscarCiudades();
		} else if (tecla == KeyEvent.VK_F8
				&& nomComp.equals(IPanelDireccTel.TEXT_CIU)) {
			this.buscarCiudades();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void buscarCiudades() {
		if (comboProvincias.getSelectedIndex() > 0) { // Si seleccionó la provincia.
			Provincia prov = (Provincia) comboProvincias.getSelectedItem();
			
			BusqClassGUI<Ciudad> busqueda = new BusqCiuGUI( // Ventana para buscar ciudades.
					(javax.swing.JFrame) CtrlMainBingoImpl.getVentanaCerrable(),
					"Búsqueda de ciudades");
			// Mostramos la ventana.
			( (BusqCiuGUI) busqueda ).mostrarVentana(prov); 
			// Buscamos el datos seleccionado.
			Ciudad c = busqueda.getDatoBuscado();

			if (c != null) {
				txtCiudad.setCiudad(c);
				txtCiudad.setText(c.getNomCiudad());
			}
		} else { // No seleccionó una provincia aún.
			HashMap<String, Object> mapMensaje = new HashMap<String, Object>();
			
			mapMensaje.put(GenericMsg.TIT, "Info");
			mapMensaje.put(GenericMsg.MSG, "Por favor seleccione una provincia primero.");
			mapMensaje.put(GenericMsg.ICONO, JOptionPane.WARNING_MESSAGE);
			
			// Diálogo qu muestra un mensaje de advertencia.
			MsgOpciones.elegirAceptar(
					(Component) CtrlVentana.getVentanaCerrable(), // Ventana padre de la aplicación.
					(String) mapMensaje.get(GenericMsg.TIT),
					(String) mapMensaje.get(GenericMsg.MSG),
					(int) mapMensaje.get(GenericMsg.ICONO));
		}
	}

}