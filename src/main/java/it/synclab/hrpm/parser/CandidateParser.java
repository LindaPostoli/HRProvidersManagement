package it.synclab.hrpm.parser;

import java.text.ParseException;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Candidate;

public class CandidateParser extends ParserManager<Candidate> {
	
	@Override
	public Candidate parse(String line) throws KeyNotFoundException {
		
		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();
			
		Candidate candidate = new Candidate(data[0]);
		
		candidate.setName(data[1] == null ? "" : data[1]);
		candidate.setSurname(data[2] == null ? "" : data[2]);
		try {
			candidate.setBirthDate(data[3] == null ? "01/01/1900" : data[3]);
		} catch (ParseException e) {
			System.out.println("BirthDate malformat: " + data[3]);
			e.printStackTrace();
		}
		candidate.setBirthPlace(data[4] == null ? "" : data[4]);
		candidate.setAddress(data[5] == null ? "" : data[5]);
		candidate.setZipCode(data[6] == null ? "" : data[6]);
		candidate.setCity(data[7] == null ? "" : data[7]);
		candidate.setCountry(data[8] == null ? "" : data[8]);
		candidate.setPhoneNumber(data[9] == null ? "" : data[9]);
		candidate.seteMail(data[10] == null ? "" : data[10]);
		return candidate;
	}
	
}
