package test;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import dao.DBMComments;
import model.Comments;

public class TestDBMComments {

	@Test
	public void testInsert(){

		boolean result = true;
		DBMComments dbManager = new DBMComments("localhost","dbtest","comments");
		
		Comments comments1 = new Comments();
		
		comments1.setMyUser("Eduard");
		comments1.setEmail("Edu@gmail.com");
		comments1.setWebpage("www.mypage.edu.com");
		comments1.setSummary("Sumario de Edu");
		comments1.setComments("Comentarios de Edu");
		comments1.setDatum(new Date(System.currentTimeMillis()));
		
		
		try {
			dbManager.connect("edu", "1234");
			dbManager.insert(comments1);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			dbManager.close();
		} finally {
			dbManager.close();
		}
		
		Assert.assertEquals(true, result);
		Assert.assertEquals(true, comments1.getId()!=-1);
	
	}
	
	@Test
	public void testUpdate(){
		
		boolean result = true;
		DBMComments dbManager = new DBMComments("localhost","dbtest","comments");
		
		Comments comments1_1 = new Comments();
		
		comments1_1.setMyUser("Valles");
		comments1_1.setEmail("Edu@movi.com");
		comments1_1.setWebpage("www.eduaaa.com");
		comments1_1.setSummary("Sumario de Edu 2");
		comments1_1.setComments("Comentarios de Edu 2");
		comments1_1.setId(1);
		comments1_1.setDatum(new Date(System.currentTimeMillis()));
		
		
		try {
			dbManager.connect("edu", "1234");
			dbManager.update(comments1_1);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
			dbManager.close();
		} finally {
			dbManager.close();
		}
		
		Assert.assertEquals(true, result);
		Assert.assertEquals(true, comments1_1.getId()!=-1);
		
	}
	
}
