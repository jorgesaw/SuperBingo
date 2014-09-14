package ar.com.jorgesaw.superbingo.vista.interfaces;

import ar.com.jorgesaw.superbingo.vista.control.CtrlMainBingoImpl;

public interface VentanaMainBingo {

	static final String OPCIONES = "Opciones";
	static final String IMPRIMIR = "Imprimir";
	static final String SALIR = "Salir";
	
	static final String NUEVO_BINGO = "Nuevo bingo";
	static final String LISTAR_BINGO = "Listar bingo";
	static final String EMPLEADOS = "Empleados";
	static final String INSTITUCIONES = "Instituciones";
	static final String LOTERIAS = "Loterias";
	static final String CIUDADES = "Ciudades";
	static final String CARGA_SORTEO = "Carga sorteo";
	
	static final String CONSIG = "Consignatario";
	
	static final String CARTONES_GENERAR = "Cartones generar";
	static final String CARTONES_CARGAR_DATOS = "Cartones cargar datos";
	
	static final String ADD_VENTAS ="Agregar ventas";
	static final String CONTROL_VENTAS = "ontrol ventas";
	static final String BUSCA_GANADORES = "Busca ganadores";
	static final String CARTONES_BUSCAR_DATOS = "Buscar datos";
	
	void setControlador(CtrlMainBingoImpl c);
	
}