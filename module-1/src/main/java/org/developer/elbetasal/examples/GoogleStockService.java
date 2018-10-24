package org.developer.elbetasal.examples;

public class GoogleStockService {

	private ThresholdStockService stockService;

	public GoogleStockService(ThresholdStockService stockService) {
		this.stockService = stockService;
	}

	public void ggetGoogleStocks() {
		System.out.println(String.format(" the limit %s" , stockService.getThreshold()));
		System.out.println("Lamandado a google");
	}
}
