package org.developer.elbetasal.examples.spring;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("fmat")
public class FmatStockService implements StockExternalService {
	@Override
	public void getStocks() {
		System.out.println("FMAT esta llamando");
	}
}
