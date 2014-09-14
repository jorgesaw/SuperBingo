package ar.com.jorgesaw.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ar.com.jorgesaw.dao.interfaces.GenericQueryDAO;
import ar.com.jorgesaw.hibernate.HibernateUtil;
import ar.com.jorgesaw.util.mensajes.MensajeError;

public class GenericQueryDAOImpl<T>
		implements GenericQueryDAO<T> {
	
	protected static final Logger log = Logger.getLogger(GenericQueryDAOImpl.class.getName());
	
	private Transaction tx = null;
	private Session sesion = null;
	boolean cerrarSesion = true;
	
	public GenericQueryDAOImpl() {  }
	
	public GenericQueryDAOImpl(boolean cerrarSesion) { 
		this.cerrarSesion = cerrarSesion;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getDataQueryUniq(String query) {
		T retorno = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!getSesion().isDirty()) {
				tx = sesion.beginTransaction();
				
				retorno = (T) getSesion().createQuery(query).uniqueResult();

				tx.commit();
				if (retorno == null) { // No existe en la DB.
					MensajeError.mostrarError = MensajeError.ERROR[2];
				}
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (isCerrarSesion())
				getSesion().close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getDataQueryList(String query) {
		List<T> retorno = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!getSesion().isDirty()) {
				tx = sesion.beginTransaction();
				
				retorno = (List<T>) getSesion().createQuery(query).list();

				tx.commit();
				if (retorno == null) { // No existe en la DB.
					MensajeError.mostrarError = MensajeError.ERROR[2];
				}
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (isCerrarSesion())
				getSesion().close();
		}
		return retorno;
	}

	@Override
	public Session getSesion() {
		return sesion;
	}

	protected boolean isCerrarSesion() {
		return cerrarSesion;
	}

}
