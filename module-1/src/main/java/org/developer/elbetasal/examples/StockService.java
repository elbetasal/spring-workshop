package org.developer.elbetasal.examples;

import org.springframework.beans.factory.annotation.Autowired;

public class StockService {

	private final GoogleStockService googleStockService;

	@Autowired
	public StockService(GoogleStockService googleStockService) {
		this.googleStockService = googleStockService;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party");
		googleStockService.getGoogleStacks();;
	}

}
