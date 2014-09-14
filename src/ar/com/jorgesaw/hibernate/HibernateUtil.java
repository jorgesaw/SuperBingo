package ar.com.jorgesaw.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.com.jorgesaw.util.mensajes.MensajeError;

/**
 * Objeto global para obtener instancias de SessionFactory.
 * Representa una unidad de trabajo para un único thread en ejecución.
 * Es un objeto instanciado una sola vez.
 * @author jorgesaw
 *
 */
public class HibernateUtil {
	
	public static int BATCH_SIZE = 30;
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
//			Crea la sessionfactory de org.hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Iniciación de SessionFactory fallida. " + ex);
			MensajeError.mostrarError = MensajeError.ERROR[0];
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
