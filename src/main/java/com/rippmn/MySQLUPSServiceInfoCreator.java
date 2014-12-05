package com.rippmn;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.RelationalServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;
import org.springframework.cloud.service.common.MysqlServiceInfo;

public class MySQLUPSServiceInfoCreator extends RelationalServiceInfoCreator<MysqlServiceInfo>{
	
	
	public MySQLUPSServiceInfoCreator() {
		super(new Tags(), "mysql");
	}
	
	
	@Override
	public boolean accept(Map<String, Object> serviceData) {
		
		boolean accept= false;
		@SuppressWarnings("unchecked")
		Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
		if(credentials != null)
			accept = serviceData.get("label")!= null && serviceData.get("label").equals("user-provided") && credentials.get("ups-type") != null && credentials.get("ups-type").equals("mysql-db"); 
		return accept || super.accept(serviceData);		
	}


	@Override
	public MysqlServiceInfo createServiceInfo(String id, String uri) {
		return new MysqlServiceInfo(id, uri);
	}
	

}
