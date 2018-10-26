package org.developer.elbetasal.examples.spel.location;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class DistanceApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(DistanceApp.class);
		applicationContext.refresh();
		applicationContext.getBean(DistanceService.class).calculateDistance(10d , 12d);
		applicationContext.registerShutdownHook();
	}
}
