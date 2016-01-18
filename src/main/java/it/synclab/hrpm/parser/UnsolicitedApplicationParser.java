package it.synclab.hrpm.parser;

import it.synclab.hrpm.model.UnsolicitedApplication;

public class UnsolicitedApplicationParser extends ParserManager<UnsolicitedApplication> {

	@Override
	public UnsolicitedApplication parse(String line) {
		 
		return new UnsolicitedApplication(line);
	}
	
}
