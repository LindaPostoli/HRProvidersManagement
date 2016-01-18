package it.synclab.hrpm.core;

import it.synclab.hrpm.bootstrap.DBManager;
import it.synclab.hrpm.model.Entity;

public class DBConnection implements Connection {

		
	public void insert(Entity obj) {
		DBManager dbm = new DBManager();
		dbm.insert(obj);
	}
	
	public void update(Entity obj) {
		DBManager dbm = new DBManager();
	}

	public void delete(Entity obj) {
		DBManager dbm = new DBManager();
	}

	

}
