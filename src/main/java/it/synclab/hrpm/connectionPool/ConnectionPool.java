package it.synclab.hrpm.connectionPool;

import java.util.ArrayList;
import java.util.List;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.core.DBConnection;
import it.synclab.hrpm.exception.ConnectionNotFoundException;
import it.synclab.hrpm.exception.ConnectionPoolAlreadyInstantiatedException;
import it.synclab.hrpm.exception.FullConnectionPoolException;

public class ConnectionPool {

	private static ConnectionPool connectionPool = null;
	private List<Connection> listConnections;
	private static final int NUM_CONNECTIONS = 10;

	private ConnectionPool() {
		listConnections = new ArrayList<Connection>();
		init();
	}

	public void init() {
		for (int i = 0; i < NUM_CONNECTIONS; i++)
			listConnections.add(new DBConnection());

	}

	public static ConnectionPool getInstance() throws ConnectionPoolAlreadyInstantiatedException {
		if (connectionPool != null)
			throw new ConnectionPoolAlreadyInstantiatedException(
					"An instance of ConnectionPool already exists, impossible creating another one");

		connectionPool = new ConnectionPool();

		return connectionPool;
	}

	public Connection getConnection() {
		if (listConnections.isEmpty())
			throw new ConnectionNotFoundException("No more connections available");

		for (int i = 0; i < listConnections.size(); i++)
			if (listConnections.get(i) != null)
				return listConnections.remove(i);

		return null;
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
