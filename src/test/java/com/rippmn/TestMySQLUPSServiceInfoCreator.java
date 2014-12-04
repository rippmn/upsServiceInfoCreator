package com.rippmn;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMySQLUPSServiceInfoCreator {

	
	MySQLUPSServiceInfoCreator testCreator;
	HashMap<String, Object> testServiceData;
	
	
	@Before
	public void setup(){
		testCreator = new MySQLUPSServiceInfoCreator();
		testServiceData = new HashMap<String, Object>();
	}
	
	
	@Test
	public void testAcceptNoCredentials(){
		assertFalse("no credentials", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptNoLabel(){
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testAcceptBadLabel(){
		testServiceData.put("label", "some-label");
		assertFalse("no label", testCreator.accept(testServiceData));	
	}
	
	@Test
	public void testNoName(){
		testServiceData.put("label", "user-provided");
		assertFalse("test matches", testCreator.accept(testServiceData));
	}
	
	@Test
	public void testBadName(){
		testServiceData.put("label", "user-provided");
		testServiceData.put("name", "someName");
		assertFalse("test matches", testCreator.accept(testServiceData));
	}
	
	@Test
	public void testAcceptTrue(){
		testServiceData.put("label", "user-provided");
		testServiceData.put("name", "someName-mysql-included");
		assertTrue("test matches", testCreator.accept(testServiceData));
		
	}
	
}
