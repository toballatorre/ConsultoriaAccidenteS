package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.SolicitudAsesoria;

public class DAOasesoria {
	
	//SQL QUERYS
	private final String SQL_BUSCAR_TODO = "SELECT idsolicitud, fechahora, motivo, preferenciahorario, cliente_idcliente FROM solicitudasesoria";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<SolicitudAsesoria> buscarTodos(){
		return template.query(SQL_BUSCAR_TODO, new AsesoriaMapper());
	}
	
	public class AsesoriaMapper implements RowMapper<SolicitudAsesoria>{
		public SolicitudAsesoria mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new SolicitudAsesoria(
					rs.getInt("idsolicitud"),
					rs.getString("fechahora"),
					rs.getString("motivo"),
					rs.getString("preferenciahorario"),
					rs.getInt("cliente_idcliente"));
		}
	}
	
}
