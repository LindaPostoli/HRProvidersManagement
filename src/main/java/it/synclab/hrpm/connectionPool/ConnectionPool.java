package it.synclab.hrpm.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.synclab.hrpm.exception.ConnectionNotFoundException;
import it.synclab.hrpm.exception.FullConnectionPoolException;

public class ConnectionPool {

	private static ConnectionPool connectionPool = null;
	private List<Connection> listConnections;
	private static final int NUM_CONNECTIONS = 10;

	private ConnectionPool()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		listConnections = new ArrayList<Connection>();
		init();
	}

	public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HRPM", "root",
				"synclab");// FIXME: check username e password

		for (int i = 0; i < NUM_CONNECTIONS; i++) {
			listConnections.add(connection);
		}

	}

	public static ConnectionPool getInstance()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if (connectionPool == null) {
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
	}

	public Connection getConnection() {
		if (listConnections.isEmpty())
			throw new ConnectionNotFoundException("No more connections available");

		return listConnections.remove(0);

	}

	public void releaseConnection(Connection connection) throws FullConnectionPoolException {
		if (listConnections.size() >= NUM_CONNECTIONS)
			throw new FullConnectionPoolException("Connection Pool is already full");

		listConnections.add(connection);
	}

	public int getConnectionNumberAvailable() {
		return listConnections.size();
	}

}
