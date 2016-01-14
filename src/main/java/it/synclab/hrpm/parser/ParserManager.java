package it.synclab.hrpm.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Entity;

public abstract class ParserManager<T extends Entity> {
	protected static final String SEPARATOR = ";";
	
	public Map<String, T> parser() {
		
		String filename = "";
		Map<String, T> entityMap = new HashMap<String, T>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = br.readLine()) != null) {
				T entity = parse(line);
				entityMap.put(entity.getKey(), entity);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return entityMap;
		
	}
	
	public abstract T parse(String line) throws KeyNotFoundException;
}
