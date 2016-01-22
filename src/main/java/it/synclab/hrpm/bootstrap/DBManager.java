package it.synclab.hrpm.bootstrap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public DBManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		cp = ConnectionPool.getInstance();
	}

	public static final void init()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

	}

	public void insert(Entity obj) throws SQLException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Connection conn = (Connection) cp.getConnection();

		String query = "INSERT INTO " + obj.getClass().getSimpleName() + " VALUES(";

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

			Method method = pst.getClass().getDeclaredMethod(methodName, paramTypes);

			fields.get(i).setAccessible(true);
			method.invoke(pst, i + 1, fields.get(i).get(obj));

		}

		pst.executeUpdate();

	}

	public void update(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

		Connection conn = (Connection) cp.getConnection();
		String query = "UPDATE " + obj.getClass().getSimpleName() + " SET ";

		List<Field> fields = new ArrayList<Field>();
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (!field.getName().equalsIgnoreCase("HEADER"))
				fields.add(field);
		}

		int k = 0;
		while (k < fields.size() - 1) {
			query += fields.get(k).getName() + " = ?,";
			k++;
		}
		query += fields.get(fields.size() - 1).getName() + " = ? ";

		query += " WHERE " + obj.getKeyName() + " = " + obj.getKey() + ";";
		
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

			Method method = pst.getClass().getDeclaredMethod(methodName, paramTypes);

			fields.get(i).setAccessible(true);
			method.invoke(pst, i + 1, fields.get(i).get(obj));

		}
		
		pst.executeUpdate();
		
		
	}
	
	
	

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, SQLException, NoSuchMethodException, SecurityException, ParseException,
			InstantiationException, ClassNotFoundException, NoSuchFieldException {

		DBManager dbm = new DBManager();
		Rating rating = new Rating(31, 2, 3, 5);
		dbm.insert(rating);
		rating.setGeneral(10);
		dbm.update(rating);

	}

}