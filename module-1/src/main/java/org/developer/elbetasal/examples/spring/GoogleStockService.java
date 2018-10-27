package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleStockService {

	private final ThresholdStockService thresholdStockService;

	@Autowired
	public GoogleStockService(ThresholdStockService thresholdStockService) {
		this.thresholdStockService = thresholdStockService;
	}


	public void getGoogleStacks() {
		System.out.println(String.format(" the limit %s" , thresholdStockService.getThreshold()));
		System.out.println("Lamandado a google");
	}

}
