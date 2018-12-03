package com.yrenh.museumsmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
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
	private static final String ENTITY_PACKAGE_NAME = "com.yrenh.museumsmvc.entity";
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/museumdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String HIBERNATE_AUTO_PROPERTY_NAME = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_AUTO_PROPERTY_VALUE = "validate";
	private static final String HIBERNATE_SHOW_SQL_PROPERTY_NAME = "hibernate.show_sql";
	private static final String HIBERNATE_SHOW_SQL_PROPERTY_VALUE = "true";
	private static final String HIBERNATE_DIALECT_PROPERTY_NAME = "hibernate.dialect";
	private static final String HIBERNATE_DIALECT_PROPERTY_VALUE = "org.hibernate.dialect.MySQL5Dialect";

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired final DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(ENTITY_PACKAGE_NAME);

		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(adapter);

		factory.setJpaProperties(additionalProperties());

		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}

	@Bean
	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(HIBERNATE_AUTO_PROPERTY_NAME, HIBERNATE_AUTO_PROPERTY_VALUE);
		properties.setProperty(HIBERNATE_SHOW_SQL_PROPERTY_NAME, HIBERNATE_SHOW_SQL_PROPERTY_VALUE);
		properties.setProperty(HIBERNATE_DIALECT_PROPERTY_NAME, HIBERNATE_DIALECT_PROPERTY_VALUE);
		return properties;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
