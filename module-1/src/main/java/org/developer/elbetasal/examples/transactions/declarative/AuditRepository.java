package org.developer.elbetasal.examples.transactions.declarative;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
public class AuditRepository {

	private final NamedParameterJdbcTemplate template;

	public AuditRepository(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void audit(String message) {
		String sql = "insert into auditoria (descripcion) values (:descripcion)";
		template.update(sql, new MapSqlParameterSource("descripcion", message));
	}
}
