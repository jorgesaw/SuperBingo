package ar.com.jorgesaw.modelo.buscadores;

import ar.com.jorgesaw.dto.Ciudad;
import ar.com.jorgesaw.dto.Provincia;
import ar.com.jorgesaw.gui.DialogoGUI;
import ar.com.jorgesaw.gui.tabla.ControlTablaImpl;
import ar.com.jorgesaw.gui.tabla.TablaImpl;
import ar.com.jorgesaw.modelo.buscadores.control.ControlBusquedaGenImpl;
import ar.com.jorgesaw.modelo.buscadores.control.interfaces.ControlBusquedaGen;
import ar.com.jorgesaw.modelo.buscadores.interfaces.BuscaEspecifico;
import ar.com.jorgesaw.modelo.buscadores.interfaces.MedBuscaGeneric;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqBingoGUI;
import ar.com.jorgesaw.modelo.buscadores.interfaces.PanelBusqGUI;
import ar.com.jorgesaw.modelo.buscadores.paneles.PanelBusqGUIBingoImpl;
import ar.com.jorgesaw.modelo.crud.tabulado.TablaDataImpl;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaCiudadBusq;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelDireccTel;

public class BusqCiuGUI extends BusqClassGUI<Ciudad> {

	private javax.swing.JFrame padre = null;
	private String titulo = "Ciudades";
	
	BusqCiuGUI() {
		super();
		
		super.setDatoBuscado(mostrarVentana());
	}
	
	public BusqCiuGUI(javax.swing.JFrame padre, String titulo) {
		super();
		this.padre = padre;
		this.titulo = titulo;		
	}
	
	private Ciudad mostrarVentana() {
		DialogoGUI dialogo = DialogoGUI.getDialogo(
				padre, titulo);
		
		PanelBusqBingoGUI vista = new PanelBusqGUIBingoImpl(false);
		
		TablaImpl tablaCiudad = new TablaImpl();
		String[] nombreColumnas = {"", "Ciudad                             " +
				"                                  " +
				"                                        " +
				"                     "};
		Object[] longValores = {new Integer(9), "Nombre de la ciudad"};
		
		ModeloTablaCiudadBusq modeloTablaCiu = new ModeloTablaCiudadBusq(nombreColumnas, longValores);
		ControlTablaImpl<Ciudad> ctrlTabla = new ControlTablaImpl<Ciudad>(
				tablaCiudad, modeloTablaCiu);

		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);

		((PanelBusqGUIBingoImpl) vista).setTabla(ctrlTabla.getTabla());

		// Cambia según la busqueda
		BuscaEspecifico<Ciudad> buscEspecif = new BuscaEspecificoImplCiudad();
		
		TablaData<Bingo> tablaData = new TablaDataImpl<Bingo>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedBuscaGeneric<Ciudad> modelo = new MedBuscaGenericImpl<Ciudad>(buscEspecif, tablaData);		
		
		ControlBusquedaGen control = new ControlBusquedaGenImpl(vista,
				modelo);
		vista.setControlador(control);
		dialogo.addPanel((javax.swing.JPanel) vista);
		dialogo.init();
		
		return modelo.getDatoSeleccionado();
	}

	public void mostrarVentana(Provincia prov) {
		DialogoGUI dialogo = DialogoGUI.getDialogo(
				padre, titulo);
		
		PanelBusqBingoGUI vista = new PanelBusqGUIBingoImpl(false);
		vista.setNameBoton(PanelBusqGUI.BUSCAR);
		vista.setTitleLabel("Ciudad");
		
		TablaImpl tablaCiudad = new TablaImpl();
		String[] nombreColumnas = {"", "Ciudad                             " +
				"                                  " +
				"                                        " +
				"                     "};
		Object[] longValores = {new Integer(9), "Nombre de la ciudad"};
		
		ModeloTablaCiudadBusq modeloTablaCiu = new ModeloTablaCiudadBusq(nombreColumnas, longValores);
		ControlTablaImpl<Ciudad> ctrlTabla = new ControlTablaImpl<Ciudad>(
				tablaCiudad, modeloTablaCiu);

		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);

		((PanelBusqGUIBingoImpl) vista).setTabla(ctrlTabla.getTabla());
		// Cambia según la busqueda
		BuscaEspecifico<Ciudad> buscEspecif = new BuscaEspecificoImplCiudad();
		
		TablaData<Bingo> tablaData = new TablaDataImpl<Bingo>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedBuscaGeneric<Ciudad> modelo = new MedBuscaGenericImpl<Ciudad>(buscEspecif, tablaData);		
		
		ControlBusquedaGen control = new ControlBusquedaGenImpl(vista,
				modelo);
		// Agrego la provincia al mapa de datos para formar parte de la búsqueda.
			vista.getMapDatos().put(IPanelDireccTel.TEXT_PROV, prov);
		
		vista.setControlador(control);
		dialogo.addPanel((javax.swing.JPanel) vista);
		dialogo.init();
		
		super.setDatoBuscado(modelo.getDatoSeleccionado());
	}

}