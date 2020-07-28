package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {

	/* ATRIBUTOS */
	@Id
	@Column(name="IDCLIENTE")
	private int id;
	@Column(name="NOMBREEMPRESA")
	private String nombreEmpresa;
	@Column(name="RUTEMPRESA")
	private String rutEmpresa;
	@Column(name="USUARIO_IDUSUARIO")
	private int idUsuario;

	/**
	 * Contructor vacio
	 */
	public Cliente() {
		super();
	}

	/**
	 * Constructor sin id
	 * @param nombreEmpresa
	 * @param rutEmpresa
	 * @param idUsuario
	 */
	public Cliente(String nombreEmpresa, String rutEmpresa, int idUsuario) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.idUsuario = idUsuario;
	}

	/**
	 * Constructor full
	 * @param id
	 * @param nombreEmpresa
	 * @param rutEmpresa
	 * @param idUsuario
	 */
	public Cliente(int id, String nombreEmpresa, String rutEmpresa, int idUsuario) {
		super();
		this.id = id;
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.idUsuario = idUsuario;
	}

	/**
	 * id getter
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
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the rutEmpresa
	 */
	public String getRutEmpresa() {
		return rutEmpresa;
	}

	/**
	 * @param rutEmpresa the rutEmpresa to set
	 */
	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
		
}
