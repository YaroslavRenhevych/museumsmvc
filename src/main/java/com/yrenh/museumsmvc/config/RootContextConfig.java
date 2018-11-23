package com.yrenh.museumsmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.yrenh.museumsmvc.dao", "com.yrenh.museumsmvc.service" })
@EnableTransactionManagement
public class RootContextConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.yrenh.museumsmvc.entity");
		
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(adapter);
		
		factory.setJpaProperties(additionalProperties());
		
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		return transactionManager;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("dbc:mysql://localhost:3306/museumdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "PersistenceExceptionTranslationPostProcessor");
		return properties;
	}
}