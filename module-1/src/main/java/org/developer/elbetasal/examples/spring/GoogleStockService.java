package org.developer.elbetasal.examples.spring;

public class GoogleStockService {

	private final ThresholdStockService thresholdStockService;

	public GoogleStockService(ThresholdStockService thresholdStockService) {
		this.thresholdStockService = thresholdStockService;
	}


	public void getGoogleStacks() {
		System.out.println(String.format(" the limit %s" , thresholdStockService.getThreshold()));
		System.out.println("Lamandado a google");
	}

}
