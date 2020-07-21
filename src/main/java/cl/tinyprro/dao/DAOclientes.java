package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Cliente;

public class DAOclientes {
	// SQL QUERYS
	private final String SQL_LISTAR_TODO = "SELECT idcliente, nombreempresa, rutempresa, usuario_idusuario from cliente order by idcliente asc";
	private final String SQL_LISTAR_BY_ID ="SELECT idcliente, nombreempresa, rutempresa, usuario_idusuario from cliente where idcliente = ?";
	private final String SQL_UPDATE = "UPDATE CLIENTE set NOMBREEMPRESA = ?, RUTEMPRESA = ? where USUARIO_IDUSUARIO = ?";
	
	JdbcTemplate template;
		
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
public List<Cliente> buscarTodosClientes(){
		
		return template.query(SQL_LISTAR_TODO, new ClienteMapper());
	}

public Cliente buscarPorId(int id) {
	return template.queryForObject(SQL_LISTAR_BY_ID, new Object[]{id}, new ClienteMapper());
}

public int actualizarCliente (Cliente c) {
	return template.update(SQL_UPDATE, new Object[] {
			c.getNombreEmpresa(),
			c.getRutEmpresa(),
			c.getIdUsuario()
	});
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
