package it.synclab.hrpm.services;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.factory.ConnectionFactory;
import it.synclab.hrpm.model.Entity;

public class PersistentService {
	private Connection connection;

	public PersistentService(ConnectionCriteria criteria) {
		connection = ConnectionFactory.getInstance(criteria);
	}

	public void insert(Entity object) {
		connection.insert(object);
	}

	public void update(Entity object) {
		connection.update(object);
	}

	public void delete(Entity object) {
		connection.delete(object);
	}
}
