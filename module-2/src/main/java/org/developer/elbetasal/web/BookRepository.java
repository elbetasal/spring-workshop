package org.developer.elbetasal.web;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRepository {

	public List<Book> findAllBooks(){
		List<Book> books = new ArrayList<>();
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter", "ISBN"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 2", "ISBN 2"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 3", "ISBN 3"));
		books.add(new Book(UUID.randomUUID().toString(), "Harry Potter 4", "ISBN 4"));
		return books;
	}

}
