package it.synclab.hrpm.core;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import it.synclab.hrpm.bootstrap.DBManager;
import it.synclab.hrpm.model.Entity;

public class DBConnection implements Connection {

		
	public void insert(Entity obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException, ClassNotFoundException  {
		DBManager dbm = new DBManager();
		dbm.insert(obj);
	}
	
	public void update(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DBManager dbm = new DBManager();
	}

	public void delete(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		DBManager dbm = new DBManager();
	}

	

}
