package test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;
import model.Comments;

public class testDBManager {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testconnection(){
		
		boolean result = true;
		DBManager dbManager = new MockManager();
		
		try {
			
			dbManager.connect("edu", "1234");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			result = false;
		
		}
		
		Assert.assertEquals(true, result);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testDelete(){
			
		DBManager<Comments> dbManager = new MockManager();
		try {
				
			dbManager.connect("edu", "1234");
			dbManager.deleteAll();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public static class MockManager extends DBManager{

		public MockManager() {
			super("localhost", "dbtest", "comments");
		}

		@Override
		public Object insert(Object Object) {
			return null;
		}

		@Override
		public Object update(Object Object) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object select(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList select(String strSQL) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
	

	
