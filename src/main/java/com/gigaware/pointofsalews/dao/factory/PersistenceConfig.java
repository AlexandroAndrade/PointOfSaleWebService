package com.gigaware.pointofsalews.dao.factory;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
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
	
	@Value("#{posProperties}")
	private Properties posProperties;
	
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
		
		if(! StringUtils.isEmpty( System.getProperty( "OPENSHIFT_APP_UUID" ) ) ) {
			
			System.out.println( "Creating OpenShift Red Hat MySQL DB Connection" );
			return createDataSource( 
					posProperties.get( "jdbc.mysql.openshift.driverClassName" ).toString(), 
					posProperties.get( "jdbc.mysql.openshift.url" ).toString(), 
					posProperties.get( "jdbc.mysql.openshift.username" ).toString(), 
					posProperties.get( "jdbc.mysql.openshift.password" ).toString() );
		
		} 
//		else if ( ! StringUtils.isEmpty( System.getProperty( "com.google.appengine.runtime.version" ) ) ) {
			
//			System.out.println( "Creating Google App Engine MySQL DB Connection" );
//			return createDataSource( 
//					posProperties.get( "jdbc.mysql.appengine.driverClassName" ).toString(), 
//					posProperties.get( "jdbc.mysql.appengine.url" ).toString(), 
//					posProperties.get( "jdbc.mysql.appengine.username" ).toString(), 
//					posProperties.get( "jdbc.mysql.appengine.password" ).toString() );
			
//	} else {
		else {

			System.out.println( "Creating Localhost MySQL DB Connection" );
			return createDataSource( 
					posProperties.get( "jdbc.mysql.localhost.driverClassName" ).toString(), 
					posProperties.get( "jdbc.mysql.localhost.url" ).toString(), 
					posProperties.get( "jdbc.mysql.localhost.username" ).toString(), 
					posProperties.get( "jdbc.mysql.localhost.password" ).toString() );

		} 
		
	}
	
	private BasicDataSource createDataSource( String driverClassName, String url, String username, String password ){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName( driverClassName );
		dataSource.setUrl( url );
		dataSource.setUsername( username );
		dataSource.setPassword( password );
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
				setProperty("hibernate.hbm2ddl.auto", posProperties.get( "hibernate.hbm2ddl.auto" ).toString() );
		        setProperty("hibernate.dialect", posProperties.get( "hibernate.dialect" ).toString() );
		        setProperty("hibernate.globally_quoted_identifiers", posProperties.get( "hibernate.show_sql" ).toString() );
		    }
		};
	}
}
