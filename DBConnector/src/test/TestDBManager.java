package test;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;

public class TestDBManager {

	
	@SuppressWarnings("rawtypes")
	@Test
	public void testConnection(){
		boolean result = true;
		DBManager dbManager = new MockManager();
		
		try {
			
			dbManager.connect("edu","1234");
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false; 
		}finally {
			dbManager.close();
		}
		
		
		Assert.assertEquals(true,result); 
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testDeleteAall(){
		boolean result = true;
		DBManager dbManager = 
				new MockManager();
		
		try{
			dbManager.connect("edu","1234");
			dbManager.deleteAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			result = false; 
		}finally {
			dbManager.close();
		}
		
		Assert.assertEquals(true,result); 
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static class MockManager extends DBManager{
		public MockManager() {
			super("localhost", "dbtest","comments"); 
	    }

		@Override
		public Object insert(Object object) {
			return null;
		}

		@Override
		public void update(Object object) {
		}

		@Override
		protected Object mapDbToObject(ResultSet resultSet) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

	

	}

		
}