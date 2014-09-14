package ar.com.jorgesaw.modelo.buscadores;

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
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaBingoBusq;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;

public class BusqBingoGUI extends BusqClassGUI<Bingo> {
	
	private javax.swing.JFrame padre = null;
	private String titulo = "Bingos";
	
	BusqBingoGUI() {
		super();
		
		super.setDatoBuscado(mostrarVentana());
	}
	
	BusqBingoGUI(javax.swing.JFrame padre, String titulo, 
			String[] nombreCol, Object[] longValores) {
		super();
		
		this.padre = padre;
		this.titulo = titulo;		
		super.setDatoBuscado(mostrarVentana());
	}
	
	private Bingo mostrarVentana() {
		DialogoGUI dialogo = DialogoGUI.getDialogo(
				padre, titulo);
		
		PanelBusqBingoGUI vista = new PanelBusqGUIBingoImpl(true);
		vista.setNameBoton(PanelBusqGUI.ACEPTAR);
		vista.setTitleLabel("Bingos");
		
		TablaImpl tablaBingo = new TablaImpl();
		String[] nombreColumnas = {"", "Bingos                             " +
				"                                  " +
				"                                        " +
				"                     "};
		Object[] longValores = {new Integer(9), "Titulo del bingo"};
		
		ModeloTablaBingoBusq modeloTablaBin = new ModeloTablaBingoBusq(nombreColumnas, longValores);
		ControlTablaImpl<Bingo> ctrlTabla = new ControlTablaImpl<Bingo>(
				tablaBingo, modeloTablaBin);

		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);

		((PanelBusqGUIBingoImpl) vista).setTabla(ctrlTabla.getTabla());
		
		// Cambia según la busqueda
		BuscaEspecifico<Bingo> buscEspecif = new BuscaEspecificoImplBingo();
		
		TablaData<Bingo> tablaData = new TablaDataImpl<Bingo>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedBuscaGeneric<Bingo> modelo = new MedBuscaGenericImpl<Bingo>(buscEspecif, tablaData);		
		
		ControlBusquedaGen control = new ControlBusquedaGenImpl(vista,
				modelo);

		control.listarDatos(null, null);
		
		vista.setControlador(control);

		dialogo.addPanel((javax.swing.JPanel) vista);

		dialogo.init();
		
		return modelo.getDatoSeleccionado();
	}

}