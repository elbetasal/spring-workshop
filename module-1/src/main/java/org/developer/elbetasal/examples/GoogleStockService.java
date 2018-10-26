package org.developer.elbetasal.examples;

import org.springframework.beans.factory.annotation.Autowired;

public class GoogleStockService {

	private ThresholdStockService stockService;


	@Autowired
	public GoogleStockService(ThresholdStockService thresholdStockService) {
		this.stockService = thresholdStockService;
	}

	public void getGoogleStacks() {
		System.out.println(String.format(" the limit %s" , stockService.getThreshold()));
		System.out.println("Lamandado a google");
	}
}
