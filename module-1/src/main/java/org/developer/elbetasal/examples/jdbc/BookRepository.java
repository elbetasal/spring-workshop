package org.developer.elbetasal.examples.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public BookRepository(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Book> findBooks() {
		return jdbcTemplate.query("select ID , NAME , ISBN from books",
				new BookMapper());
	}

	public Book findBookById(Long id) {
		return jdbcTemplate.queryForObject(
				"select ID, NAME, ISBN from books where id = :id",
				new MapSqlParameterSource("id" , id),
				new BookMapper());

	}

	public void addBook(String name , String isbn){
		int rows = jdbcTemplate.update(
				"insert into books (NAME , ISBN) values (:name , :isbn)",
				new MapSqlParameterSource("name" , name)
				.addValue("isbn" , isbn));

		System.out.println("Agregando " + rows);
	}

	public void deleteBookById (Long id){
		int deletedRows = jdbcTemplate.update("delete from books where id = :id" ,
				new MapSqlParameterSource("id" , id));
		System.out.println("Borrando " + deletedRows);
	}

	public void updateBookNameById (String name , Long id) {
		int updatedRows = jdbcTemplate.update("update books set name=:name where id = :id" ,
				new MapSqlParameterSource("name" , name)
						.addValue("id" , id));
		System.out.println("Actualizando "+ updatedRows);
	}

	static class BookMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet resultSet, int i) throws SQLException {
			return Book
					.builder()
					.isbn(resultSet.getString("ISBN"))
					.id(resultSet.getLong("ID"))
					.name(resultSet.getString("NAME"))
					.build();
		}
	}
}
