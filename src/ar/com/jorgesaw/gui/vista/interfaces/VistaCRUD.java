package ar.com.jorgesaw.gui.vista.interfaces;

public interface VistaCRUD extends GenericVista {

	static final String NUEVO = "Nuevo";
	static final String ACTUAL = "Actualizar";
	static final String ELIM = "Eliminar";
	static final String GUARDAR = "Guardar";
	static final String MOSTRAR = "Mostrar";
	
	static final String LISTAR = "Listar";
	static final String BUSCAR = "Buscar";
	static final String CERRAR = "Cerrar";
	
	static final String TABLA_DATOS = "Tabla datos";
	static final String ID_POJO = "Id pojo";
	
	void habilitarBoton(String nombreBoton, boolean habilitar);
	
}
