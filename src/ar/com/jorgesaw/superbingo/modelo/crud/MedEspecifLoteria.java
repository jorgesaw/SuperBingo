package ar.com.jorgesaw.superbingo.modelo.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.dao.interfaces.GenericDAO;
import ar.com.jorgesaw.modelo.crud.MedEspecifImpl;
import ar.com.jorgesaw.superbingo.modelo.dto.Loteria;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.HoraLoteria;

public class MedEspecifLoteria extends MedEspecifImpl<TipoLoteria> {

	GenericDAO<Loteria, Integer> DAOLoteria = new GenericDAOImpl<Loteria, Integer>();

	public MedEspecifLoteria() {
		super();
	}

	@Override
	public void guardarPojo(HashMap<String, Object> mapDatos) {
		super.guardarPojo(mapDatos);
		boolean guardado = super.getPojo() != null;

		if (guardado) {
			List<Loteria> loterias = new ArrayList<Loteria>();
			HoraLoteria[] valores = HoraLoteria.values();
			for (int i = 0; i < 3; i++) {
				// Como las horas de la lotería son tres no las obtengo de la base de datos para evitar el tiempo extra al leer los datos.
				ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria horasLot = new ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria(
						i + 1, valores[i].toString());
				loterias.add(new Loteria(super.getPojo(), horasLot));
			}
			
			guardado = DAOLoteria.insertMasivo(loterias) > 0;
			// Si no guardo las loterías borramos el tipo de lotería.
			if (!guardado) {
				super.elimPojo();
			}
		}
	}

}
