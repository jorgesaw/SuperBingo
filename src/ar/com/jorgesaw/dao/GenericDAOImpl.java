package ar.com.jorgesaw.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;

import ar.com.jorgesaw.dao.interfaces.GenericDAO;
import ar.com.jorgesaw.hibernate.HibernateUtil;
import ar.com.jorgesaw.util.mensajes.MensajeError;

public class GenericDAOImpl<T, PK extends Serializable> implements
		GenericDAO<T, PK> {

	private Transaction tx = null;
	private Session sesion = null;
	boolean cerrarSesion = true;
	protected static final Logger log = Logger.getLogger(GenericDAOImpl.class
			.getName());

	public GenericDAOImpl() { }

	public GenericDAOImpl(boolean cerrarSesion) {
		this.cerrarSesion = cerrarSesion;
	}

	@Override
	public int insert(T object) {
		int retorno = -1;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				tx = sesion.beginTransaction();
				Serializable id = (Serializable) sesion.save(object);
				tx.commit();
				if (id.toString().equals("0")) { // No se pudo guardar.
					retorno = 0;
					MensajeError.mostrarError = MensajeError.ERROR[3];
				} else
					retorno = 1; // Se guardo.
				MensajeError.mostrarError = MensajeError.ERROR[4];
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}
		return retorno;
	}

	@Override
	public int update(T object) {
		int retorno = -1;
		// Session sesion = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				tx = sesion.beginTransaction();
				sesion.merge(object);
				retorno = 1;
				tx.commit();
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback(); // Deshacemos la transacción
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}

		return retorno;
	}

	@Override
	public int delete(T object) {
		int retorno = 1;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				tx = sesion.beginTransaction();
				sesion.delete(object);
				tx.commit();
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch(ConstraintViolationException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[8];
				retorno = -1;
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback(); // Deshacemos la transacción
				MensajeError.mostrarError = MensajeError.ERROR[7];
				retorno = -1;
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}

		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Class<T> typeClass, PK id) {
		T retorno = null;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				tx = sesion.beginTransaction();
				retorno = (T) sesion.get(typeClass, id);
				tx.commit();
				if (retorno == null) { // No existe en la DB.
					MensajeError.mostrarError = MensajeError.ERROR[2];
				}
			} else {
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} catch (JDBCConnectionException ex) {
			System.out.println("Causa de error: " + ex.getErrorCode());

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> typeClass) {
		List<T> retorno = new ArrayList<T>();
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				tx = sesion.beginTransaction();
				String query = "from " + typeClass.getSimpleName();
				retorno = (List<T>) sesion.createQuery(query).list();
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
			if (cerrarSesion)
				sesion.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPaginated(Class<T> typeClass, int startPosition,
			int maxResult) {
		List<T> retorno = null;

		final StringBuilder sql = new StringBuilder("select c from ").append(
				typeClass.getSimpleName()).append(" c");
		final Query query;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				query = sesion.createQuery(sql.toString());
				query.setFirstResult(startPosition);
				query.setMaxResults(maxResult);
				retorno = (List<T>) query.list();
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPaginated(Class<T> typeClass, int startPosition,
			int maxResult, String order, int dir) {
		List<T> retorno = null;
		String direccion = "ASC";
		if (dir == 2) {
			direccion = "DESC";
		}
		final StringBuilder sql = new StringBuilder("select c from ")
			.append(typeClass.getSimpleName()).append(" c order by")
			.append(order).append(" ").append(direccion);
		final Query query;
		try {
			sesion = HibernateUtil.getSessionFactory().openSession();
			if (!sesion.isDirty()) {
				query = sesion.createQuery(sql.toString());
				query.setFirstResult(startPosition);
				query.setMaxResults(maxResult);
				retorno = (List<T>) query.list();
			}
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				MensajeError.mostrarError = MensajeError.ERROR[7];
			}
		} finally {
			if (cerrarSesion)
				sesion.close();
		}
		return retorno;
	}
	
	@Override
	public int insertMasivo(List<T> objetos) {
		int retorno = 1;
		int cantObjetos = objetos.size();
		try {
			setSesion(HibernateUtil.getSessionFactory().openSession());
			if (!getSesion().isDirty()) {
				setTx(getSesion().beginTransaction());
				
				for (int i = 0; i < cantObjetos;i++) {
					getSesion().save(objetos.get(i));
					if (i % HibernateUtil.BATCH_SIZE == 0) {
						getSesion().flush();
						getSesion().clear();
					}
				}
			}
			getTx().commit();
			MensajeError.mostrarError = MensajeError.ERROR[4]; // Se guardó.
		} catch (HibernateException ex) {
			if (getTx() != null) {
				getTx().rollback();
				retorno = 1;
				log.error(ex);
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} finally {
			 getSesion().close();
		}
		return retorno;
	}

	@Override
	public int updateMasivo(List<T> objetos) {
		int retorno = 1;
		int cantObjetos = objetos.size();
		try {
			setSesion(HibernateUtil.getSessionFactory().openSession());
			if (!getSesion().isDirty()) {
				setTx(getSesion().beginTransaction());
				
				for (int i = 0; i < cantObjetos;i++) {
					getSesion().merge(objetos.get(i));
					if (i % HibernateUtil.BATCH_SIZE == 0) {
						getSesion().flush();
						getSesion().clear();
					}
				}
			}
			getTx().commit();
			MensajeError.mostrarError = MensajeError.ERROR[4]; // Se guardó.
		} catch (HibernateException ex) {
			if (getTx() != null) {
				getTx().rollback();
				retorno = 1;
				log.error(ex);
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} finally {
			 getSesion().close();
		}
		return retorno;
	}

	@Override
	public int deleteMasivo(List<T> objetos) {
		int retorno = 1;
		int cantObjetos = objetos.size();
		try {
			setSesion(HibernateUtil.getSessionFactory().openSession());
			if (!getSesion().isDirty()) {
				setTx(getSesion().beginTransaction());
				
				for (int i = 0; i < cantObjetos;i++) {
					getSesion().delete(objetos.get(i));
					if (i % HibernateUtil.BATCH_SIZE == 0) {
						getSesion().flush();
						getSesion().clear();
					}
				}
			}
			getTx().commit();
			MensajeError.mostrarError = MensajeError.ERROR[4]; // Se eliminò.
		} catch (HibernateException ex) {
			if (getTx() != null) {
				getTx().rollback();
				retorno = 1;
				log.error(ex);
				MensajeError.mostrarError = MensajeError.ERROR[0];
			}
		} finally {
			 getSesion().close();
		}
		return retorno;
	}

	protected Transaction getTx() {
		return tx;
	}

	protected void setTx(Transaction tx) {
		this.tx = tx;
	}

	public Session getSesion() {
		return sesion;
	}

	protected void setSesion(Session sesion) {
		this.sesion = sesion;
	}

	protected boolean isCerrarSesion() {
		return cerrarSesion;
	}
		
}