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
import ar.com.jorgesaw.modelo.crud.MedEspecifImpl;
import ar.com.jorgesaw.modelo.crud.MedGenericImpl;
import ar.com.jorgesaw.modelo.crud.interfaces.MedEspecif;
import ar.com.jorgesaw.modelo.crud.interfaces.MedGeneric;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.modelo.crud.tabulado.TablaDataImpl;
import ar.com.jorgesaw.modelo.crud.tabulado.interfaces.TablaData;
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaEmpl;
import ar.com.jorgesaw.superbingo.modelo.crud.PojoGenImplEmpl;
import ar.com.jorgesaw.superbingo.modelo.dto.Empleado;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.modelo.servicios.ServCiudadProv;
import ar.com.jorgesaw.superbingo.vista.paneles.EmpleadosGUI;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelEmpleados;

public class PanelEmplNuevo extends PanelGUIImpl<Container> {

	public PanelEmplNuevo() {
		super();
		super.setContenedor(creaVentana());
	}
	
	private Container creaVentana() {
		IPanelEmpleados vista = new EmpleadosGUI();
		MedGeneric modelo = new MedGenericImpl();
		CtrlGenCRUDBase control = new CtrlGenCRUDBase(vista, modelo);
		
		// Agrego las provincia al combo.
		vista.addProvincias(ServCiudadProv.getProvincias());
		
		TablaImpl tablaEmpl = new TablaImpl();
		String[] nombreCol = { "", "Nombre","Apellido" };

		Object[] longValores = new Object[] {
		new Integer(9), "Nombre                                         ", 
		                "Apellido                                       " };
		
		ModeloTabla<Empleado> modeloTablaEmpl = new ModeloTablaEmpl(nombreCol, longValores);
		ControlTabla<Empleado> ctrlTabla = new ControlTablaImpl<Empleado>(
				tablaEmpl, modeloTablaEmpl);
		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);
		((EmpleadosGUI) vista).setTabla(ctrlTabla.getTabla());
		
		TablaData<TipoLoteria> tablaData = new TablaDataImpl<TipoLoteria>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedEspecif<Empleado> medEspecifEmpl = new MedEspecifImpl<Empleado>();
		PojoGen<Empleado> pojoGenEmpl = new PojoGenImplEmpl();
		medEspecifEmpl.setPojoGen(pojoGenEmpl);
		
		modelo.setMedEspecif(medEspecifEmpl);
		modelo.setTablaData(tablaData);
		
		vista.setControlador(control);
		
		VentanaInternaBasica ventana = (VentanaInternaBasica) VentanaInterna.getVentana();
		ventana.addPanel((Component) vista);
		ventana.setTitulo("Empleados");
		return (Container) ventana;
	}
}