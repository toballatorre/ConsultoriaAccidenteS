package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PREGUNTA")
public class Pregunta {

	@Id
	@Column(name="IDPREGUNTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preg_seq")
	@SequenceGenerator(name = "preg_seq", sequenceName = "PREGUNTA_IDPREGUNTA_SEQ")
	private int id;
	@Column(name="CHECKLIST_IDCHECKLIST")
	private int idChecklist;
	@Column(name="PREGUNTA")
	private String pregunta;
	@Column(name="RESPUESTA")
	private String respuesta;
	@Column(name="COMENTARIOS")
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
	public Pregunta(int idChecklist,String pregunta) {
		super();
		this.idChecklist = idChecklist;
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
