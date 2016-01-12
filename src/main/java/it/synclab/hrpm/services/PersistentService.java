package it.synclab.hrpm.services;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ConnectionFactory;
import it.synclab.hrpm.model.Entity;

public class PersistentService<T extends Entity> {
	private Connection connection;

	public PersistentService(ConnectionCriteria criteria) {
		connection = ConnectionFactory.getInstance(criteria);
	}

	public void insert(T object) {
		connection.insert(object);
	}

	public void update(T object) {
		connection.update(object);
	}

	public void delete(T object) {
		connection.delete(object);
	}
}
