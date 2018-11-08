package org.developer.elbetasal.examples.transactions.declarative;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookRepository {

	private final NamedParameterJdbcTemplate template;

	private final AnotherBookRepository anotherBookRepository;


	public BookRepository(DataSource dataSource,
	                      AnotherBookRepository anotherBookRepository) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.anotherBookRepository = anotherBookRepository;
	}

	@Transactional(rollbackFor = TransactionalTestException.class)
	public Book createBook(Book book){
		String sql = "insert into books (name , isbn) values (:name , :isbn)";
		try{
			template.update(sql , new MapSqlParameterSource("name" , book.getName())
					.addValue("isbn", book.getIsbn()));
			if( book.getName().equalsIgnoreCase("FAIL")){
				throw new RuntimeException();
			}
			anotherBookRepository.saveAnotherBook();
		}catch (Exception exception){
			throw new TransactionalTestException();
		}
		return book;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW , rollbackFor = RuntimeException.class)
	void saveAnotherBook() {
		String sql = "insert into books (name , isbn) values (:name , :isbn)";
		template.update(sql , new MapSqlParameterSource("name" , "Probando")
				.addValue("isbn", "ISBN"));
	}


	public List<Book> findAllBooks() {
		String sql = "select id , name , isbn from books";
		return this.template.query(sql, (resultSet, i) -> Book
				.builder()
				.name(resultSet.getString("NAME"))
				.isbn(resultSet.getString("ISBN"))
				.id(resultSet.getLong("ID"))
				.build());
	}
}
