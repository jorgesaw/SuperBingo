package ar.com.jorgesaw.gui.control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JOptionPane;

import ar.com.jorgesaw.gui.VentanaInterna;
import ar.com.jorgesaw.gui.dialogo.PreguntaGUI;
import ar.com.jorgesaw.gui.vista.busqueda.TipoBusqueda;
import ar.com.jorgesaw.gui.vista.interfaces.GenericVista;
import ar.com.jorgesaw.gui.vista.interfaces.MuestraDatos;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaCerrable;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.buscadores.FabricaBusqGUI;
import ar.com.jorgesaw.modelo.crud.interfaces.MedGeneric;
import ar.com.jorgesaw.superbingo.vista.control.CtrlVentana;
import ar.com.jorgesaw.util.mensajes.MensajeError;
import ar.com.jorgesaw.util.mensajes.MsgOpciones;
import ar.com.jorgesaw.util.mensajes.interfaces.GenericMsg;

public class CtrlGenCRUDBase implements ActionListener, KeyListener, MouseListener {

	private VistaCRUD vista;
	private MedGeneric modelo;
	
	public CtrlGenCRUDBase(VistaCRUD vista, MedGeneric modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	protected VistaCRUD getVista() {
		return vista;
	}

	protected MedGeneric getModelo() {
		return modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (VistaCRUD.GUARDAR.equals(comando)) {
			if (((GenericVista) vista).isValidarDatos()) {
				guardarDatos();
			}
		} else if (VistaCRUD.ACTUAL.equals(comando)) {
			if (((GenericVista) vista).isValidarDatos()) {
				actualizarDatos();
			}
		} else if (VistaCRUD.ELIM.equals(comando)) {
				eliminarDatos();
		} else if (VistaCRUD.NUEVO.equals(comando)) {
			((MuestraDatos) vista).limpiarDatos();
		} else if (VistaCRUD.LISTAR.equals(comando)) {
			listarDatos();
		} else if(VistaCRUD.MOSTRAR.equals(comando)) {
			mostrarDatos();
		} else if (VistaCRUD.BUSCAR.equals(comando)) {
			buscarDatos();
		} else if (VistaCRUD.CERRAR.equals(comando)) {
			cerrarVentana();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		char caracter = e.getKeyChar();
		String nomComp = e.getComponent().getName();

		if ((char) KeyEvent.VK_ENTER == caracter) {
			if (VistaCRUD.GUARDAR.equals(nomComp)) {
				if (((GenericVista) vista).isValidarDatos()) {
					guardarDatos();
				}
			} else if (VistaCRUD.ACTUAL.equals(nomComp)) {
				if (((GenericVista) vista).isValidarDatos()) {
					actualizarDatos();
				}
			} else if (VistaCRUD.ELIM.equals(nomComp)) {
					eliminarDatos();
			} else if (VistaCRUD.NUEVO.equals(nomComp)) {
				((MuestraDatos) vista).limpiarDatos();
			} else if (VistaCRUD.LISTAR.equals(nomComp)) {
				listarDatos();
			} else if(VistaCRUD.MOSTRAR.equals(nomComp)) {
				mostrarDatos();
			} else if (VistaCRUD.BUSCAR.equals(nomComp)) {
				buscarDatos();
			} else if (VistaCRUD.CERRAR.equals(nomComp)) {
				cerrarVentana();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
				
	}

	@Override
	public void keyTyped(KeyEvent e) { }
	
	@Override
	public void mouseClicked(MouseEvent e) {
		String nomComp = e.getComponent().getName();
		
		if (VistaCRUD.TABLA_DATOS.equals(nomComp)) {
			if (e.getClickCount() == 2) {
				mostrarDatos();
			}
			vista.habilitarBoton(VistaCRUD.ELIM, true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	protected void guardarDatos() {
		if (modelo.guardarDatos(vista.getMapDatos())) {
			mostrarMensaje(GenericMensajes.GUARDADO);
			((MuestraDatos) vista).limpiarDatos();
			modelo.mostrarDatos();
		} else 
			mostrarMensaje(GenericMensajes.ERROR);
	}
	
	protected void actualizarDatos() {
		if (modelo.actualizarDatos(vista.getMapDatos())) {
			mostrarMensaje(GenericMensajes.ACTUALIZADO);
			((MuestraDatos) vista).limpiarDatos();
			vista.habilitarBoton(VistaCRUD.ACTUAL, false);
			modelo.mostrarDatosActualiz();
		} else 
			mostrarMensaje(GenericMensajes.ERROR);
	}
	
	protected void eliminarDatos() {
		int fila = modelo.getFilaSelTabla();
		if (fila != -1) {
			int respuesta = PreguntaGUI.getRespuesta(null, GenericMensajes
					.getMapMensaje(GenericMensajes.ELIMINAR));
			
			if (respuesta == PreguntaGUI.RES_SI) {
				if (modelo.eliminarDatos()) {
					mostrarMensaje(GenericMensajes.ELIMINADO);
					((MuestraDatos) vista).limpiarDatos();
					modelo.elimDatoMostrado();
					vista.habilitarBoton(VistaCRUD.ELIM, false);
				} else {
					mostrarMensaje(GenericMensajes.ERROR);
				}
			}
		} else {
			mostrarMensaje(GenericMensajes.SEL_ELEMENT_TABLA);
		}
	}
	
	protected void listarDatos() {
		int cant = modelo.listarDatos();
		if (cant >= 0) {
			if (cant == 0) {
				mostrarMensaje(GenericMensajes.NO_ELEMENTOS);
			}
		} else {
			mostrarMensaje(GenericMensajes.ERROR);
		}
	}
	
	protected void mostrarDatos() {
		int fila = modelo.getFilaSelTabla();
		if (fila != -1) {
			((MuestraDatos) vista).mostrarDatos(modelo.traerDato(fila));
			vista.habilitarBoton(VistaCRUD.ACTUAL, true);
			vista.habilitarBoton(VistaCRUD.GUARDAR, false);
		} else {
			mostrarMensaje(GenericMensajes.SEL_ELEMENT_TABLA);
		}
	}
	
	protected void buscarDatos() {
		Object dato = FabricaBusqGUI.creaBusqGUI(((TipoBusqueda) vista).getTipoBusq()).getDatoBuscado();

		if (dato != null) {
			modelo.setDatoBuscado(dato);
			modelo.mostrarDatos();
		}
	}
	
	protected void cerrarVentana() {
		( (VentanaCerrable) VentanaInterna.getVentana() ).cerrarVentana();
	}
	
	private void mostrarMensaje(int tipo) {
		HashMap<String, Object> mapMensaje = new HashMap<String, Object>();
		switch(tipo) {
			case GenericMensajes.ERROR :
				mapMensaje.put(GenericMsg.TIT,"Mensaje de Error");
				mapMensaje.put(GenericMsg.MSG, MensajeError.mostrarError);
				mapMensaje.put(GenericMsg.ICONO, JOptionPane.ERROR_MESSAGE);
			break;
			case GenericMensajes.GUARDADO :
				mapMensaje = GenericMensajes.getMapMensaje(GenericMensajes.GUARDADO);
			break;
			case GenericMensajes.ELIMINADO:
				mapMensaje = GenericMensajes.getMapMensaje(GenericMensajes.ELIMINADO);
			break;
			case GenericMensajes.ACTUALIZADO :
				mapMensaje = GenericMensajes.getMapMensaje(GenericMensajes.ACTUALIZADO);
			break;
			case GenericMensajes.NO_ELEMENTOS :
				mapMensaje = GenericMensajes.getMapMensaje(GenericMensajes.NO_ELEMENTOS);
			break;
			case GenericMensajes.SEL_ELEMENT_TABLA :
				mapMensaje = GenericMensajes.getMapMensaje(GenericMensajes.SEL_ELEMENT_TABLA);
			break;
		}
		
		MsgOpciones.elegirAceptar((Component) CtrlVentana.getVentanaCerrable(), // Ventana padre de la aplicación.
				(String) mapMensaje.get(GenericMsg.TIT), 
				(String) mapMensaje.get(GenericMsg.MSG), 
				(int) mapMensaje.get(GenericMsg.ICONO));
	}
}