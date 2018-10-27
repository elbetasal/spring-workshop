package org.developer.elbetasal.examples.spring;

import org.springframework.context.annotation.*;

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
	@Import({MessageConfiguration.class , OtherConfig.class})
	static class InjectAppConfig{

		//<bean .....>

		@Bean
		public StockService stockService(GoogleStockService stockService,
		                                 String message) {
			return new StockService(stockService, message);
		}

		@Bean
		public GoogleStockService googleStockService() {
			return new GoogleStockService(thresholdStockService());
		}

		@Bean
		@Primary
		public GoogleStockService googleStockService2() {
			return new GoogleStockService(thresholdStockService2());
		}

		@Bean
		public ThresholdStockService thresholdStockService(){
			return new ThresholdStockService(Integer.MIN_VALUE);
		}

		@Bean
		public ThresholdStockService thresholdStockService2(){
			return new ThresholdStockService(Integer.MAX_VALUE);
		}
	}

	@Configuration
	static class MessageConfiguration {

		@Bean
		public String message() {
			return "Hello ";
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

