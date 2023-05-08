package com.myc.spring.webmvc;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class RootConfig {
	
	//Using JNDI data source
	@Bean
	public DataSource jndiDataSource() {
		
		JndiObjectFactoryBean jndiObject=new JndiObjectFactoryBean();
		jndiObject.setJndiName("jdbc/bappa");
		//jndiObject.setResourceRef(true);
		jndiObject.setProxyInterface(javax.sql.DataSource.class);
		
		return (DataSource) jndiObject.getObject();
	}
	
	// Using Pooled Data Source
	@Bean
	public DataSource basicDataSource() {
		BasicDataSource ds= new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/myc");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		
		return ds;
	}
	
	// Using JDBC driver based DataSource
	@Bean(name="jdbcDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource ds =new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/myc");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	} 
	
	//Creating JDBC Template
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource jdbcDataSource) {
		return new JdbcTemplate(jdbcDataSource);
	}

}
