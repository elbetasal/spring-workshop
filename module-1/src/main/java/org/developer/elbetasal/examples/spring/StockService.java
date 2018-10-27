package org.developer.elbetasal.examples.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	private final StockExternalService stockExternalService;

	private final String message;

	@Autowired
	public StockService(StockExternalService stockExternalService, String message) {
		this.stockExternalService = stockExternalService;
		this.message = message;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party "+ message);
		stockExternalService.getStocks();
	}

}
