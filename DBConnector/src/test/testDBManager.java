package test;

import org.junit.Assert;
import org.junit.Test;

import dao.DBManager;

public class testDBManager {

	@Test
	public void testconnection(){
		boolean result = false;
		DBManager dbManager = new dao.DBManager<>("localhost", "dbtest");
		
		try {
			
			dbManager.connect("edu", "1234");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			result = false;
		
		}
		
		Assert.assertEquals(true, result);
		
	}
	
}
