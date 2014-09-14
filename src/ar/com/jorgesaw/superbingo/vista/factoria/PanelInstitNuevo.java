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
import ar.com.jorgesaw.superbingo.gui.tabla.ModeloTablaInstit;
import ar.com.jorgesaw.superbingo.modelo.crud.PojoGenImplInstit;
import ar.com.jorgesaw.superbingo.modelo.dto.Institucion;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.modelo.servicios.ServCiudadProv;
import ar.com.jorgesaw.superbingo.vista.paneles.InstitucionGUI;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.IPanelInstitucion;

public class PanelInstitNuevo extends PanelGUIImpl<Container> {

	public PanelInstitNuevo() {
		super();
		super.setContenedor(creaVentana());
	}
	
	private Container creaVentana() {
		IPanelInstitucion vista = new InstitucionGUI();
		MedGeneric modelo = new MedGenericImpl();
		CtrlGenCRUDBase control = new CtrlGenCRUDBase(vista, modelo);
		
		// Agrego las provincia al combo.
		vista.addProvincias(ServCiudadProv.getProvincias());
		
		TablaImpl tablaInstit = new TablaImpl();
		String[] nombreCol = { "", "Categoría",
				"Nombre Institución" , "Nombre breve", 
				"Celular", "Teléfono", 
				"Direccion", "Piso", "Depto.",
				"Ciudad", "Provincia" };

		Object[] longValores = new Object[] {
		new Integer(9), new Long(1111),
		"Club deportivo", 
		"Club Los Alerces de Avellaneda    ",
		"Los Alerces de Avellaneda", 
		"0336 415344456", "0336 415344456", 
		"Dirección dir 1840", "000", "000", 
		"Villa Constitución", "Buenos Aires" };
		
		ModeloTabla<Institucion> modeloTablaInstit = new ModeloTablaInstit(nombreCol, longValores);
		ControlTabla<Institucion> ctrlTabla = new ControlTablaImpl<Institucion>(
				tablaInstit, modeloTablaInstit);
		ctrlTabla.initTamanioColumnas();
		ctrlTabla.getTabla().setRowHeight(
				ctrlTabla.getTabla().getRowHeight() + 8);
		((InstitucionGUI) vista).setTabla(ctrlTabla.getTabla());
		
		TablaData<TipoLoteria> tablaData = new TablaDataImpl<TipoLoteria>();
		tablaData.setControlTabla(ctrlTabla);
		
		MedEspecif<Institucion > medEspecifInstit = new MedEspecifImpl<Institucion >();
		PojoGen<Institucion> pojoGenInstit = new PojoGenImplInstit();
		medEspecifInstit.setPojoGen(pojoGenInstit);
		
		modelo.setMedEspecif(medEspecifInstit);
		modelo.setTablaData(tablaData);
		
		vista.setControlador(control);
		
		VentanaInternaBasica ventana = (VentanaInternaBasica) VentanaInterna.getVentana();
		ventana.addPanel((Component) vista);
		ventana.setTitulo("Instituciones");
		return (Container) ventana;
	}
}
