package org.developer.elbetasal.examples.transactions.declarative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class BookApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BookAppConfiguration.class);
		applicationContext.refresh();

		BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
		bookRepository.createBook(Book
				.builder()
				.name("Test")
				.isbn("ISBN")
				.build());

		bookRepository
				.findAllBooks()
				.stream()
				.forEach(System.out::println);
		applicationContext.registerShutdownHook();
	}

	@Configuration
	@PropertySource("classpath:jdbc.properties")
	@ComponentScan
	static class BookAppConfiguration {

		@Autowired
		private Environment environment;

		@Bean
		public DataSource dataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setPassword(environment.getProperty("jdbc.password"));
			dataSource.setUsername(environment.getProperty("jdbc.user"));
			dataSource.setUrl(environment.getProperty("jdbc.url"));
			dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
			return dataSource;
		}

		@Bean
		public DataSourceTransactionManager dataSourceTransactionManager() {
			return new DataSourceTransactionManager(dataSource());
		}


		@Bean
		public static PropertySourcesPlaceholderConfigurer propertPlaceHolderConfiguer() {
			return new PropertySourcesPlaceholderConfigurer();
		}
	}
}
