package org.developer.elbetasal.examples;

public class StorageServiceLocator {

	private static DatabaseStorageService databaseStorageService = new DatabaseStorageService();
	;

	private static FileSystemStorageService fileSystemStorageService = new FileSystemStorageService();

	public StorageService createDatabase() {
		return databaseStorageService;
	}

	public StorageService createFileSystem() {
		return fileSystemStorageService;
	}

}