package be.plantenshop.dao;

import java.util.Collections;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@ComponentScan(basePackageClasses = CreateDAOBeans.class)
@PropertySource("classpath:/database.properties")
@EnableJpaRepositories(basePackageClasses= CreateDAOBeans.class)
public class CreateDAOBeans {

	@Autowired
	private Environment environment;

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Bean(destroyMethod = "close")
	ComboPooledDataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(environment
					.getProperty("database.driverClass"));
			dataSource.setJdbcUrl(environment.getProperty("database.jdbcUrl"));
			dataSource.setUser(environment.getProperty("database.user"));
			dataSource
					.setPassword(environment.getProperty("database.password"));
			dataSource.setMaxIdleTime(environment.getProperty(
					"database.maxIdleTime", Integer.class));
		} catch (Exception ex) {
			logger.severe("invalid C3P0 properties:" + ex.getMessage());
		}
		return dataSource;
	}
	
	/*@Bean
	DataSource dataSource() {
		return new JndiDataSourceLookup().getDataSource("jdbc/plantenshop"); 
	}*/
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = 
				new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("be.plantenshop.entities",
				"be.plantenshop.valueobjects");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(environment.getProperty("database.showSql",
				Boolean.class));
		entityManagerFactoryBean.setJpaPropertyMap(Collections.singletonMap("hibernate.format_sql", true));
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		return entityManagerFactoryBean;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}
}
