package it.synclab.hrpm.parser;

import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Rating;

public class RatingParser extends ParserManager<Rating> {

	public Rating parse(String line) throws KeyNotFoundException {

		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();

		Rating rating = new Rating(data[0]);

		try {
			rating.setProfessional(data[1] == null ? "" : data[1]);
			rating.setPersonality(data[2] == null ? "" : data[2]);
			rating.setMark(data[3] == null ? "" : data[3]);

		} catch (NumberFormatException e) {
			System.out.println("Not valid input");
			e.printStackTrace();
		}
		return rating;
	}

}
