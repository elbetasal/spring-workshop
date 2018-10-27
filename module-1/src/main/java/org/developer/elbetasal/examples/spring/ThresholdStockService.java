package org.developer.elbetasal.examples.spring;


import java.util.Random;

public class ThresholdStockService {

		public Integer getThreshold(){
			return new Random().nextInt();
		}
}