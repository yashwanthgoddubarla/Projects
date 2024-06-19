package com.orm.Entity;


import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("yash.app")
@Component
@Data
public class ConfigurationProperty {
	
	private String name;
	private int age;
	private String desg;
	private String dept;
	
	
	
	

}
