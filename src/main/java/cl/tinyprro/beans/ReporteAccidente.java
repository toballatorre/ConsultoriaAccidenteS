package cl.tinyprro.beans;


public class ReporteAccidente {

/* ATRIBUTOS */
	private int id;
	private String tipoAccidente;
	private int diasPerdidos;
	private String fechaAccidente;
	private String lugarAccidente;
	private String descripcion;
	private int idCliente;
	
	/**
	 * bob el CONSTRUCTOR
	 */
	public ReporteAccidente() {
		super();
	}
	/**
	 * SIN id
	 * @param tipoAccidente
	 * @param diasPerdidos
	 * @param fechaAccidente
	 * @param lugarAccidente
	 * @param descripcion
	 * @param idCliente
	 */
	public ReporteAccidente(String tipoAccidente, int diasPerdidos, String fechaAccidente, String lugarAccidente,
			String descripcion, int idCliente) {
		super();
		this.tipoAccidente = tipoAccidente;
		this.diasPerdidos = diasPerdidos;
		this.fechaAccidente = fechaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.descripcion = descripcion;
		this.idCliente = idCliente;
	}
	/**
	 * constructor full
	 * @param id
	 * @param tipoAccidente
	 * @param diasPerdidos
	 * @param fechaAccidente
	 * @param lugarAccidente
	 * @param descripcion
	 * @param idCliente
	 */
	public ReporteAccidente(int id, String tipoAccidente, int diasPerdidos, String fechaAccidente, String lugarAccidente,
			String descripcion, int idCliente) {
		super();
		this.id = id;
		this.tipoAccidente = tipoAccidente;
		this.diasPerdidos = diasPerdidos;
		this.fechaAccidente = fechaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.descripcion = descripcion;
		this.idCliente = idCliente;
	}
	
/*GET SET, yo solo quiero ser del jet set*/	
	
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
	 * @return the tipoAccidente
	 */
	public String getTipoAccidente() {
		return tipoAccidente;
	}
	/**
	 * @param tipoAccidente the tipoAccidente to set
	 */
	public void setTipoAccidente(String tipoAccidente) {
		this.tipoAccidente = tipoAccidente;
	}
	/**
	 * @return the diasPerdidos
	 */
	public int getDiasPerdidos() {
		return diasPerdidos;
	}
	/**
	 * @param diasPerdidos the diasPerdidos to set
	 */
	public void setDiasPerdidos(int diasPerdidos) {
		this.diasPerdidos = diasPerdidos;
	}
	/**
	 * @return the fechaAccidente
	 */
	public String getFechaAccidente() {
		return fechaAccidente;
	}
	/**
	 * @param fechaAccidente the fechaAccidente to set
	 */
	public void setFechaAccidente(String fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}
	/**
	 * @return the lugarAccidente
	 */
	public String getLugarAccidente() {
		return lugarAccidente;
	}
	/**
	 * @param lugarAccidente the lugarAccidente to set
	 */
	public void setLugarAccidente(String lugarAccidente) {
		this.lugarAccidente = lugarAccidente;
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
