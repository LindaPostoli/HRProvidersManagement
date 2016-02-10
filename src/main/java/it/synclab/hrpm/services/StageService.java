package it.synclab.hrpm.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import it.synclab.hrpm.model.Stage;

public class StageService extends PersistentService<Stage> {

	public StageService() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		super();
	}
	
	public List<Stage> getByTutor(String tutor){
		Query query= session.getNamedQuery("getByTutorStage");
		query.setParameter("tutor", tutor);
		return (List<Stage>) query.list();
	}
	
	

}
