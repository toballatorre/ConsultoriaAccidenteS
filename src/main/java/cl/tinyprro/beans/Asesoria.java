package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ASESORIA")
public class Asesoria {

	/* ATRIBUTOS */
	@Id
	@Column(name="IDASESORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ase_seq")
	@SequenceGenerator(name = "ase_seq", sequenceName = "ASESORIA_IDASESORIA_SEQ")
	private int idasesoria;
	
	@Column(name="CASOASESORIA_IDCASO")
	private int idcaso;

	@Column(name="FECHAASESORIA")
	private String fechaasesoria;
	
	@Column(name="PROFESIONAL")
	private String profesional;
	
	@Column(name="LUGAR")
	private String lugar;
	
	@Column(name="COMENTARIOS")
	private String comentarios;

	/**
	 * Constructor vacio
	 */
	public Asesoria() {
		super();
	}

	/** Constructor full
	 * @param idasesoria
	 * @param idcaso
	 * @param fechaasesoria
	 * @param profesional
	 * @param lugar
	 * @param comentarios
	 */
	public Asesoria(int idasesoria, int idcaso, String fechaasesoria, String profesional, String lugar,
			String comentarios) {
		super();
		this.idasesoria = idasesoria;
		this.idcaso = idcaso;
		this.fechaasesoria = fechaasesoria;
		this.profesional = profesional;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

	/** Constructor sin id
	 * @param idcaso
	 * @param fechaasesoria
	 * @param profesional
	 * @param lugar
	 * @param comentarios
	 */
	public Asesoria(int idcaso, String fechaasesoria, String profesional, String lugar, String comentarios) {
		super();
		this.idcaso = idcaso;
		this.fechaasesoria = fechaasesoria;
		this.profesional = profesional;
		this.lugar = lugar;
		this.comentarios = comentarios;
	}

	/**
	 * @return the idasesoria
	 */
	public int getIdasesoria() {
		return idasesoria;
	}

	/**
	 * @return the idcaso
	 */
	public int getIdcaso() {
		return idcaso;
	}

	/**
	 * @return the fechaasesoria
	 */
	public String getFechaasesoria() {
		return fechaasesoria;
	}

	/**
	 * @return the profesional
	 */
	public String getProfesional() {
		return profesional;
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * @param idasesoria the idasesoria to set
	 */
	public void setIdasesoria(int idasesoria) {
		this.idasesoria = idasesoria;
	}

	/**
	 * @param idcaso the idcaso to set
	 */
	public void setIdcaso(int idcaso) {
		this.idcaso = idcaso;
	}

	/**
	 * @param fechaasesoria the fechaasesoria to set
	 */
	public void setFechaasesoria(String fechaasesoria) {
		this.fechaasesoria = fechaasesoria;
	}

	/**
	 * @param profesional the profesional to set
	 */
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
	
}
