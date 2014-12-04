package com.rippmn;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.MysqlServiceInfoCreator;

public class MySQLUPSServiceInfoCreator extends MysqlServiceInfoCreator{
	
	
	public MySQLUPSServiceInfoCreator() {
		super();
	}
	
	
	@Override
	public boolean accept(Map<String, Object> serviceData) {
		
		boolean accept = serviceData.get("label")!= null && serviceData.get("label").equals("user-provided") && serviceData.get("name") != null && ((String)serviceData.get("name")).toLowerCase().contains("mysql"); 
		return accept || super.accept(serviceData);		
	}



	

}
