package org.developer.elbetasal.examples.conditional;

import org.springframework.context.annotation.*;

@ComponentScan
@Configuration
public class ConditionalApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ConditionalApp.class);

		applicationContext.getBean(LinuxReader.class).sayHello();
		applicationContext.registerShutdownHook();
	}

}
