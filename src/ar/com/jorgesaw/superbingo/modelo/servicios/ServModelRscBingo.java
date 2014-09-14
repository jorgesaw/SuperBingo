package ar.com.jorgesaw.superbingo.modelo.servicios;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import ar.com.jorgesaw.gui.vista.interfaces.CompBasico;
import ar.com.jorgesaw.superbingo.modelo.dao.InstitucionDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.TipoLoteriaDAOImpl;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.InstitucionDAO;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.TipoLoteriaDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Institucion;
import ar.com.jorgesaw.superbingo.modelo.dto.TipoLoteria;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.HoraLoteria;

public class ServModelRscBingo {
	
	/**
	 * 
	 * @return DefaultComboBoxModel<Object> con las loterías
	 */
	public static DefaultComboBoxModel<Object> getTipoLoterias() {
		DefaultComboBoxModel<Object> retorno = new DefaultComboBoxModel<Object>();
		TipoLoteriaDAO DAOInstit = new TipoLoteriaDAOImpl();
		
		List<TipoLoteria> loterias = DAOInstit.getAll(TipoLoteria.class);
		retorno.addElement(CompBasico.SELECCIONAR);
		
		if (loterias != null && loterias.size() > 0) {
			for (TipoLoteria lot : loterias) {
				retorno.addElement(lot);
			}
		}
//		retorno.insertElementAt("Seleccionar", 0);
//		retorno.insertElementAt(new TipoLoteria(-1, 
//				"Seleccionar", "Seleccionar"), 0);
		return retorno;
	}

	/**
	 * Método que usa enumeradores para mostrar los horarios
	 * y se evita buscarlos en la base de datos.
	 * @return DefaultComboBoxModel<Object> con los horrios de la lotería.
	 */
	public static DefaultComboBoxModel<Object> getHorasLoterias() {
		DefaultComboBoxModel<Object> retorno = new DefaultComboBoxModel<Object>();
		HoraLoteria[] valores = HoraLoteria.values();
		
		for (int i = 0; i < 3;i++) {
			retorno.addElement(
				new ar.com.jorgesaw.superbingo.modelo.dto.HoraLoteria(
						i + 1, valores[i].toString()));
		}
		
		return retorno;
	}

	public static DefaultComboBoxModel<Object> getInstituciones() {
		DefaultComboBoxModel<Object> retorno = new DefaultComboBoxModel<Object>();
		InstitucionDAO DAOInstit = new InstitucionDAOImpl();
		
		List<Institucion> instituciones = DAOInstit.getAll(Institucion.class);
		
		retorno.addElement(CompBasico.SELECCIONAR);
		if (instituciones != null && instituciones.size() > 0) {
			for (Institucion instit : instituciones) {
				retorno.addElement(instit);
			}
		}
		
		return retorno;
	}
}