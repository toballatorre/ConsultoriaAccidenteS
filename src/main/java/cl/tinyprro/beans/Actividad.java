package cl.tinyprro.beans;

import java.sql.Date;

public class Actividad {

	 /* ATRIBUTOS */
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaPlazo;
	private String status;
	private String comentario;
	private int idCliente;
	
	/**
	 * Constructor vacio
	 */
	public Actividad() {
		super();
	}

	/**
	 * Constructor sin id
	 * @param titulo
	 * @param descripcion
	 * @param fechaPlazo
	 * @param status
	 * @param comentario
	 * @param idCliente
	 */
	public Actividad(String titulo, String descripcion, Date fechaPlazo, String status, String comentario,
			int idCliente) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaPlazo = fechaPlazo;
		this.status = status;
		this.comentario = comentario;
		this.idCliente = idCliente;
	}


	/**
	 * Constructor full
	 * @param id
	 * @param titulo
	 * @param descripcion
	 * @param fechaPlazo
	 * @param status
	 * @param comentario
	 * @param idCliente
	 */
	public Actividad(int id, String titulo, String descripcion, Date fechaPlazo, String status, String comentario,
			int idCliente) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaPlazo = fechaPlazo;
		this.status = status;
		this.comentario = comentario;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	/**
	 * @return the fechaPlazo
	 */
	public Date getFechaPlazo() {
		return fechaPlazo;
	}
	

	/**
	 * @param fechaPlazo the fechaPlazo to set
	 */
	public void setFechaPlazo(Date fechaPlazo) {
		this.fechaPlazo = fechaPlazo;
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
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
