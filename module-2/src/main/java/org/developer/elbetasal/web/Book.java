package org.developer.elbetasal.web;

public class Book {

	private final String id;

	private final String name;

	private final String isbn;

	public Book(String id, String name, String isbn) {
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Book{");
		sb.append("id='").append(id).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", isbn='").append(isbn).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
