package dao;

import java.util.ArrayList;

public interface DBConnector <T>{
	
	public void connect(String user, String password);
	
	public T insert (T Object);
	
	public T select (int id);
	
	public ArrayList<T> select(String strSQL);
	
	public void deleteAll();
	
	public void delete(int id);
	
	public void close();

}
