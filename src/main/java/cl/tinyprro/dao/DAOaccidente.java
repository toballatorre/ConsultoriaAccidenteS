package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.ReporteAccidente;

public class DAOaccidente {
	
	//SQL Query
	private final String SQL_BUSCAR_TODOS = "SELECT idreporte, tipoaccidente, diasperdidos, fechaaccidente, lugaraccidente, descripcion, cliente_idcliente FROM reporteaccidente";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<ReporteAccidente> buscarTodos(){
		return template.query(SQL_BUSCAR_TODOS, new AccidenteMapper());
	}
	
	public class AccidenteMapper implements RowMapper<ReporteAccidente>{
		public ReporteAccidente mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new ReporteAccidente(
					rs.getInt("idreporte"),
					rs.getString("tipoaccidente"),
					rs.getInt("diasperdidos"),
					rs.getString("fechaaccidente"),
					rs.getString("lugaraccidente"),
					rs.getString("descripcion"),
					rs.getInt("cliente_idcliente"));
		}
	}
}
