package it.synclab.hrpm.core;

import it.synclab.hrpm.bootstrap.FileManager;
import it.synclab.hrpm.model.Entity;

public class FileConnection implements Connection {

	public void insert(Entity obj) {

		FileManager fm = new FileManager();
		fm.insert(obj);
	}

	public void update(Entity obj) {
		FileManager fm = new FileManager();
	}

	public void delete(Entity obj) {
		FileManager fm = new FileManager();
	}

}
