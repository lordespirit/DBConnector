package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Comments;

public class DBMComments extends DBManager<Comments>{

	public DBMComments(String dbHost, String dbName, String dbTable) {
		super("localhost", "dbtest", "comments");
	}

	@Override
	public Comments insert(Comments object) throws Exception {
		
		int lastInsertderId = -1;
		String strSQL = "INSERT INTO " + getTABLE() + " VALUES (default,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		
		try {
		
			preparedStatement = getConnected().prepareStatement(strSQL,Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, object.getMyUser());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getWebpage());
			preparedStatement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(5, object.getSummary());
			preparedStatement.setString(6, object.getComments());
			
			// Ejecutamos y guardamos la key de resultado en rs (Objeto ResultSet)
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			
			if(rs.next())
				lastInsertderId = rs.getInt(1);
			if(preparedStatement == null)
				preparedStatement.close();
			
		} catch (Exception e) {

			close();
			throw e;
			
		} finally {
			
		}
		
		object.setId(lastInsertderId);
		
		return object;
	}

	@Override
	public Comments update(Comments Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comments> select(String strSQL) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void close(){
		super.close();
	}

}
