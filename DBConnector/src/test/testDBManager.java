package test;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;

public class testDBManager {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testconnection(){
		
		boolean result = true;
		DBManager dbManager = new dao.DBManager<>("localhost", "dbtest","comments");
		
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
			
			DBManager connector = new DBManager("localhost", "dbtest","comments");
			try {
				
				connector.connect("edu", "1234");
				connector.deleteAll();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connector.close();
			}
		}
	
}
