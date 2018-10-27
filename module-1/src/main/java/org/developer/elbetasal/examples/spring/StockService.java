package org.developer.elbetasal.examples.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	private final GoogleStockService googleStockService;

	private final String message;

	@Autowired
	public StockService(GoogleStockService googleStockService, String message) {
		this.googleStockService = googleStockService;
		this.message = message;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party "+ message);
		googleStockService.getGoogleStacks();
	}

}
