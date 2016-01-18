package it.synclab.hrpm.factory;

import it.synclab.hrpm.parser.CandidateParser;
import it.synclab.hrpm.parser.JobWebsiteParser;
import it.synclab.hrpm.parser.ParserManager;
import it.synclab.hrpm.parser.ProviderParser;
import it.synclab.hrpm.parser.RatingParser;
import it.synclab.hrpm.parser.ReferenceParser;
import it.synclab.hrpm.parser.StageParser;
import it.synclab.hrpm.parser.UniversityParser;

public class ParserManagerFactory {

	public static final ParserManager getInstance(String typeParser) {

		switch (typeParser.toLowerCase()) {
		case "candidate":
			return new CandidateParser();

		case "rating":
			return new RatingParser();

		case "jobwebsite":
			return new JobWebsiteParser();

		case "provider":
			return new ProviderParser();

		case "reference":
			return new ReferenceParser();

		case "stage":
			return new StageParser();

		case "university":
			return new UniversityParser();

		}
		return null;
	}

}
