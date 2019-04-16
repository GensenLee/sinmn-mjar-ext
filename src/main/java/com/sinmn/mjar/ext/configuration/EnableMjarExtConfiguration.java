package com.sinmn.mjar.ext.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
	    "com.sinmn.mjar.ext"
	})
public class EnableMjarExtConfiguration{
  
}
