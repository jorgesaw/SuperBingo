package ar.com.jorgesaw.gui;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.JButton;

import ar.com.jorgesaw.gui.comp.CreaComp;
import ar.com.jorgesaw.gui.vista.abstractos.AbstractVentanaTablaImpl;
import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;

public class VistaCRUDTablaImpl extends AbstractVentanaTablaImpl implements VistaCRUD {

	private static final long serialVersionUID = 4440665459465633273L;
	private String[] iconos = {"/recursos/iconos/diamante_24x24.png", "/recursos/iconos/diamante_24x24.png", 
			"/recursos/iconos/diamante_24x24.png", "/recursos/iconos/diamante_24x24.png", 
			"/recursos/iconos/diamante_24x24.png", "/recursos/iconos/diamante_24x24.png", 
			"/recursos/iconos/diamante_24x24.png", "/recursos/iconos/diamante_24x24.png"};
	private HashMap<String, JButton> mapBotones = new HashMap<String, JButton>();
	
	
	public VistaCRUDTablaImpl() {
		super();
		initComponentes();
	}
	
	@Override
	public void habilitarBoton(String nombreBoton, boolean habilitar) {
		if (mapBotones.get(nombreBoton) != null)
			mapBotones.get(nombreBoton).setEnabled(habilitar);
	}
	
	private void initComponentes() {
		btnGuard = CreaComp.creaBoton("Guardar", VistaCRUD.GUARDAR, KeyEvent.VK_G, iconos[0]);
		mapBotones.put(VistaCRUD.GUARDAR, btnGuard);
		btnActual = CreaComp.creaBoton("Actualizar", VistaCRUD.ACTUAL, KeyEvent.VK_L, iconos[1]);
		mapBotones.put(VistaCRUD.ACTUAL, btnActual);
		btnElim = CreaComp.creaBoton("Eliminar", VistaCRUD.ELIM, KeyEvent.VK_E, iconos[2]);
		mapBotones.put(VistaCRUD.ELIM, btnElim);
		btnNuevo = CreaComp.creaBoton("Nuevo", VistaCRUD.NUEVO, KeyEvent.VK_N, iconos[3]);
		mapBotones.put(VistaCRUD.NUEVO, btnNuevo);
		btnListar = CreaComp.creaBoton("Listar todos", VistaCRUD.LISTAR, KeyEvent.VK_T, iconos[4]);
		mapBotones.put(VistaCRUD.LISTAR, btnListar);
		btnBuscar = CreaComp.creaBoton("Buscar", VistaCRUD.BUSCAR, KeyEvent.VK_B, iconos[5]);
		mapBotones.put(VistaCRUD.BUSCAR, btnBuscar);
		btnCerrar = CreaComp.creaBoton("Cerrar", VistaCRUD.CERRAR, KeyEvent.VK_C, iconos[6]);
		mapBotones.put(VistaCRUD.CERRAR, btnCerrar);
		btnMostrar = CreaComp.creaBoton("Mostrar", VistaCRUD.MOSTRAR, KeyEvent.VK_M, iconos[7]);
		mapBotones.put(VistaCRUD.MOSTRAR, btnMostrar);
	}
	
	protected javax.swing.JButton btnActual;
	protected javax.swing.JButton btnBuscar;
	protected javax.swing.JButton btnCerrar;
	protected javax.swing.JButton btnElim;
	protected javax.swing.JButton btnGuard;
	protected javax.swing.JButton btnListar;
	protected javax.swing.JButton btnMostrar;
	protected javax.swing.JButton btnNuevo;

	@Override
	public void cerrarVentana() {
		
	}
}