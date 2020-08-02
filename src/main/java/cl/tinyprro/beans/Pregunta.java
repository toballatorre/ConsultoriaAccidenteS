package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PREGUNTA")
public class Pregunta {

	@Id
	@Column(name="IDPREGUNTA")
	private int id;
	@Column(name="CHECKLIST_IDCHECKLIST")
	private int idChecklist;
	private String pregunta;
	private String respuesta;
	private String comentarios;
	
	/* CONSTRUCTORES */
	public Pregunta() {	
	}
	
	// Todos los atributos
	public Pregunta(int id, int idChecklist, String pregunta, String respuesta, String comentarios) {
		this.id = id;
		this.idChecklist = idChecklist;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.comentarios = comentarios;
	}

	
	/** solo pregunta
	 * @param idChecklist
	 * @param pregunta
	 * @param respuesta
	 * @param comentarios
	 */
	public Pregunta(String pregunta) {
		super();
		this.pregunta = pregunta;
	}

	/* GET AND SET */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdChecklist() {
		return idChecklist;
	}

	public void setIdChecklist(int idChecklist) {
		this.idChecklist = idChecklist;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", idChecklist=" + idChecklist + ", pregunta=" + pregunta + ", respuesta="
				+ respuesta + ", comentarios=" + comentarios + "]";
	}
	
	
}
