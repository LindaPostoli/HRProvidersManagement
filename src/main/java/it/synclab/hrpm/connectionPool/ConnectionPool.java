package it.synclab.hrpm.connectionPool;

import java.util.ArrayList;
import java.util.List;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.core.DBConnection;
import it.synclab.hrpm.exception.ConnectionNotFoundException;
import it.synclab.hrpm.exception.FullConnectionPoolException;

public class ConnectionPool {

	private List<Connection> connectionPool;
	private static final int NUM_CONNECTIONS = 10;

	public ConnectionPool() {
		connectionPool = new ArrayList<Connection>();
		init();
	}

	/* Questo metodo si può invocare solo una volta */
	public void init() {
		for (int i = 0; i < NUM_CONNECTIONS; i++)
			connectionPool.add(new DBConnection());

	}

	public Connection getConnection() throws ConnectionNotFoundException {
		if (connectionPool.isEmpty())
			throw new ConnectionNotFoundException("No more connections available");

		for (int i = 0; i < connectionPool.size(); i++)
			if (connectionPool.get(i) != null)
				return connectionPool.remove(i);

		return null;
	}

	public void releaseConnection(Connection connection) throws FullConnectionPoolException {
		if (connectionPool.size() >= NUM_CONNECTIONS)
			throw new FullConnectionPoolException("Connection Pool is already full");

		connectionPool.add(connection);
	}
	
	public int getConnectionNumberAvailable(){
		return connectionPool.size();
	}

}
