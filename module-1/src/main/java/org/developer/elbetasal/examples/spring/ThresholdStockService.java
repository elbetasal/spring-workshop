package org.developer.elbetasal.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ThresholdStockService {

	private final int threadshold;

	@Autowired
	public ThresholdStockService(@Value("${app.limit:100}") int threadshold) {
		this.threadshold = threadshold;
	}

	public Integer getThreshold(){
			return threadshold;
		}
}