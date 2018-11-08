package org.developer.elbetasal.examples.transactions.declarative;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
public class AnotherBookRepository {

	private final NamedParameterJdbcTemplate template;

	public AnotherBookRepository(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW , rollbackFor = RuntimeException.class)
	public void saveAnotherBook() {
		String sql = "insert into books (name , isbn) values (:name , :isbn)";
		template.update(sql , new MapSqlParameterSource("name" , "Probando")
				.addValue("isbn", "ISBN"));
	}
}
