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
	private final String SQL_BY_ID = "SELECT idactividad, titulo, descripcion, fechaplazo, status, comentario, cliente_idcliente FROM actividad WHERE idactividad = ?";
	private final String SQL_INSERT = "INSERT INTO actividad (titulo, descripcion, fechaplazo, status, comentario, cliente_idcliente) VALUES (?, ?, ?, ?, ?, ?)";
	
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
	 * Método para buscar una actividad en específico
	 * @param id
	 * @return
	 */
	public Actividad actividadById(int id) {
		return template.queryForObject(SQL_BY_ID, new Object[] {id}, new ActividadMapper());
	}
	
	public int ingresarActividad(Actividad a) {
		return template.update(SQL_INSERT, new Object[] {a.getTitulo(), a.getDescripcion(), a.getFechaPlazo(), a.getStatus(), a.getComentario(), a.getIdCliente()});
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
