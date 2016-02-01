package it.synclab.hrpm.services;

import java.sql.SQLException;

import it.synclab.hrpm.model.Rating;

public class RatingService extends PersistentService<Rating> {

	public RatingService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}

}
