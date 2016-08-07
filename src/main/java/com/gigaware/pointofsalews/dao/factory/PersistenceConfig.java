package com.gigaware.pointofsalews.dao.factory;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan( { "com.gigaware" } )
public class PersistenceConfig {
	
	@Value( "${jdbc.mysql.driverClassName}" )
	private String jdbcMysqlDriverClassName;
	
	@Value( "${jdbc.mysql.url}")
	private String jdbcMysqlUrl;
	
	@Value( "${jdbc.mysql.username}")
	private String jdbcMysqlUsername;
	
	@Value( "${jdbc.mysql.password}")
	private String jdbcMysqlPassword;
	
	@Value( "${jdbc.appengine.driverClassName}" )
	private String jdbcAppengineDriverClassName;
	
	@Value( "${jdbc.appengine.url}")
	private String jdbcAppengineUrl;
	
	@Value( "${hibernate.dialect}" )
	private String hibernateDialect;
	
	@Value( "${hibernate.show_sql}" )
	private String hibernateShowSql;
	
	@Value( "${hibernate.hbm2ddl.auto}" )
	private String hibernateHbm2ddlAuto;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource( restDataSource() );
		sessionFactory.setPackagesToScan( "com.gigaware" );
		sessionFactory.setHibernateProperties( hibernateProperties() );
		return sessionFactory;
	}
	
	@Bean
	public DataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName( jdbcMysqlDriverClassName );
		dataSource.setUrl( jdbcMysqlUrl );
		dataSource.setUsername( jdbcMysqlUsername );
		dataSource.setPassword( jdbcMysqlPassword );
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager( SessionFactory sessionFactory ) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory( sessionFactory );
		return txManager;
	}
	
	@Bean
	PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto );
		        setProperty("hibernate.dialect", hibernateDialect );
		        setProperty("hibernate.globally_quoted_identifiers", hibernateShowSql );
		    }
		};
	}
}
