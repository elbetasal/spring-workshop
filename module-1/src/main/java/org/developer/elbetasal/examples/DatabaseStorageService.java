package org.developer.elbetasal.examples;

public class DatabaseStorageService implements StorageService {

	public void destroyMethod(){
		System.out.println("destroy method");
	}

	@Override
	public boolean persist(Object toPersist) {
		System.out.println("Base de datos");
		return true;
	}
}
