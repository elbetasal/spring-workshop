package org.developer.elbetasal.examples.spel.operators;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
@PropertySource("classpath:spel.properties")
public class SpelApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpelApp.class);
		applicationContext.refresh();

		ArithmeticsService arithmeticService = applicationContext.getBean(ArithmeticsService.class);
		System.out.println(arithmeticService.getAdd());
		System.out.println(arithmeticService.getConcat());
		System.out.println(arithmeticService.getWithBrackets());
		System.out.println(arithmeticService.getDiv());
		System.out.println(arithmeticService.getMod());
		System.out.println(arithmeticService.getPower());
		System.out.println(arithmeticService.getWithProperty());

		applicationContext.registerShutdownHook();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertPlaceHolderConfiguer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
