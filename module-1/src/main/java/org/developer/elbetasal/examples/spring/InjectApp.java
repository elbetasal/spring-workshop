package org.developer.elbetasal.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new
				ClassPathXmlApplicationContext("/beans.xml");
		StockService stockkService = applicationContext.getBean(StockService.class);
		stockkService.getStocks();
	}

	@Configuration
	static class InjectAppConfig{

		//<bean .....>

		@Bean
		public StockService stockService(GoogleStockService stockService) {
			return new StockService(stockService);
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
}

