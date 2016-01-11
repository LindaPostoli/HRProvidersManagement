package it.synclab.hrpm.core;

public class FileConnection implements Connection {
	
	public void insert(Object obj) {
		System.out.println("FileConnection: insert " + obj);
	}
	
	public void update(Object obj) {
		System.out.println("FileConnection: update " + obj);
	}
	
	public void delete(Object obj) {
		System.out.println("FileConnection: delete " + obj);
	}
	
}
