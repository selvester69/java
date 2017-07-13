package com.skywalker.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.skywalker")
public class WebConfiguration {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public DataSource getDataSource() throws NamingException{
		DataSource dataSource = null;
		return dataSource;
	}

}
