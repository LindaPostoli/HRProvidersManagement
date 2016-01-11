package it.synclab.hrpm.core;

public class DBConnection implements Connection {
	
	public void insert(Object obj) {
		System.out.println("DBConnection: insert " + obj);
	}
	
	public void update(Object obj) {
		System.out.println("DBConnection: update " + obj);
	}
	
	public void delete(Object obj) {
		System.out.println("DBConnection: delete " + obj);
	}
	
}
