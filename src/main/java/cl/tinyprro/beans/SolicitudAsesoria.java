package cl.tinyprro.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SOLICITUDASESORIA")
public class SolicitudAsesoria {

	/* ATRIBUTOS */
	@Id
	@Column(name = "IDSOLICITUD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sol_seq")
	@SequenceGenerator(name = "Sol_seq", sequenceName = "SOLICITUDASESORIA_IDSOLICITUD")
	private int id;
	//TObal
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHASOLICITUD")
	private Date fechasolicitud;
	@Column(name = "MOTIVO")
	private String motivo;
	@Column(name = "PREFERENCIAHORARIO")
	private String preferenciaHorario;
	@Column(name = "CLIENTE_IDCLIENTE")
	private int idCliente;
	@Column(name = "STATUS")
	private String status;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAAGENDADA")
	private Date fechaagenda;
	@Column(name = "LUGAR")
	private String lugar;
	@Column(name = "CONTACTO")
	private String contacto;
	@Column(name = "DETALLE")
	private String detalle;

	
	
	
	/**
	 * Constructor vacio
	 */
	public SolicitudAsesoria() {
		super();
	}

	/** Todos los atributos
	 * @param id
	 * @param fechasolicitud
	 * @param motivo
	 * @param preferenciaHorario
	 * @param idCliente
	 * @param status
	 * @param fechaagenda
	 * @param lugar
	 * @param contacto
	 * @param detalle
	 */
	public SolicitudAsesoria(int id, Date fechasolicitud, String motivo, String preferenciaHorario, int idCliente,
			String status, Date fechaagenda, String lugar, String contacto, String detalle) {
		super();
		this.id = id;
		this.fechasolicitud = fechasolicitud;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
		this.status = status;
		this.fechaagenda = fechaagenda;
		this.lugar = lugar;
		this.contacto = contacto;
		this.detalle = detalle;
	}

	/** Constructor para vista cliente
	 * @param id
	 * @param fechasolicitud
	 * @param motivo
	 * @param preferenciaHorario
	 * @param idCliente
	 * @param status
	 */
	public SolicitudAsesoria(Date fechasolicitud, String motivo, String preferenciaHorario, int idCliente,
			String status) {
		super();
		this.fechasolicitud = fechasolicitud;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
		this.status = status;
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
	 * @return the fechasolicitud
	 */
	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	/**
	 * @param fechasolicitud the fechasolicitud to set
	 */
	public void setFechasolicitud(String fechasolicitud) {
		this.fechasolicitud = Utilidades.AjustaFecha(fechasolicitud);
	}

	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the preferenciaHorario
	 */
	public String getPreferenciaHorario() {
		return preferenciaHorario;
	}

	/**
	 * @param preferenciaHorario the preferenciaHorario to set
	 */
	public void setPreferenciaHorario(String preferenciaHorario) {
		this.preferenciaHorario = preferenciaHorario;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the fechaagenda
	 */
	public Date getFechaagenda() {
		return fechaagenda;
	}

	/**
	 * @param fechaagenda the fechaagenda to set
	 */
	public void setFechaagenda(String fechaagenda) {
		this.fechaagenda = Utilidades.AjustaFecha(fechaagenda);
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "SolicitudAsesoria [id=" + id + ", fechasolicitud=" + fechasolicitud + ", motivo=" + motivo
				+ ", preferenciaHorario=" + preferenciaHorario + ", idCliente=" + idCliente + ", status=" + status
				+ ", fechaagenda=" + fechaagenda + ", lugar=" + lugar + ", contacto=" + contacto + ", detalle="
				+ detalle + "]";
	}

	
	
}
