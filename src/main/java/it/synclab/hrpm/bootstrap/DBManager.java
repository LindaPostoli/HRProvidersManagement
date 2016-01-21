package it.synclab.hrpm.bootstrap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.model.Entity;
import it.synclab.hrpm.model.JobWebsite;
import it.synclab.hrpm.model.Rating;

public class DBManager {

	private static ConnectionPool cp;

	public static final void init()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		cp = ConnectionPool.getInstance();
	}

	public void insert(Entity obj) throws SQLException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Connection conn = (Connection) cp.getConnection();

		String query = "INSERT INTO " + obj.getClass().getSimpleName() + " VALUES(";

		Method[] methods = obj.getClass().getMethods();

		List<Field> fields = new ArrayList<Field>();
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (!field.getName().equalsIgnoreCase("HEADER"))
				fields.add(field);
		}

		int k = 0;
		while (k < fields.size() - 1) {
			query += "?,";
			k++;
		}
		query += "?);";

		PreparedStatement pst = conn.prepareStatement(query);

		for (int i = 0; i < fields.size(); i++) {

			String methodName = null;
			if (fields.get(i).getType().getSimpleName().equals("int"))
				methodName = "set" + "Int";
			else if (fields.get(i).getType().getSimpleName().equals("Calendar"))
				// TODO: ricordarsi di convertire la data da Calendar a Date
				// quando lo si passa al preparedStatement
				methodName = "set" + "Date";
			else
				methodName = "set" + fields.get(i).getType().getSimpleName();

			Class<?>[] paramTypes = { int.class, fields.get(i).getType() };
			System.out.println(methodName);

			Method method = pst.getClass().getMethod(methodName, paramTypes);
			method.invoke(pst, i + 1, fields.get(i).get(obj));

		}

		System.out.println(query);
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, SQLException, NoSuchMethodException, SecurityException, ParseException {
		DBManager dbmanager = new DBManager();
		Rating rating = new Rating(1, 5, 6, 6);

		JobWebsite jwb = new JobWebsite("www.indeed.com");
		jwb.setName("Indeed");
		dbmanager.insert(rating);
	}

}