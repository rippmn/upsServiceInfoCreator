package com.rippmn;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMySQLUPSServiceInfoCreator {

	
	MySQLUPSServiceInfoCreator testCreator;
	HashMap<String, Object> testServiceData;
	HashMap<String, Object> testCredentials;
	
	
	@Before
	public void setup(){
		testCreator = new MySQLUPSServiceInfoCreator();
		testServiceData = new HashMap<String, Object>();
		testCredentials = new HashMap<String, Object>();
	}
	
	//test no credentials
	//test no label
	//test bad label
	//test no ups-type
	//test bad ups-type
	
	
	@Test
	public void testAcceptNoCredentials(){
		assertFalse("no credentials", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptNoLabel(){
		testServiceData.put("credentials",testCredentials);
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptBadLabel(){
		testServiceData.put("credentials",testCredentials);
		testServiceData.put("label", "some-label");
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptNoUpsType(){
		testServiceData.put("credentials",testCredentials);
		testServiceData.put("label", "user-provided");
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptBadUpsType(){
		testServiceData.put("credentials",testCredentials);
		testServiceData.put("label", "user-provided");
		testCredentials.put("ups-type", "some-ups");
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptTrue(){
		testServiceData.put("credentials",testCredentials);
		testServiceData.put("label", "user-provided");
		testCredentials.put("ups-type", "mysql-db");
		assertTrue("test matches", testCreator.accept(testServiceData));
		
	}
	
}
