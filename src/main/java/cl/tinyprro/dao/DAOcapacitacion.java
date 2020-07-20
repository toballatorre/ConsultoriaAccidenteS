package cl.tinyprro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.tinyprro.beans.Capacitacion;

public class DAOcapacitacion {

	//SQL QUERYS
	private final String SQL_INSERT = "INSERT INTO capacitacion (cliente_idcliente, tema, objetivos, contenidos, recursos, fecha, idusuariopro) VALUES (?, ?, ?, ?, ?, ?, ?)";

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
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
