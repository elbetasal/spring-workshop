package org.developer.elbetasal.examples.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.List;

public class InjectApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(InjectAppConfig.class);
		applicationContext.refresh();


		StockService stockkService = applicationContext.getBean(StockService.class);
		stockkService.getStocks();

		applicationContext.registerShutdownHook();

	}

	@Configuration
	@ComponentScan
	@PropertySource("classpath:application.properties")
	@Import({MessageConfiguration.class , OtherConfig.class})
	static class InjectAppConfig {


	}
	@Configuration
	static class MessageConfiguration {

		@Bean
		public String message() {
			return "Hello ";
		}

		@Bean
		public List<String> strings() {
			List array = new ArrayList();
			array.add("Hello");
			array.add("Hello2");
			array.add("Hello3");
			return array;
		}

		@Bean
		public PropertySourcesPlaceholderConfigurer propertPlaceHolderConfiguer() {

			return new PropertySourcesPlaceholderConfigurer();

		}
	}

	@Configuration
	static class OtherConfig {

		@Bean
		@Primary
		public String message2(){
			return "Hola ";
		}

	}
}

