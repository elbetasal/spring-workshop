package org.developer.elbetasal.examples.spel.rules.engine;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("calculator")
public class CalculatorService {

	Double add(HashMap <Object , Object> params){
		Double first = (Double) params.get("first");
		Double second = (Double) params.get("second");
		return first + second;
	}

	Double substract(HashMap<Object , Object> params){
		Double first = (Double) params.get("first");
		Double second = (Double) params.get("second");
		return first - second;

	}
}
