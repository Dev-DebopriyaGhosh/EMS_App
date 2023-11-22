package com.management.employeeManagement.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class EMSWebConfig {

	@Bean(name="dataSourceProperties")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSourceProperties applicationDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name="datasource.ems")
	public HikariDataSource applicationDataSource(@Qualifier("dataSourceProperties") DataSourceProperties applicationDataSourceProperties) {
		HikariDataSource dataSource = (HikariDataSource) applicationDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
		dataSource.setMaximumPoolSize(5);
		dataSource.setMaxLifetime(30000);
		dataSource.setConnectionTimeout(60000);
		return dataSource;
		
	}
}
