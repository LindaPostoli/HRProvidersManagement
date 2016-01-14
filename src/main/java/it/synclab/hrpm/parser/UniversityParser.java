package it.synclab.hrpm.parser;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.University;

public class UniversityParser extends ParserManager<University> {

	@Override
	public University parse(String line) throws KeyNotFoundException {

		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();

		University university = new University(data[0]);

		university.setAddress(data[1] == null ? "" : data[1]);
		university.setZipCode(data[2] == null ? "" : data[2]);
		university.setCity(data[3] == null ? "" : data[3]);
		university.setCountry(data[4] == null ? "" : data[4]);
		university.setPhoneNumber(data[5] == null ? "" : data[5]);
		university.seteMail(data[6] == null ? "" : data[6]);
		university.setFieldOfStudy(data[7] == null ? "" : data[7]);
		
		return university;
	}

}	
