package ar.com.jorgesaw.modelo.buscadores.control;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JOptionPane;

import ar.com.jorgesaw.gui.DialogoGUI;
import ar.com.jorgesaw.gui.control.GenericMensajes;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.buscadores.control.interfaces.ControlBusquedaGen;
import ar.com.jorgesaw.modelo.buscadores.interfaces.MedBuscaGeneric;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqGUI;
import ar.com.jorgesaw.superbingo.vista.control.CtrlVentana;
import ar.com.jorgesaw.util.mensajes.MensajeError;
import ar.com.jorgesaw.util.mensajes.MsgOpciones;
import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

public class ControlBusquedaGenImpl implements ControlBusquedaGen {

	MedBuscaGeneric<?> modelo;
	PanelBusqGUI vista;

	public ControlBusquedaGenImpl(PanelBusqGUI vista, MedBuscaGeneric<?> modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (PanelBusqGUI.ACEPTAR.equals(comando)) {
			this.seleccionarDato();
		} else if (PanelBusqGUI.BUSCAR.equals(comando)) {
			if (((PanelBusqGUI) vista).isValidarDatos(comando)) {
				modelo.limpiarModeloTabla();
				vista.cambiarIconoMouse(Cursor.WAIT_CURSOR);
				listarDatos(vista.getMapDatos(), comando);
				vista.cambiarIconoMouse(Cursor.DEFAULT_CURSOR);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char caracter = e.getKeyChar();
		String nomComp = e.getComponent().getName();

		if (caracter == (char) KeyEvent.VK_ENTER) {
			if (VistaCRUD.TABLA_DATOS.equals(nomComp)) {
				modelo.seleccionarDato();
				cerrarVentana();
			} else if (PanelBusqGUI.ACEPTAR.equals(nomComp)) {
				this.seleccionarDato();
			} else if (PanelBusqGUI.BUSCAR.equals(nomComp)) {
				if (((PanelBusqGUI) vista).isValidarDatos(nomComp)) {
					modelo.limpiarModeloTabla();
					vista.cambiarIconoMouse(Cursor.WAIT_CURSOR);
					listarDatos(vista.getMapDatos(), nomComp);
					vista.cambiarIconoMouse(Cursor.DEFAULT_CURSOR);
				}
			} else if (PanelBusqGUI.TEXT_DATOS.equals(nomComp)) {
				if (PanelBusqGUI.BUSCAR.equals(vista.getNameBoton())) {
					if (((PanelBusqGUI) vista).isValidarDatos(nomComp)) {
						modelo.limpiarModeloTabla();
						vista.cambiarIconoMouse(Cursor.WAIT_CURSOR);
						listarDatos(vista.getMapDatos(), nomComp);
						vista.cambiarIconoMouse(Cursor.DEFAULT_CURSOR);
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		String nomComp = e.getComponent().getName();

		if (VistaCRUD.TABLA_DATOS.equals(nomComp)) {
			if (e.getClickCount() == 2) {
				modelo.seleccionarDato();
				cerrarVentana();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	private void seleccionarDato() {
		if (modelo.getTablaData().getControlTabla().getTabla().getSelectedRow() >= 0) {
			modelo.seleccionarDato();
		} else {
			mostrarMensaje(GenericMensajes.SEL_ELEMENT_TABLA);
		}
	}

	@Override
	public void listarDatos(HashMap<String, Object> mapDatos, String nomComp) {
		int cant = modelo.buscarDatos(mapDatos, nomComp);
		if (cant >= 0) {
			if (cant == 0) {
				mostrarMensaje(GenericMensajes.NO_ELEMENTOS);
			}
		} else {
			mostrarMensaje(GenericMensajes.ERROR);
		}
	}

	protected void cerrarVentana() {
		((VentanaCerrable) DialogoGUI.getDialogo()).cerrarVentana();
	}

	private void mostrarMensaje(int tipo) {
		HashMap<String, Object> mapMensaje = new HashMap<String, Object>();
		switch (tipo) {
		case GenericMensajes.ERROR:
			mapMensaje.put(GenericMsg.TIT, "Mensaje de Error");
			mapMensaje.put(GenericMsg.MSG, MensajeError.mostrarError);
			mapMensaje.put(GenericMsg.ICONO, JOptionPane.ERROR_MESSAGE);
			break;
		case GenericMensajes.GUARDADO:
			mapMensaje = GenericMensajes
					.getMapMensaje(GenericMensajes.GUARDADO);
			break;
		case GenericMensajes.ELIMINADO:
			mapMensaje = GenericMensajes
					.getMapMensaje(GenericMensajes.ELIMINADO);
			break;
		case GenericMensajes.ACTUALIZADO:
			mapMensaje = GenericMensajes
					.getMapMensaje(GenericMensajes.ACTUALIZADO);
			break;
		case GenericMensajes.NO_ELEMENTOS:
			mapMensaje = GenericMensajes
					.getMapMensaje(GenericMensajes.NO_ELEMENTOS);
			break;
		case GenericMensajes.SEL_ELEMENT_TABLA:
			mapMensaje = GenericMensajes
					.getMapMensaje(GenericMensajes.SEL_ELEMENT_TABLA);
			break;
		}

		MsgOpciones.elegirAceptar(
				(Component) CtrlVentana.getVentanaCerrable(), // Ventana padre
																// de la
																// aplicación.
				(String) mapMensaje.get(GenericMsg.TIT),
				(String) mapMensaje.get(GenericMsg.MSG),
				(int) mapMensaje.get(GenericMsg.ICONO));
	}
}
