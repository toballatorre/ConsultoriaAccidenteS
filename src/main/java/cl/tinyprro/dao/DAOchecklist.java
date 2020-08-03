package cl.tinyprro.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import cl.tinyprro.beans.Checklist;

public class DAOchecklist {

	// SQL QUERYS
	private final String SQL_GUARDAR_A =
			"INSERT INTO CHECKLIST (IDCHECKLIST, CLIENTE_IDCLIENTE, DESCRIPCION, STATUS, COMENTARIOS ) VALUES (CHECKLIST_IDCHECKLIST_SEQ.nextval, ?,?, ?, ?)";
	
	private final String SQL_INSERT_PREGUNTA =
			"begin select CHECKLIST_IDCHECKLIST_SEQ.nextval from checklist;INSERT INTO PREGUNTA (CHECKLIST_IDCHECKLIST, PREGUNTA) VALUES (CHECKLIST_IDCHECKLIST_SEQ.currval, ?);end";
	
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int ingresarChecklist (Checklist ch) {
		return template.update(SQL_GUARDAR_A, new Object[] {
			ch.getIdCliente(),
			ch.getDescripcion(),
			ch.getStatus(),
			ch.getComentarios()		
		});
	}

	public int ingresarPregunta(String preg) {
			
		return template.update(SQL_INSERT_PREGUNTA, new Object[] {
				preg				
			});
	}
	
}
