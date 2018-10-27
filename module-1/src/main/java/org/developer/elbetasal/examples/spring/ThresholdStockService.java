package org.developer.elbetasal.examples.spring;

public class ThresholdStockService {
		private final int threadshold;

	public ThresholdStockService(int threadshold) {
		this.threadshold = threadshold;
	}

	public Integer getThreshold(){
			return threadshold;
		}
}