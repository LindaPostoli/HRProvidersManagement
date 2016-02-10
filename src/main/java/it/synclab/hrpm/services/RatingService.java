package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;

import it.synclab.hrpm.model.Rating;

public class RatingService extends PersistentService<Rating> {

	public RatingService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}
	
	public List<Rating> getByGeneral(int general){
		Query query= session.getNamedQuery("getByGeneralRating");
		query.setParameter("general", general);
		return (List<Rating>) query.list();
	}
	
	

}
