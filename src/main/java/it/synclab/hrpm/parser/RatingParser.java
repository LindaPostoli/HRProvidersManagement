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
			rating.setProfessionality(data[1] == null ? "" : data[1]);
			rating.setPersonality(data[2] == null ? "" : data[2]);
			rating.setGeneral(data[3] == null ? "" : data[3]);
			rating.setNote(data[4] == null ? "" : data[4]);

		} catch (NumberFormatException e) {
			System.out.println("Not valid input");
			e.printStackTrace();
		}
		return rating;
	}

}
