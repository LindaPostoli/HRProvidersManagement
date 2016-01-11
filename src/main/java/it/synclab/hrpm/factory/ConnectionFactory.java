package it.synclab.hrpm.factory;

import it.synclab.hrpm.core.Connection;
import it.synclab.hrpm.core.DBConnection;
import it.synclab.hrpm.core.FileConnection;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.exception.ConnectionNotFoundException;

public class ConnectionFactory {
	
	public static final Connection getInstance(ConnectionCriteria criteria) {
		
		switch (criteria) {
			case FILE:
				return new FileConnection();
			case DB:
				return new DBConnection();
		}
		
		throw new ConnectionNotFoundException(criteria.name() + " not yet implemented!");
	}
}
