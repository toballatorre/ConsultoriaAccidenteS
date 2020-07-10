package cl.tinyprro.beans;

import java.sql.Date;

public class SolicitudAsesoria {

/* ATRIBUTOS */
	private int id;
	private Date fechaHora;
	private String motivo;
	private String preferenciaHorario;
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
	public SolicitudAsesoria(Date fechaHora, String motivo, String preferenciaHorario, int idCliente) {
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
	public SolicitudAsesoria(int id, Date fechaHora, String motivo, String preferenciaHorario, int idCliente) {
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
	public Date getFechaHora() {
		return fechaHora;
	}
	
	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
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
