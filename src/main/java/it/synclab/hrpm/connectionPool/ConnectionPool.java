package it.synclab.hrpm.connectionPool;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import it.synclab.hrpm.core.HibernateSessionService;
import it.synclab.hrpm.exception.ConnectionNotFoundException;
import it.synclab.hrpm.exception.FullConnectionPoolException;

public class ConnectionPool {
	
	private static ConnectionPool connectionPool = null;
	private List<Session> listConnections;
	private static final int NUM_CONNECTIONS = 10;
	
	private ConnectionPool() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		listConnections = new ArrayList<Session>();
		init();
	}
	
	public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		HibernateSessionService hss = new HibernateSessionService();
		Session session = hss.openSession(false);
		for (int i = 0; i < NUM_CONNECTIONS; i++) {
			listConnections.add(session);
		}
		
	}
	
	public static ConnectionPool getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if (connectionPool == null) {
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
	}
	
	public Session getConnection() {
		if (listConnections.isEmpty())
			throw new ConnectionNotFoundException("No more connections available");
			
		return listConnections.remove(0);
		
	}
	
	public void releaseConnection(Session connection) throws FullConnectionPoolException {
		if (listConnections.size() >= NUM_CONNECTIONS)
			throw new FullConnectionPoolException("Connection Pool is already full");
			
		listConnections.add(connection);
	}
	
	public int getConnectionNumberAvailable() {
		return listConnections.size();
	}
	
}
