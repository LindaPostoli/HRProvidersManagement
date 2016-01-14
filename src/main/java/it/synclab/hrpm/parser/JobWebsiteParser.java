package it.synclab.hrpm.parser;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.JobWebsite;


public class JobWebsiteParser extends ParserManager<JobWebsite> {

	@Override
	public JobWebsite parse(String line) throws KeyNotFoundException {
		
		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();

		JobWebsite website = new JobWebsite(data[0]);
		
		website.setName(data[1] == null ? "" : data[1]);
		
		return website;
	}

}
