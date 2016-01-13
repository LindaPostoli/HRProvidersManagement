package it.synclab.hrpm.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import it.synclab.hrpm.model.Entity;

public abstract class ParserManager<T extends Entity> {
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	public abstract T parse(String line);
}
