package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporteaccidente")
public class ReporteAccidente {

/* ATRIBUTOS */
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO);
	@Column (name="IDREPORTE")
	private int id;
	@Column (name="TIPOACCIDENTE")
	private String tipoAccidente;
	@Column (name="DIASPERDIDOS")
	private int diasPerdidos;
	@Column (name="FECHAACCIDENTE")
	private String fechaAccidente;
	@Column (name="LUGARACCIDENTE")
	private String lugarAccidente;
	@Column (name="DESCRIPCION")
	private String descripcion;
	@Column (name="CLIENTE_IDCLIENTE")
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
