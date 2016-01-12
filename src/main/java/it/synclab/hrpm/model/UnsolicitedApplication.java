package it.synclab.hrpm.model;

public class UnsolicitedApplication implements Channel {

	public String toCSV() {
		return "Unsolicited Application";
	}

	public String getHeader() {
		return null;
	}

}
