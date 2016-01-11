package it.synclab.hrpm.services;

import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.model.Candidate;

public class CandidateService extends PersistentService<Candidate> {
	
	public CandidateService(ConnectionCriteria criteria) {
		super(criteria);
	}
	
}
