package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SOLICITUDASESORIA")
public class SolicitudAsesoria {

/* ATRIBUTOS */
	@Id
	@Column(name="IDSOLICITUD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sol_seq")
	@SequenceGenerator(name = "Sol_seq", sequenceName = "SOLICITUDASESORIA_IDSOLICITUD")
	private int id;
	@Column(name="FECHAHORA")
	private String fechaHora;
	@Column(name="MOTIVO")
	private String motivo;
	@Column(name="PREFERENCIAHORARIO")
	private String preferenciaHorario;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	
	/**
	 * Constructor vacio
	 */
	public SolicitudAsesoria() {
		super();
	}
	/**
	 * Constructor sin id
	 * @param fechaHora
	 * @param motivo
	 * @param preferenciaHorario
	 * @param idCliente
	 */
	public SolicitudAsesoria(String fechaHora, String motivo, String preferenciaHorario, int idCliente) {
		super();
		this.fechaHora = fechaHora;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
	}
	
	/**
	 * Constructor full
	 * @param id
	 * @param fechaHora
	 * @param motivo
	 * @param preferenciaHorario
	 * @param idCliente
	 */
	public SolicitudAsesoria(int id, String fechaHora, String motivo, String preferenciaHorario, int idCliente) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivo = motivo;
		this.preferenciaHorario = preferenciaHorario;
		this.idCliente = idCliente;
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
	 * @return the fechaHora
	 */
	public String getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
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
	
	
	
	
}
