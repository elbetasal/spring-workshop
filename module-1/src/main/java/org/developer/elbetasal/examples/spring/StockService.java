package org.developer.elbetasal.examples.spring;


public class StockService {

	private final GoogleStockService googleStockService;

	public StockService(GoogleStockService googleStockService) {
		this.googleStockService = googleStockService;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party");
		googleStockService.getGoogleStacks();;
	}

}
