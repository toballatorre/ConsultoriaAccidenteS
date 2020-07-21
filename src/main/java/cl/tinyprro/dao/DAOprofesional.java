package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Profesional;

public class DAOprofesional {
	//SQL QUERYS
	private final String SQL_LISTAR_TODO = "SELECT idempleado, nombre, usuario_idusuario, celular FROM profesional ORDER BY idempleado ASC";
	private final String SQL_LISTAR_BY_ID = "SELECT idempleado, nombre, usuario_idusuario, celular FROM profesional WHERE idempleado =?";
	private final String SQL_UPDATE = "UPDATE profesional SET  nombre =?, celular=?   WHERE idempleado = ?";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Profesional> listarTodos(){
		return template.query(SQL_LISTAR_TODO, new ProfesionalMapper());
	}
	
	public Profesional buscarPorId(int id) {
		return template.queryForObject(SQL_LISTAR_BY_ID, new Object[] {id}, new ProfesionalMapper());
	}
	
	public int actualizarPorId (Profesional p) {
		return template.update(SQL_UPDATE, new Object[] {
				p.getNombre(),
				p.getCelular(),
				p.getId()
		}); 
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
