package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Comments;

public abstract class DBManager<T> implements DBAccess<T> {
	
	private String dbName;
	private String dbUri;
	private Connection connect;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private final String TABLE;
	
	public DBManager(String dbHost, String dbName, String dbTable){
		this.TABLE = dbTable;
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
			
		} catch (Exception e) {
			
			close();
			throw e;
			
		}
				
	}

	@Override
	public abstract T insert(T Object) throws Exception;

	@Override
	public abstract T update(T Object);

	@Override
	public abstract T select(int id);

	@Override
	public abstract ArrayList<T> select(String strSQL);

	@Override
	public void deleteAll() throws SQLException{
		
		try {
		
			preparedStatement = connect.prepareStatement("TRUNCATE "+TABLE);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			close();
			e.printStackTrace();
			throw e;
			
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {

		try {
			
			if (resultSet !=null)
				resultSet.close(); resultSet = null;
			if (preparedStatement != null)
				preparedStatement.close(); preparedStatement = null;
			if (connect != null)
				connect.close(); connect = null;
			
		} catch (Exception e) {
			
		}
		
	}
	
	/**
	 * GETTERS AND SETTERS
	 */

	public String getDbName() {
		return dbName;
	}

	public String getTABLE() {
		return TABLE;
	}
	
	protected Connection getConnected(){
		return connect;
	}
	

}
