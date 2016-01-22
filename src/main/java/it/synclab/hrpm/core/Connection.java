package it.synclab.hrpm.core;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import it.synclab.hrpm.model.Entity;

public interface Connection {
	
	public void insert(Entity obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException, ClassNotFoundException;

	public void update(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public void delete(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

}
