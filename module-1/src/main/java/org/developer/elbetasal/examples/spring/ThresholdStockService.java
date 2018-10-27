package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThresholdStockService {
	private final int threadshold;

	@Autowired
	public ThresholdStockService(int threadshold) {
		this.threadshold = threadshold;
	}

	public Integer getThreshold(){
			return threadshold;
		}
}