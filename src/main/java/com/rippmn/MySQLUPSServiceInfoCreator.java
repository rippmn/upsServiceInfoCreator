package com.rippmn;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.MysqlServiceInfoCreator;

public class MySQLUPSServiceInfoCreator extends MysqlServiceInfoCreator{
	
	
	@Override
	public boolean accept(Map<String, Object> serviceData) {
		
		boolean accept= false;
		@SuppressWarnings("unchecked")
		Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
		if(credentials != null)
			accept = serviceData.get("label")!= null && serviceData.get("label").equals("user-provided") && credentials.get("ups-type") != null && credentials.get("ups-type").equals("mysql-db"); 
		return accept || super.accept(serviceData);		
	}

}
