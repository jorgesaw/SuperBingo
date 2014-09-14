package ar.com.jorgesaw.superbingo.vista.factoria;

import java.awt.Component;
import java.awt.Container;

import ar.com.jorgesaw.gui.VentanaInterna;
import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.tabla.ControlTablaImpl;
import ar.com.jorgesaw.gui.tabla.ModeloTabla;
import ar.com.jorgesaw.gui.tabla.TablaImpl;
import ar.com.jorgesaw.gui.tabla.interfaces.ControlTabla;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;
import ar.com.jorgesaw.modelo.crud.MedGenericImpl;
import ar.com.jorgesaw.modelo.crud.interfaces.MedEspecif;
import ar.com.jorgesaw.modelo.crud.interfaces.MedGeneric;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.modelo.crud.tabulado.TablaDataImpl;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaTipoLot;
import ar.com.jorgesaw.superbingo.modelo.crud.MedEspecifLoteria;
import ar.com.jorgesaw.superbingo.modelo.crud.PojoGenImplTipoLot;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.vista.paneles.LoteriaGUI;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.ILoteriaGUI;

public class PanelLoteriaNuevo extends PanelGUIImpl<Container> {

	public PanelLoteriaNuevo() {
		super();
		super.setContenedor(creaVentana());
	}
	
	private Container creaVentana() {
		ILoteriaGUI vista = new LoteriaGUI();
		MedGeneric modelo = new MedGenericImpl();
		CtrlGenCRUDBase control = new CtrlGenCRUDBase(vista, modelo);
		
		TablaImpl tablaTipoLot = new TablaImpl();
		String[] nombreCol = { "", "Nombre lotería","Nombre breve" };

		Object[] longValores = new Object[] {
		new Integer(9), "Lotería Nacional                                           ", 
		                "Lot. Nacional                         " };
		
		ModeloTabla<TipoLoteria> modeloTablaTipoLot = new ModeloTablaTipoLot(nombreCol, longValores);
		ControlTabla<TipoLoteria> ctrlTabla = new ControlTablaImpl<TipoLoteria>(
				tablaTipoLot, modeloTablaTipoLot);
		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);
		((LoteriaGUI) vista).setTabla(ctrlTabla.getTabla());
		
		TablaData<TipoLoteria> tablaData = new TablaDataImpl<TipoLoteria>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedEspecif<TipoLoteria> medEspecifLot = new MedEspecifLoteria();
		PojoGen<TipoLoteria> pojoGenLot = new PojoGenImplTipoLot();
		medEspecifLot.setPojoGen(pojoGenLot);
		
		modelo.setMedEspecif(medEspecifLot);
		modelo.setTablaData(tablaData);

		vista.setControlador(control);
		
		VentanaInternaBasica ventana = (VentanaInternaBasica) VentanaInterna.getVentana();
		ventana.addPanel((Component) vista);
		ventana.setTitulo("Loterías");
		return (Container) ventana;
	}
	
}