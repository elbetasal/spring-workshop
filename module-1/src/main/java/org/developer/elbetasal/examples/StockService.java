package org.developer.elbetasal.examples;

public class StockService {

	private final GoogleStockService googleStockService;

	private final String message;

	public StockService(GoogleStockService googleStockService, String message) {
		this.googleStockService = googleStockService;
		this.message = message;
	}


	public void getStocks() {
		System.out.println("Getting stocks from third party  "
				+ this.message );
		googleStockService.ggetGoogleStocks();;
	}

}
