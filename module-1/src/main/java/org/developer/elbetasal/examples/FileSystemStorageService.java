package org.developer.elbetasal.examples;

public class FileSystemStorageService implements StorageService {

	public FileSystemStorageService() {
		System.out.println("Construyendo mi FileSystemt");
	}

	public static FileSystemStorageService createFactory() {
		System.out.println("Calling factory");
		return new FileSystemStorageService();
	}

	@Override
	public boolean persist(Object toPersist) {
		System.out.println("Guardando en disco duro");
		return true;
	}

}