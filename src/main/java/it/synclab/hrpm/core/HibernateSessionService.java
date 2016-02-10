package it.synclab.hrpm.core;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

import it.synclab.hrpm.util.LogUtil;


public class HibernateSessionService {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		System.out.println("fatto");
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

	/*
	 * private static Logger logger; private SessionFactory sessionFactory;
	 * 
	 * public HibernateSessionService(){ this.logger =
	 * LoggerFactory.getLogger(LogUtil.formatClassName(this.getClass())); }
	 * 
	 * public synchronized SessionFactory getSessionFactory() { if
	 * (sessionFactory != null) return sessionFactory; Configuration
	 * configuration = new Configuration();
	 * configuration.configure("hibernate.cfg.xml"); logger.info(
	 * "Hibernate Configuration loaded successfully.");
	 * 
	 * ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	 * .applySettings(configuration.getProperties()).build(); logger.info(
	 * "Hibernate serviceRegistry created successfully."); sessionFactory =
	 * configuration.buildSessionFactory(serviceRegistry);
	 * 
	 * logger.info("Hibernate SessionFactory build successfully.");
	 * 
	 * return sessionFactory; }
	 * 
	 * public Session openSession(boolean readonly) {
	 * 
	 * Session session = getSessionFactory().openSession();
	 * session.setDefaultReadOnly(readonly); logger.trace("Open session " +
	 * session.hashCode() + " defReadOnly: " + readonly + "."); return session;
	 * }
	 * 
	 * public Session getCurrentSession() { return
	 * getSessionFactory().getCurrentSession(); }
	 * 
	 * public void closeSession(Session session) {
	 * 
	 * if (session != null) {
	 * 
	 * logger.trace("Close session {}.", session.hashCode());
	 * 
	 * if (session.isConnected()) {
	 * 
	 * session.clear(); Transaction t = session.getTransaction(); if
	 * (t.getStatus() == TransactionStatus.ACTIVE) t.rollback();
	 * session.flush(); }
	 * 
	 * if (session.isOpen()) session.close(); } }
	 * 
	 * public synchronized void shutdown() {
	 * 
	 * try {
	 * 
	 * if (sessionFactory != null) sessionFactory.close();
	 * 
	 * logger.info("Hibernate SessionFactory closed successfully.");
	 * 
	 * } catch (Exception e) { logger.warn(
	 * "Error shutting down hibernate session factory.", e); }
	 * 
	 * }
	 */
}
