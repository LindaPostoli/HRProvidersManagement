package it.synclab.hrpm.parser;

import java.text.ParseException;
import it.synclab.hrpm.exception.KeyNotFoundException;
import it.synclab.hrpm.model.Stage;

public class StageParser extends ParserManager<Stage> {

	@Override
	public Stage parse(String line) throws KeyNotFoundException { 

		String[] data = line.split(SEPARATOR);
		if (data[0] == null)
			throw new KeyNotFoundException();

		Stage stage = new Stage(data[0]);
		
		stage.setTitle(data[1] == null ? "" : data[1]);
		stage.setTutor(data[2] == null ? "" : data[2]);
		try {
			stage.setFromDate(data[3] == null ? "01/01/1900" : data[3]);
			stage.setToDate(data[4] == null ? "01/01/1900" : data[4]);
		} catch (ParseException e) {
			System.out.println("BirthDate malformat");
			e.printStackTrace();
		}
		return stage;
	}

}
