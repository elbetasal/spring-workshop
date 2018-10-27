package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
