package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import it.synclab.hrpm.model.Candidate;
import it.synclab.hrpm.model.Rating;

public class CandidateService extends PersistentService<Candidate> {
	
	public CandidateService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Candidate> getByRating(Rating rating){
		Query query= session.getNamedQuery("getByRatingCandidate");
		query.setParameter("rating", rating);
		return (List<Candidate>) query.list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Candidate> getByCity(String city){
		Query query= session.getNamedQuery("getByCityCandidate");
		query.setParameter("city", city);
		return (List<Candidate>) query.list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Rating> getAllRatings(){
		Query query= session.getNamedQuery("getAllRatingsCandidate");
		return (List<Rating>) query.list();
	}
	
	

}
