package com.rippmn;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.MysqlServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.RelationalServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;
import org.springframework.cloud.service.common.MysqlServiceInfo;

public class MySQLUPSServiceInfoCreator extends MysqlServiceInfoCreator{
	
	
	public MySQLUPSServiceInfoCreator() {
		super();
	}
	
	
	@Override
	public boolean accept(Map<String, Object> serviceData) {
		
		boolean accept = serviceData.get("label")!= null && serviceData.get("label").equals("user-provided") && serviceData.get("name") != null && ((String)serviceData.get("name")).contains("mysql"); 
		return accept || super.accept(serviceData);		
	}



	

}
