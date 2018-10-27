package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("google")
public class GoogleStockService implements StockExternalService {

	private final ThresholdStockService thresholdStockService;

	@Autowired
	public GoogleStockService(ThresholdStockService thresholdStockService) {
		this.thresholdStockService = thresholdStockService;
	}

	@Override
	public void getStocks() {
		System.out.println(String.format(" the limit %s" , thresholdStockService.getThreshold()));
		System.out.println("Lamandado a google");

	}
}
