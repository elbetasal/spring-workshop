package org.developer.elbetasal.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new
				ClassPathXmlApplicationContext("/beans.xml");
		System.out.println("Terminando de cargar el app context");
//		StorageService fileSystem = applicationContext
//						.getBean("databaseStorageService", StorageService.class);

//		fileSystem.persist(new String());


		StorageService fileSystemStorageService = applicationContext
				.getBean("fileSystemStorageService", StorageService.class);

		System.out.println(fileSystemStorageService);

		fileSystemStorageService = applicationContext
				.getBean("fileSystemStorageService", StorageService.class);
		System.out.println(fileSystemStorageService);

		((ClassPathXmlApplicationContext) applicationContext)
				.registerShutdownHook();
	}

}
