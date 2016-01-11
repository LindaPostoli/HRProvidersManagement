package it.synclab.hrpm.main;

import it.synclab.hrpm.bootstrap.FileManager;
import it.synclab.hrpm.enumeration.ConnectionCriteria;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.services.CandidateService;

public class HRManagement {
	public static void main(String[] args) throws Exception {
		bootstrap();
	}

	private static void bootstrap() {
		bootstrap(ConnectionCriteria.FILE);
	}

	private static void bootstrap(ConnectionCriteria criteria) {
		if (criteria == ConnectionCriteria.FILE)
			FileManager.init();

		CandidateService cs = new CandidateService(criteria);
		Candidate candidate = new Candidate("Cxxsswwww");
		cs.insert(candidate);
	}

}
