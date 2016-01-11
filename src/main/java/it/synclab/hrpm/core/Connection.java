package it.synclab.hrpm.core;

import it.synclab.hrpm.model.Entity;

public interface Connection {
	public void insert(Entity obj);

	public void update(Entity obj);

	public void delete(Entity obj);

}
