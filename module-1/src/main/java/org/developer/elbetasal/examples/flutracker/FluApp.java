package org.developer.elbetasal.examples.flutracker;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FluApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();


		applicationContext.getBean(FluTrackService.class)
				.getAllPatientsWithHeadache()
				.stream().forEach(System.out::println);

		applicationContext.registerShutdownHook();
	}
}
