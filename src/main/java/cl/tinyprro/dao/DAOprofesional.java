package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Profesional;

public class DAOprofesional {
	//SQL QUERYS
	private final String SQL_LISTAR_TODO = "SELECT idempleado, nombre, usuario_idusuario, celular FROM profesional";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Profesional> listarTodos(){
		return template.query(SQL_LISTAR_TODO, new ProfesionalMapper());
	}
	
	
	public class ProfesionalMapper implements RowMapper<Profesional>{
		public Profesional mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Profesional(
					rs.getInt("idempleado"),
					rs.getString("nombre"),
					rs.getInt("usuario_idusuario"),
					rs.getString("celular"));
		}
	}
}
