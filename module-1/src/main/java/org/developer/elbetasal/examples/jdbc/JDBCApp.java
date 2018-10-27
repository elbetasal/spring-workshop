package org.developer.elbetasal.examples.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class JDBCApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(JDBCApp.class , DatabaseConfiguration.class);
		Book book = new Book();
		book.setId(1l);
		book.setIsbn("IISIS");
		book.setName("name");
		BookRepository repository = applicationContext.getBean(BookRepository.class);
//		repository.addBook("FMAT" , "IBN1000");
//		repository.deleteBookById(7L);
		repository.updateBookNameById("Libro" , 6L);
		repository
				.findBooks()
				.stream()
				.forEach(System.out::println);


		applicationContext.registerShutdownHook();
	}

	@Configuration
	static class DatabaseConfiguration{

		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring-workshop");
			driverManagerDataSource.setUsername("mysql");
			driverManagerDataSource.setPassword("mysqlpassword");
			return driverManagerDataSource;
		}


	}


}
