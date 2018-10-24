package org.developer.elbetasal.examples;

public interface StorageService {
	boolean persist(Object toPersist );

	default void init() {
		System.out.println("Init desde la interfaz " + getClass().getCanonicalName());
	}

	default void destroy(){
		System.out.println("Destrot " + getClass().getCanonicalName());
	}

}
