package it.synclab.hrpm.main;

import org.hibernate.Session;

import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Rating;
import it.synclab.hrpm.services.CandidateService;
import it.synclab.hrpm.services.PersistentService;
import it.synclab.hrpm.services.RatingService;

public class HRManagement {

	public static void main(String[] args) throws Exception, ClassNotFoundException {

		System.out.println("Maven + Hibernate + MySQL");
		
		PersistentService<Candidate> psc= new CandidateService();
		psc.beginTransaction();
		Candidate c1 = new Candidate("c1500@gmail.com");
		psc.save(c1);
				
		PersistentService<Rating> psr= new RatingService();
		Rating r1 = new Rating();
		r1.setGeneral(10000);
		psr.save(r1);
		c1.setRating(r1);
		psc.update(c1);
		
		psc.commitTransaction();
		
	}

}
