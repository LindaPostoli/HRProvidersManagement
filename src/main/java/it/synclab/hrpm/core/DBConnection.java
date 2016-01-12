package it.synclab.hrpm.core;

import it.synclab.hrpm.model.Entity;

public class DBConnection implements Connection {

	public void update(Entity obj) {
		System.out.println("DBConnection: update " + obj);
	}

	public void delete(Entity obj) {
		System.out.println("DBConnection: delete " + obj);
	}

	public void insert(Entity obj) {
		System.out.println("DBConnection: insert " + obj);

	}

}
