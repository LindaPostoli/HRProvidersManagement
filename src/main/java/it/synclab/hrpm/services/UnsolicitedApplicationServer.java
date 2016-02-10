package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import it.synclab.hrpm.model.University;

public class UnsolicitedApplicationServer extends PersistentService<University> {

	public UnsolicitedApplicationServer() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}
	
	public List<University> getByName(String name){
		Query query= session.getNamedQuery("getByNameUniversity");
		query.setParameter("name", name);
		return (List<University>) query.list();
	}
	
	public List<University> getByCity(String city){
		Query query= session.getNamedQuery("getByCityUniversity");
		query.setParameter("city", city);
		return (List<University>) query.list();
	}
	
	
	

}
