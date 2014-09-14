package ar.com.jorgesaw.superbingo.modelo.servicios;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.DiasSemana;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.NumJugadas;
import ar.com.jorgesaw.superbingo.modelo.dto.enumerados.PeriodoJugadas;

public class ServModelRscLotBingo {

	/**
	 * 
	 * @return DefaultComboBoxModel con el período de jugadas: diario,semanal, mensual.
	 */
	public static DefaultComboBoxModel<Object> getModelPerioJug() {
		DefaultComboBoxModel<Object> retorno = 
				new DefaultComboBoxModel<Object>();
		PeriodoJugadas[] peJug = PeriodoJugadas.values();
		int i , cant = peJug.length;
		
		for (i = 0; i < cant;i++) {
			retorno.addElement(peJug[i]);
		}
		
		return retorno;
	}
	
	/**
	 * 
	 * @return DefaultComboBoxModel con los números de la lotería que va a jugar: 5, 10, 15, 20.
	 */
	public static DefaultListModel<Object> getModelPremJug() {
		DefaultListModel<Object> retorno = 
				new DefaultListModel<Object>();
		NumJugadas[] numJug = NumJugadas.values();
		int i , cant = numJug.length;
		
		for (i = 0; i < cant;i++) {
			retorno.addElement("1 - " + numJug[i].getPremios());
		}
		
		return retorno;
	}
	
	/**
	 * 
	 * @return DefaultComboBoxModel con los días de la semana.
	 */
	public static DefaultListModel<Object> getModelDiasJug() {
		DefaultListModel<Object> retorno = 
				new DefaultListModel<Object>();
		DiasSemana[] diasJug = DiasSemana.values();
		int i , cant = diasJug.length;
		
		for (i = 1; i < cant;i++) {
			retorno.addElement(diasJug[i]);
		}
		
		return retorno;
	}
}
