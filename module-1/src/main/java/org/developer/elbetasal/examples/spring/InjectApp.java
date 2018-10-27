package org.developer.elbetasal.examples.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
		public StockService stockService() {
			return new StockService(googleStockService());
		}

		@Bean
		public GoogleStockService googleStockService() {
			return new GoogleStockService(thresholdStockService());
		}

		@Bean
		public ThresholdStockService thresholdStockService(){
			return new ThresholdStockService();
		}

	}
}

