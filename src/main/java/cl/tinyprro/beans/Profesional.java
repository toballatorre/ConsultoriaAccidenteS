package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PROFESIONAL")
public class Profesional {
	
	/* ATRIBUTOS */
	@Id
	@Column(name="IDEMPLEADO")
	private int id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="USUARIO_IDUSUARIO")
	private int idusuario;
	@Column(name="CELULAR")
	private String celular;

	/**
	 * Constructor vacio
	 */
	public Profesional() {
		super();
	}

	/**
	 * Constructor sin id
	 * @param nombre
	 * @param idusuario
	 * @param celular
	 */
	public Profesional(String nombre, int idusuario, String celular) {
		super();
		this.nombre = nombre;
		this.idusuario = idusuario;
		this.celular = celular;
	}

	/**
	 * Constructor full
	 * @param id
	 * @param nombre
	 * @param idusuario
	 * @param celular
	 */
	public Profesional(int id, String nombre, int idusuario, String celular) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idusuario = idusuario;
		this.celular = celular;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}
	

	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}
	

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
