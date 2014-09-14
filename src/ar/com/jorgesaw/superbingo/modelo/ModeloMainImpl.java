package ar.com.jorgesaw.superbingo.modelo;

import java.awt.Container;

import ar.com.jorgesaw.superbingo.modelo.interfaces.ModeloMain;
import ar.com.jorgesaw.superbingo.vista.FactoriaPanelesGUI;
import ar.com.jorgesaw.superbingo.vista.factoria.interfaces.PanelGUI;
import ar.com.jorgesaw.superbingo.vista.interfaces.VentanaMainBingo;

public class ModeloMainImpl implements ModeloMain {

	@Override
	public Container abrirVentana(String nomComp) {
		if (VentanaMainBingo.OPCIONES.equals(nomComp)) {
//			return (Container) mostrarOpcionesGUI();
		} else if (VentanaMainBingo.IMPRIMIR.equals(nomComp)) {
//			return (Container) mostrarImprimirGUI();
		} else if (VentanaMainBingo.NUEVO_BINGO.equals(nomComp)) {
			return (Container) mostrarNuevoBingoGUI();
		} else if (VentanaMainBingo.LISTAR_BINGO.equals(nomComp)) {
//			return (Container) mostrarListarBingoGUI();
		} else if (VentanaMainBingo.CONSIG.equals(nomComp)) {
//			return (Container) mostrarConsigGUI();
		} else if (VentanaMainBingo.CARTONES_GENERAR.equals(nomComp)) {
//			return (Container) mostrarGenCartonesGUI();
		} else if (VentanaMainBingo.CARTONES_CARGAR_DATOS.equals(nomComp)) {
//			return (Container) mostrarCargarCartonesGUI();
		} else if (VentanaMainBingo.CARTONES_BUSCAR_DATOS.equals(nomComp)) {
//			return (Container) mostrarBuscarCartonGUI();
		} else if(VentanaMainBingo.EMPLEADOS.equals(nomComp)){
			return (Container) mostrarEmpleadosGUI();
		} else if (VentanaMainBingo.INSTITUCIONES.equals(nomComp)) {
			return (Container) mostrarInstitucionesGUI();
		} else if (VentanaMainBingo.LOTERIAS.equals(nomComp)) {
			return (Container) mostrarLoteriasGUI();
		} else if(VentanaMainBingo.CIUDADES.equals(nomComp)) {
//			return (Container) mostrarCiudadesGUI();
		} else if(VentanaMainBingo.ADD_VENTAS.equals(nomComp)) {
//			return (Container) mostrarVentasGUI();
		} else if (VentanaMainBingo.CONTROL_VENTAS.equals(nomComp)) {
//			return (Container) mostrarControlVentasGUI();
		} else if(VentanaMainBingo.BUSCA_GANADORES.equals(nomComp)) {
//			return (Container) mostrarBuscaGanadoresGUI();
		} else {
//			return (Container) mostrarSorteosGUI(nomComp);
		}
		return null;
	}
	
	private Container mostrarNuevoBingoGUI() {
		return (Container) FactoriaPanelesGUI.creaPanelGUI(PanelGUI.BINGO_NUEVO).getContenedor();
	}
	
	private Container mostrarLoteriasGUI() {
		return (Container) FactoriaPanelesGUI.creaPanelGUI(PanelGUI.LOTERIA_NUEVO).getContenedor();
	}
	
	private Container mostrarEmpleadosGUI() {
		return (Container) FactoriaPanelesGUI.creaPanelGUI(PanelGUI.EMPLEADO).getContenedor();
	}
	
	private Container mostrarInstitucionesGUI() {
		return (Container) FactoriaPanelesGUI.creaPanelGUI(PanelGUI.INSTITUCION).getContenedor();
	}

}