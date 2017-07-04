package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager<T> implements DBAccess<T> {
	
	private String dbName;
	private String dbUri;
	private Connection connect;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	public DBManager(String dbHost, String dbName){
		this.dbName = dbName;
		this.dbUri = "jdbc:mysql://host/dbName?user=edu&password=1234";
		dbUri = dbUri.replace("host", dbHost).replace("dbName", dbName);
	}

	@Override
	public void connect(String user, String password) throws SQLException, ClassNotFoundException {
		
		try {
			
			//CARGAR DRIVER MYSQL
			Class.forName("com.mysql.jdbc.Driver");
			// jdbc:mysql://ip // database
			connect = DriverManager.getConnection(dbUri);
			// Statement allow to issue SQL queries to the database
			statement = connect.createStatement();
			
		} catch (Exception e) {
			
			close();
			throw e;
			
		}
				
	}

	@Override
	public T insert(T Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T> select(String strSQL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
