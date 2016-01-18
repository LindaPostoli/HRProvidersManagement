package it.synclab.hrpm.bootstrap;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.exception.ConnectionPoolAlreadyInstantiatedException;
import it.synclab.hrpm.model.Entity;

public class DBManager {

	private ConnectionPool cp;

	public void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.cp = ConnectionPool.getInstance();
	};

	public void insert(Entity obj) {

		Connection con = (Connection) cp.getConnection();
		String query = "insert into  (name, age) values (?, ?)";
		
		
		

	}

}
