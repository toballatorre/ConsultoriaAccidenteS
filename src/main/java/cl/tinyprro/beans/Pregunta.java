package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@JoinColumn(name="CHECKLIST_IDCHECKLIST", referencedColumnName = "IDCHECKLIST")
	@ManyToOne
	private Checklist checklist;
	
	@Column(name="PREGUNTA")
	private String pregunta;
	@Column(name="RESPUESTA")
	private String respuesta;
	@Column(name="COMENTARIOS")
	private String comentarios;
	
	public Pregunta() {
		
	}
	
	public Pregunta(int id, Checklist checklist, String pregunta, String respuesta, String comentarios) {
		this.id = id;
		this.checklist = checklist;
		this.pregunta = pregunta;
		this.respuesta = respuesta;
		this.comentarios = comentarios;
	}
	
	public Pregunta(Checklist checklist, String pregunta) {
		this.checklist = checklist;
		this.pregunta = pregunta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Checklist getChecklist() {
		return checklist;
	}

	public void setChecklist(Checklist checklist) {
		this.checklist = checklist;
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
		return "Pregunta [id=" + id + ", checklist=" + checklist + ", pregunta=" + pregunta + ", respuesta=" + respuesta
				+ ", comentarios=" + comentarios + "]";
	}
	
}
