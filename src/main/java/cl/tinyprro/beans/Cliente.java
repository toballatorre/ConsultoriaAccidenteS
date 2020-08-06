package cl.tinyprro.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	/* OneToMany Unidireccional sólo para traer sus datos */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_IDCLIENTE", referencedColumnName = "IDCLIENTE")
	private Set<ReporteAccidente> listaAccidentes;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_IDCLIENTE", referencedColumnName = "IDCLIENTE")
	private Set<SolicitudAsesoria> listaAsesoriaE;
	 
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_IDCLIENTE", referencedColumnName = "IDCLIENTE")
	private Set<Capacitacion> listaCapacitaciones;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENTE_IDCLIENTE", referencedColumnName = "IDCLIENTE")
	private Set<Factura> listaFacturas;
	
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

	public Set<ReporteAccidente> getListaAccidentes() {
		return listaAccidentes;
	}

	public void setListaAccidentes(Set<ReporteAccidente> listaAccidentes) {
		this.listaAccidentes = listaAccidentes;
	}

	
	public Set<SolicitudAsesoria> getListaAsesoriaE() { 
		return listaAsesoriaE;
	}

	public void setListaAsesoriaE(Set<SolicitudAsesoria> listaAsesoriaE) {
		this.listaAsesoriaE = listaAsesoriaE;
	}
	 
	public Set<Capacitacion> getListaCapacitaciones() {
		return listaCapacitaciones;
	}
	
	public void setListaCapacitaciones(Set<Capacitacion> listaCapacitaciones) {
		this.listaCapacitaciones = listaCapacitaciones;
	}


	public Set<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(Set<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombreEmpresa=" + nombreEmpresa + ", rutEmpresa=" + rutEmpresa + ", idUsuario="
				+ idUsuario + "]";
	}
		
}
