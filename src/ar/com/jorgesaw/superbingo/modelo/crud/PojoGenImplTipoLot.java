package ar.com.jorgesaw.superbingo.modelo.crud;

import java.io.Serializable;
import java.util.HashMap;

import ar.com.jorgesaw.gui.vista.interfaces.VistaCRUD;
import ar.com.jorgesaw.modelo.crud.interfaces.PojoGen;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.vista.paneles.interfaces.ILoteriaGUI;

/**
 * Clase que implementa una serie de métodos para acceder a los datos de un tipo de lotería..
 * @author jorgesaw
 * @version 1.0
 */
public class PojoGenImplTipoLot implements PojoGen<TipoLoteria> {

	/**
	 * Clase que crea un TipoLoteria a pertir de los datos de un HashMap.
	 * @return Devuelve un TipoLoteria.
	 */
	@Override
	public TipoLoteria makePojo(HashMap<String, Object> mapDatos) {
		TipoLoteria tipoLot = new TipoLoteria();
		cargarDatosPojo(mapDatos, tipoLot);
		
		return tipoLot;
	}

	/**
	 * 
	 * @return Devuelve la clase TipoLoteria.
	 */
	@Override
	public Class<TipoLoteria> getClasePojo() {
		return TipoLoteria.class;
	}

	/**
	 * @return Devuelve un Map con los datos de un TipoLoteria
	 * @param pojo Un tipo de lotería.
	 */
	@Override
	public HashMap<String, Object> getPojo2Data(TipoLoteria pojo) {
		HashMap<String, Object> mapDatos = new HashMap<String, Object>();
		
		mapDatos.put(ILoteriaGUI.TEXT_NOM_LOT, pojo.getNombre());
		mapDatos.put(ILoteriaGUI.TEXT_ALIAS_LOT, pojo.getAlias());
		
		return mapDatos;
	}

	
	@Override
	public TipoLoteria getPojoConID(HashMap<String, Object> mapDatos) {
		TipoLoteria tipoLot = makePojo(mapDatos);
		tipoLot.setIdTipo((Integer) mapDatos.get(VistaCRUD.ID_POJO));
		
		return tipoLot;
	}

	@Override
	public Serializable getIdPojo(TipoLoteria pojo) {
		return pojo.getIdTipo();
	}

	@Override
	public void actualizarPojo(HashMap<String, Object> mapDatos,
			TipoLoteria pojo) {
		cargarDatosPojo(mapDatos, pojo);
	}
	
	private void cargarDatosPojo(HashMap<String, Object> mapDatos, TipoLoteria tipoLot) {
		tipoLot.setNombre((String) mapDatos.get(ILoteriaGUI.TEXT_NOM_LOT));
		tipoLot.setAlias((String) mapDatos.get(ILoteriaGUI.TEXT_ALIAS_LOT));
	}
}
