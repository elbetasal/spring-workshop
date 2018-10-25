package org.developer.elbetasal.examples.transactions.declarative;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {

	private Long id;

	private String name;

	private String isbn;

}
