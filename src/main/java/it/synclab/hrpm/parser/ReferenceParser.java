package it.synclab.hrpm.parser;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Reference;

public class ReferenceParser extends ParserManager<Reference> {

	@Override
	public Reference parse(String line) throws KeyNotFoundException {
		
		String[] data = line.split(SEPARATOR);
		if (data[5] == null)
			throw new KeyNotFoundException();

		Reference reference = new Reference(data[5]);

		reference.setName(data[0] == null ? "" : data[0]);
		reference.setSurname(data[1] == null ? "" : data[1]);
		reference.setReferenceCompany(data[2] == null ? "" : data[2]);
		reference.setPhoneNumber(data[3] == null ? "" : data[3]);
		reference.setOpinion(data[4] == null ? "" : data[4]);
				
		return reference;
	}
	
}	
