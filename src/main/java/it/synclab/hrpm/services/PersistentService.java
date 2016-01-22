package it.synclab.hrpm.services;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ConnectionFactory;
import it.synclab.hrpm.model.Entity;

public class PersistentService<T extends Entity> {
	private Connection connection;

	public PersistentService(ConnectionCriteria criteria) throws ClassNotFoundException, SQLException {
		connection = ConnectionFactory.getInstance(criteria);
	}

	public void insert(T object) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException, ClassNotFoundException{
		connection.insert(object);
	}

	public void update(T object) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection.update(object);
	}

	public void delete(T object) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection.delete(object);
	}
}
