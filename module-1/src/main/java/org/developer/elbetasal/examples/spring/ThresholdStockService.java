package org.developer.elbetasal.examples.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ThresholdStockService {

		public Integer getThreshold(){
			return new Random().nextInt();
		}
}