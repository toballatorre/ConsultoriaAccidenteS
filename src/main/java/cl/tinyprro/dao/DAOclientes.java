package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Cliente;

public class DAOclientes {
	// SQL QUERYS
	private final String SQL_LISTAR_TODO = "SELECT idcliente, nombreempresa, rutempresa, usuario_idusuario from cliente";
	

	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
public List<Cliente> buscarTodosClientes(){
		
		return template.query(SQL_LISTAR_TODO, new ClienteMapper());
	}


public class ClienteMapper implements RowMapper<Cliente>{
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
	return new Cliente(
			rs.getInt("idcliente"),
			rs.getString("nombreempresa"),
			rs.getString("rutempresa"),
			rs.getInt("usuario_idusuario")
			);

	};
}


}
