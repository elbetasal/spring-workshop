package org.developer.elbetasal.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new
				ClassPathXmlApplicationContext("/beans.xml");
		StockService stockkService = applicationContext.getBean(StockService.class);
		stockkService.getStocks();
	}

}

