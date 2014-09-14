package test.ar.com.jorgesaw.dao.init;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.jorgesaw.hibernate.HibernateUtil;

public class TestHibernateUtil {

	@Test
	public void testInitTablas() {
		HibernateUtil.getSessionFactory();
	}

}
