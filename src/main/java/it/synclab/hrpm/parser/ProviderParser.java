package it.synclab.hrpm.parser;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Provider;

public class ProviderParser extends ParserManager<Provider>{	

	@Override
	public Provider parse(String line) throws KeyNotFoundException {
		
		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();
			
		Provider provider = new Provider(data[0]);
		
		provider.setAddress(data[1] == null ? "" : data[1]);
		provider.setZipCode(data[2] == null ? "" : data[2]);
		provider.setCity(data[3] == null ? "" : data[3]);
		provider.setCountry(data[4] == null ? "" : data[4]);
		provider.setPhoneNumber(data[5] == null ? "" : data[5]);
		provider.seteMail(data[6] == null ? "" : data[6]);
		
		return provider;
	}

}
