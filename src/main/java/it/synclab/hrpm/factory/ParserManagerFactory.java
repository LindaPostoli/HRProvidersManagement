package it.synclab.hrpm.factory;

import it.synclab.hrpm.parser.*;

public class ParserManagerFactory {

	public static final ParserManager getInstance(String typeParser) {

		if(typeParser.equalsIgnoreCase("candidate")) 
			return new CandidateParser();

		if(typeParser.equalsIgnoreCase("rating")) 
			return new RatingParser();

		if(typeParser.equalsIgnoreCase("provider")) 
			return new ProviderParser();

		if(typeParser.equalsIgnoreCase("reference"))
			return new ReferenceParser();
			
		if(typeParser.equalsIgnoreCase("jobwebsite")) 
			return new JobWebsiteParser();

		if(typeParser.equalsIgnoreCase("stage")) 
			return new StageParser();

		if(typeParser.equalsIgnoreCase("university")) 
			return new UniversityParser();

		if(typeParser.equalsIgnoreCase("unsolicitedapplication")) 
			return new UnsolicitedApplicationParser();

		return null;
	}
}

