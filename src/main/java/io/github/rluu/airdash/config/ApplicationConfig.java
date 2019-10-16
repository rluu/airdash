package io.github.rluu.airdash.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class ApplicationConfig {

//	@Value("${spring.datasource.url}")
//	String datasourceUrl;
//
//	@Value("${spring.datasource.username}")
//	String datasourceUsername;
//
//	@Value("${spring.datasource.password}")
//	String datasourcePassword;
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl(datasourceUrl);
//		dataSource.setUsername(datasourceUsername);
//		dataSource.setPassword(datasourcePassword);
//		return dataSource;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
//
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("io.github.rluu");
//		factory.setDataSource(dataSource());
//		return factory;
//	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}
}