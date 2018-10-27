package org.developer.elbetasal.examples;

import org.developer.elbetasal.examples.spring.GoogleStockService;
import org.developer.elbetasal.examples.spring.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {

	@Mock
	private GoogleStockService googleStockService;

	@InjectMocks
	private StockService stockService;

	@Test
	public void getStocks() {
		stockService.getStocks();
	}
}