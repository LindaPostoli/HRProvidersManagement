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

import com.mysql.jdbc.JDBC42PreparedStatement;

import it.synclab.hrpm.connectionPool.ConnectionPool;
import it.synclab.hrpm.exception.FullConnectionPoolException;
import it.synclab.hrpm.model.Entity;
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
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, FullConnectionPoolException {

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
			Method method = pst.getClass().getMethod(methodName, paramTypes);

			fields.get(i).setAccessible(true);
			method.invoke(pst, i + 1, fields.get(i).get(obj));

		}

		pst.executeUpdate();
		cp.releaseConnection(conn);

	}

	public void update(Entity obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException, FullConnectionPoolException {

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

			Method method = pst.getClass().getMethod(methodName, paramTypes);

			fields.get(i).setAccessible(true);
			method.invoke(pst, i + 1, fields.get(i).get(obj));

		}

		pst.executeUpdate();
		cp.releaseConnection(conn);

	}

	public void delete(Entity obj) throws SQLException, FullConnectionPoolException {

		Connection conn = (Connection) cp.getConnection();
		String query = "DELETE FROM " + obj.getClass().getSimpleName() + " WHERE " + obj.getKeyName() + " = "
				+ obj.getKey() + ";";

		PreparedStatement pst = conn.prepareStatement(query);
		pst.executeUpdate();
		cp.releaseConnection(conn);

	}

}