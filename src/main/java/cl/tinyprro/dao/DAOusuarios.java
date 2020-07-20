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
			"SELECT IDUSUARIO ,USUARIO , TIPOUSUARIO , CLAVE , MAIL , ACTIVO  from usuario  where idusuario = ? order by idusuario asc";
	private final String SQL_UPDATE = 
			"UPDATE USUARIO SET USUARIO = ?, TIPOUSUARIO = ?, CLAVE =?, MAIL = ?, ACTIVO = ? WHERE idusuario = ? ";
	
	
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
	/*
	public boolean actualizarPorId(Usuario usr) {
		boolean creado = false;
		PreparedStatement ps;
	       	try {
	       		ps.getConnection().prepareStatement(SQL_UPDATE);
				ps.setString(1,usr.getUsuario());
				ps.setString(2,usr.getTipousuario());  
				ps.setString(3,usr.getClave());  
				ps.setString(4,usr.getMail());  
				ps.setString(5,usr.getActivo());  
				ps.setInt(6,usr.getId());  
				
				if (ps.executeUpdate() > 0) {
					creado = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        	         
		return creado;
	}*/
	
	
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
