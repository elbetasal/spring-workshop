package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleStockService {

	private ThresholdStockService thresholdStockService;

	@Autowired
	public void setThresholdStockService(ThresholdStockService thresholdStockService) {
		this.thresholdStockService = thresholdStockService;
	}

	public void getGoogleStacks() {
		System.out.println(String.format(" the limit %s" , thresholdStockService.getThreshold()));
		System.out.println("Lamandado a google");
	}

}