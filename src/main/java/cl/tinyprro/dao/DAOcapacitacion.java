package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Capacitacion;

public class DAOcapacitacion {

	//SQL QUERYS
	private final String SQL_INSERT = "INSERT INTO capacitacion (cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_LISTAR_TODO = "SELECT idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro FROM capacitacion";
	private final String SQL_POR_ID = "SELECT idcapacitacion, cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro FROM capacitacion WHERE idcapacitacion = ?";

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	/**
	 * Busca una capacitacion por su id
	 * @param id
	 * @return
	 */
	public Capacitacion buscarPorId(int id) {
		return template.queryForObject(SQL_POR_ID, new Object[] {id}, new CapacitacionMapper());
	}
	/**
	 * Insertar una capacitacion a la base de datos
	 * @param c
	 * @return
	 */
	public int ingresarCapacitacion(Capacitacion c) {
		return template.update(SQL_INSERT, new Object[]{c.getIdCliente(), c.getTema(), c.getObjetivos(),
				c.getContenidos(), c.getRecursos(), c.getFecha(), c.getIdUsuarioPro()});
	}
	/**
	 * Busca todas las capacitaciones de la tabla
	 * @return
	 */
	public List<Capacitacion> buscarTodos(){
				
		return template.query(SQL_LISTAR_TODO, new CapacitacionMapper());
	}
	
	public class CapacitacionMapper implements RowMapper<Capacitacion>{
		public Capacitacion mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Capacitacion(rs.getInt("idcapacitacion"),
									rs.getInt("cliente_idcliente"),
									rs.getString("tema"),
									rs.getString("objetivos"),
									rs.getString("contenidos"),
									rs.getString("recursos"),
									rs.getString("fecha"),
									rs.getInt("idusuariopro"));
		}
	}

}
