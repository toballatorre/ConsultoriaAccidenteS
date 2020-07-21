package cl.tinyprro.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Usuario;

public class DAOusuarios {

	// SQL QUERYS
	private final String SQL_LISTAR_TODO = 
			"SELECT IDUSUARIO ,USUARIO , TIPOUSUARIO , CLAVE , MAIL , ACTIVO  from usuario order by idusuario asc";
	private final String SQL_LISTAR_BY_ID = 
			"SELECT IDUSUARIO ,USUARIO , TIPOUSUARIO , CLAVE , MAIL , ACTIVO  from usuario  where idusuario = ?";
	private final String SQL_UPDATE = 
			"UPDATE USUARIO SET USUARIO = ?, TIPOUSUARIO = ?, CLAVE =?, MAIL = ?, ACTIVO = ? WHERE idusuario = ? ";
	private final String SQL_INSERT = 
			"INSERT INTO USUARIO (USUARIO, TIPOUSUARIO, CLAVE, MAIL, ACTIVO) VALUES (?, ?, ?, ?, ?)";
	
	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/**
	 * Método buscar todos los usuarios 
	 * @return Lista de usuarios
	 */
	public List<Usuario> buscarTodos(){
		
		return template.query(SQL_LISTAR_TODO, new UsuarioMapper());
	}
	
	public Usuario buscarPorId(int id) {
		
		return template.queryForObject(SQL_LISTAR_BY_ID, new Object[] {id}, new UsuarioMapper());
	}
	
	public int actualizarPorId(Usuario usr) {
		return template.update(SQL_UPDATE, new Object[] {usr.getUsuario(), usr.getTipousuario(), usr.getClave(), usr.getMail(), usr.getActivo(), usr.getId()});
	}
	
	public int ingresarUsuario (Usuario u) {
		return template.update(SQL_INSERT,  new Object[]{
				u.getUsuario(),
				u.getTipousuario(),
				u.getClave(),
				u.getMail(),
				u.getActivo()
		}
		);
		
	}
	
	
	public class UsuarioMapper implements RowMapper<Usuario>{
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Usuario(
					rs.getInt("IDUSUARIO"),
					rs.getString("USUARIO"),
					rs.getString("TIPOUSUARIO"),
					rs.getString("CLAVE"),
					rs.getString("MAIL"),
					rs.getString("ACTIVO")
					);
					
		};
	}
	
	
}
