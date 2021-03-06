package de.predikant.conference.service.util;

import java.lang.management.ManagementFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.jms.QueueConnectionFactory;
import javax.management.MBeanServer;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Resources {

	@Produces
	@PersistenceContext
	private EntityManager em;

	@Produces
	public Logger produceSlf4JLog(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	public MBeanServer produceMBeanServer() {
		return ManagementFactory.getPlatformMBeanServer();
	}

	@Produces
	public InitialContext produceIC() {
		try {
			return new InitialContext();
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	@Produces
	public QueueConnectionFactory produceQCF() {

		QueueConnectionFactory qcf = null;
		try {
			InitialContext ctx = new InitialContext();
			qcf = (QueueConnectionFactory) ctx.lookup("ConnectionFactory");
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return qcf;
	}

}
