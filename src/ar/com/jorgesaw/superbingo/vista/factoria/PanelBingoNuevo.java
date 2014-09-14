package ar.com.jorgesaw.superbingo.vista.factoria;

import java.awt.Component;
import java.awt.Container;

import ar.com.jorgesaw.gui.VentanaInterna;
import ar.com.jorgesaw.gui.control.CtrlGenCRUDBase;
import ar.com.jorgesaw.gui.vista.interfaces.VentanaInternaBasica;
import ar.com.jorgesaw.modelo.crud.MedEspecifImpl;
import ar.com.jorgesaw.modelo.crud.MedGenericImpl;
import ar.com.jorgesaw.modelo.crud.interfaces.MedEspecif;
import ar.com.jorgesaw.modelo.crud.interfaces.MedGeneric;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.superbingo.modelo.crud.PojoGenImplBingo;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;
import ar.com.jorgesaw.superbingo.modelo.servicios.ServModelRscBingo;
import ar.com.jorgesaw.superbingo.modelo.servicios.ServModelRscLotBingo;
import ar.com.jorgesaw.superbingo.vista.paneles.BingoNuevoGUI;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.BingoNuevo;

public class PanelBingoNuevo extends PanelGUIImpl<Container>{

	public PanelBingoNuevo() {
		super();
		super.setContenedor(creaVentana());
	}
	
	private Container creaVentana() {
		BingoNuevo vista = new BingoNuevoGUI();
		MedGeneric modelo = new MedGenericImpl();
		CtrlGenCRUDBase control = new CtrlGenCRUDBase(vista, modelo);
		
		vista.setControlador(control);
		
		// Agrego el modelo de los combos a la vista.
		vista.addTipoLoterias(ServModelRscBingo.getTipoLoterias());
		vista.addHorasLot(ServModelRscBingo.getHorasLoterias());
		vista.addPerioJug(ServModelRscLotBingo.getModelPerioJug());
		vista.addPremJug(ServModelRscLotBingo.getModelPremJug());
		vista.addDiasJug(ServModelRscLotBingo.getModelDiasJug());
		
		MedEspecif<Bingo> medEspecifBingo = new MedEspecifImpl<Bingo>();
		PojoGen<Bingo> pojoGenBingo = new PojoGenImplBingo();
		medEspecifBingo.setPojoGen(pojoGenBingo);
		modelo.setMedEspecif(medEspecifBingo);
		
		VentanaInternaBasica ventana = (VentanaInternaBasica) VentanaInterna.getVentana();
		ventana.addPanel((Component) vista);
		ventana.setTitulo("Nuevo Bingo");
		return (Container) ventana;
	}
}
