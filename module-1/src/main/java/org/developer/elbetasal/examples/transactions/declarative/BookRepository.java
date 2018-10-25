package org.developer.elbetasal.examples.transactions.declarative;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

	private final NamedParameterJdbcTemplate template;

	private final DataSourceTransactionManager dataSourceTransactionManager;

	public BookRepository(DataSource dataSource,
	                      DataSourceTransactionManager dataSourceTransactionManager) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}

	public Book createBook(Book book){
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
		String sql = "insert into books (name , isbn) values (:name , :isbn)";
		try{
			template.update(sql , new MapSqlParameterSource("name" , book.getName())
					.addValue("isbn", book.getIsbn()));
			dataSourceTransactionManager.commit(status);
		}catch (Exception exception){
			dataSourceTransactionManager.rollback(status);
		}
		return book;
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
