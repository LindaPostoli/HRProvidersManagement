package it.synclab.hrpm.model;

public class UnsolicitedApplication implements Channel {

	private static int id=0;
	public String toCSV() {
		return "Unsolicited Application";
	}

	public UnsolicitedApplication(){
		super();
		id++;
	}
	public String getHeader() {
		return null;
	}
	
	public String getKey() {
		return String.valueOf(id);
	}
	
	
}
