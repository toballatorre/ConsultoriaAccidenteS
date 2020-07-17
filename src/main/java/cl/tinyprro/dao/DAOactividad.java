package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Actividad;

public class DAOactividad {
	
	// SQL QUERYS
	private final String SQL_LISTAR_TODO = "SELECT idactividad, titulo, descripcion, fechaplazo, status, comentario, cliente_idcliente FROM actividad ORDER BY idactividad asc";
	
	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/**
	 * Método buscar todas las actividades
	 * @return Lista de actividades
	 */
	public List<Actividad> buscarTodos(){
		
		return template.query(SQL_LISTAR_TODO, new ActividadMapper());
		
	}
	
	/**
	 * Actividad Mapper
	 * @author Cristobal L
	 *
	 */
	public class ActividadMapper implements RowMapper<Actividad>{
		public Actividad mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Actividad(
					rs.getInt("idactividad"),
					rs.getString("titulo"),
					rs.getString("descripcion"),
					rs.getString("fechaplazo"),
					rs.getString("status"),
					rs.getString("comentario"),
					rs.getInt("cliente_idcliente")
					);
		}
	}
}
