package cl.tinyprro.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CASOASESORIA")
public class CasoAsesoria {
	/* ATRIBUTOS */
	@Id
	@Column(name="IDCASO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caso_seq")
	@SequenceGenerator(name = "caso_seq", sequenceName = "CASOASESORIA_IDCASO_SEQ")
	private int idcaso;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idcliente;
	@Column(name="CODIGOCONTRATO")
	private String codigocontrato;
	@Column(name="PLAN")
	private String plan;
	@Column(name="CONTACTO")
	private String contacto;
	@Column(name="CASOACTIVO")
	private String casoactivo;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "CASOASESORIA_IDCASO", referencedColumnName = "IDCASO")
	List<Asesoria>listaAs;

	/**
	 * Contructor vacio
	 */
	public CasoAsesoria() {
		super();
	}

	/** Constructor full
	 * @param idcaso
	 * @param idcliente
	 * @param codigocontrato
	 * @param plan
	 * @param contacto
	 * @param casoactivo
	 * @param listaAs
	 */
	
	public CasoAsesoria(int idcaso, int idcliente, String codigocontrato, String plan, String contacto,
			String casoactivo, List<Asesoria> listaAs) {
		super();
		this.idcaso = idcaso;
		this.idcliente = idcliente;
		this.codigocontrato = codigocontrato;
		this.plan = plan;
		this.contacto = contacto;
		this.casoactivo = casoactivo;
		this.listaAs = listaAs;
	}
	
	/**Constructor full sin listaAs
	 * @param idcaso
	 * @param idcliente
	 * @param codigocontrato
	 * @param plan
	 * @param contacto
	 * @param casoactivo
	 */
	public CasoAsesoria(int idcaso, int idcliente, String codigocontrato, String plan, String contacto,
			String casoactivo) {
		super();
		this.idcaso = idcaso;
		this.idcliente = idcliente;
		this.codigocontrato = codigocontrato;
		this.plan = plan;
		this.contacto = contacto;
		this.casoactivo = casoactivo;
	}

	/**Constructor sin id y sin ListaAs
	 * @param idcliente
	 * @param codigocontrato
	 * @param plan
	 * @param contacto
	 * @param casoactivo
	 */
	public CasoAsesoria(int idcliente, String codigocontrato, String plan, String contacto, String casoactivo) {
		super();
		this.idcliente = idcliente;
		this.codigocontrato = codigocontrato;
		this.plan = plan;
		this.contacto = contacto;
		this.casoactivo = casoactivo;
	}

	/**
	 * @return the idcaso
	 */
	public int getIdcaso() {
		return idcaso;
	}

	/**
	 * @return the idcliente
	 */
	public int getIdcliente() {
		return idcliente;
	}

	/**
	 * @return the codigocontrato
	 */
	public String getCodigocontrato() {
		return codigocontrato;
	}

	/**
	 * @return the plan
	 */
	public String getPlan() {
		return plan;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @return the casoactivo
	 */
	public String getCasoactivo() {
		return casoactivo;
	}

	/**
	 * @return the listaAs
	 */
	public List<Asesoria> getListaAs() {
		return listaAs;
	}

	/**
	 * @param idcaso the idcaso to set
	 */
	public void setIdcaso(int idcaso) {
		this.idcaso = idcaso;
	}

	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	/**
	 * @param codigocontrato the codigocontrato to set
	 */
	public void setCodigocontrato(String codigocontrato) {
		this.codigocontrato = codigocontrato;
	}

	/**
	 * @param plan the plan to set
	 */
	public void setPlan(String plan) {
		this.plan = plan;
	}

	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * @param casoactivo the casoactivo to set
	 */
	public void setCasoactivo(String casoactivo) {
		this.casoactivo = casoactivo;
	}

	/**
	 * @param listaAs the listaAs to set
	 */
	public void setListaAs(List<Asesoria> listaAs) {
		this.listaAs = listaAs;
	}

	
	
	
	

}
