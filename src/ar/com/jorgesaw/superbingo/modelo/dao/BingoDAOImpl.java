package ar.com.jorgesaw.superbingo.modelo.dao;

import org.hibernate.HibernateException;

import ar.com.jorgesaw.dao.GenericDAOImpl;
import ar.com.jorgesaw.hibernate.HibernateUtil;
import ar.com.jorgesaw.superbingo.modelo.dao.interfaces.BingoDAO;
import ar.com.jorgesaw.superbingo.modelo.dto.Bingo;
import ar.com.jorgesaw.util.mensajes.MensajeError;

public class BingoDAOImpl extends GenericDAOImpl<Bingo, Long> 
	implements BingoDAO {

	public BingoDAOImpl() { super(); }
	
	public BingoDAOImpl(boolean cerrarSesion) { super(cerrarSesion); }
	
	/**
	 * Devueve la cantidad de cartones del id del bingo seleccionado.
	 * @param idBingo El id del bingo.
	 * @return Cantidad de cartones de un bingo.
	 */
	public Long getCantCartones(Long idBingo) {
		Long retorno = null;
		String query = "select count(*) " +
				"from Bingo bin " +
				"join bin.series as s " +
				"join s.cartones as c " +
				"where bin.idBingo = "+ idBingo;
		try {
			super.setSesion(HibernateUtil.getSessionFactory().openSession());
			if (!super.getSesion().isDirty()) {
				super.setTx(super.getSesion().beginTransaction());
				
				retorno = ( (Long) getSesion().createQuery(query).iterate().next() ).longValue();

				super.getTx().commit();
				if (retorno == null) { // No existe en la DB.
					MensajeError.mostrarError = MensajeError.ERROR[2];
				}
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (HibernateException ex) {
			if (super.getTx() != null) {
				super.getTx().rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (isCerrarSesion())
				getSesion().close();
		}
		return retorno;
	}

}
