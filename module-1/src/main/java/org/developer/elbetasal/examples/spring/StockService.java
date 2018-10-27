package org.developer.elbetasal.examples.spring;


public class StockService {

	private final GoogleStockService googleStockService;

	private final String message;

	public StockService(GoogleStockService googleStockService, String message) {
		this.googleStockService = googleStockService;
		this.message = message;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party "+ message);
		googleStockService.getGoogleStacks();
	}

}
