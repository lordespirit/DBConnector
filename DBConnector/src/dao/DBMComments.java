package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
		
			preparedStatement = getConnected().prepareStatement(strSQL);
			
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
			
		} catch (Exception e) {

			close();
			throw e;
			
		} finally {
			
			try {
				preparedStatement.close();
			} catch (Exception e1) {
				
			}
			
		}
		
		object.setId(lastInsertderId);
		
		return object;
	}

	@Override
	public void update(Comments object) throws Exception {
		
		PreparedStatement preparedStatement = null;
		checkFormatUpdate(object);
		
		try {
			preparedStatement = getConnected().prepareStatement("UPDATE " + getTABLE() +" SET MYUSER = ?, EMAIL = ?, WEBPAGE = ?"
					+ ", SUMMARY = ?, DATUM = ?, COMMENTS = ?  WHERE id= ?"); 
			preparedStatement.setString(1, object.getMyUser());
			preparedStatement.setString(2, object.getEmail());
			preparedStatement.setString(3, object.getWebpage());
			preparedStatement.setString(4, object.getSummary());
			preparedStatement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(6, object.getComments());
			preparedStatement.setInt(7, object.getId());
	        preparedStatement.executeUpdate();
		
		} catch (Exception e) {

			close();
			throw e;
			
		} finally {
			
			try {
				preparedStatement.close();
			} catch (Exception e1) {
				
			}
			
		}	
	}

	@Override
	public Comments select(int id) {

		PreparedStatement preparedStatement = null;
		String strSQL = "SELECT * FROM " + getTABLE() + " WHERE id="+id;
		ArrayList<Comments> list = null;
		Comments comment = null;
		
		try {
		
			preparedStatement =  getConnected().prepareStatement(strSQL);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			
		} catch (Exception e) {
			
			close();
			
		} finally {
			
		}
		
		
		return comment;
		
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

	/**
	 * Condiciones bajo las cuales se puede actualizar un objeto.
	 * @param object
	 */
	private static void checkFormatUpdate(Comments object) {

		if(object.getId()==-1){
			throw new RuntimeException("El objeto que trata de actualizar no tiene una ID válida");
		}
		
	}
	
	private ArrayList<Comments> resultSetToComments(ResultSet resultSet) throws SQLException{
		ArrayList<Comments> listResult = new ArrayList<Comments>();
		
		while(resultSet.next()){
			
			int id = resultSet.getInt("id");
			String myUser = resultSet.getString("MYUSER");
			String email = resultSet.getString("EMAIL");
			String webpage = resultSet.getString("WEBPAGE");
			Date datum = resultSet.getDate("DATUM");
			String summary = resultSet.getString("SUMMARY");
			String comments = resultSet.getString("COMMENTS");
			
			Comments comment = new Comments();
			comment.setId(id);
			comment.setMyUser(myUser);
			comment.setEmail(email);
			comment.setWebpage(webpage);
			comment.setDatum(datum);
			comment.setComments(comments);
			comment.setSummary(summary);
		
			listResult.add(comment);
		}
		
		return listResult;

	}

}
