package it.synclab.hrpm.services;

import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.model.Rating;

public class RatingService extends PersistentService<Rating> {
	
	public RatingService(ConnectionCriteria criteria) {
		super(criteria);
	}
	
}
