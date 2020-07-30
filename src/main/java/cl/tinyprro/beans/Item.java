package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {

	/* ATRIBUTOS */
	@Id
	@Column(name="IDITEM")
	private int idItem;
	private String concepto;
	@Column(name="PRECIOUNIT")
	private float precioUnitario;
	private int cantidad;
	
	@JoinColumn(name="FACTURA_IDFACTURA")
	@ManyToOne(targetEntity = Factura.class)
	private int idFactura;
	
	
	/**Constructor vacío
	 */
	public Item() {
		super();
	}

	/** Constructor sin id
	 * @param concepto
	 * @param precioUnitario
	 * @param cantidad
	 * @param factira_facturaId
	 */
	public Item(String concepto, float precioUnitario, int cantidad, int factira_facturaId) {
		super();
		this.concepto = concepto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.idFactura = factira_facturaId;
	}


	/** Constructor full
	 * @param idItem
	 * @param concepto
	 * @param precioUnitario
	 * @param cantidad
	 * @param factira_facturaId
	 */
	public Item(int idItem, String concepto, float precioUnitario, int cantidad, int factira_facturaId) {
		super();
		this.idItem = idItem;
		this.concepto = concepto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.idFactura = factira_facturaId;
	}


	/**
	 * @return the idItem
	 */
	public int getIdItem() {
		return idItem;
	}
	

	/**
	 * @param idItem the idItem to set
	 */
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	

	/**
	 * @return the concepto
	 */
	public String getConcepto() {
		return concepto;
	}
	

	/**
	 * @param concepto the concepto to set
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	

	/**
	 * @return the precioUnitario
	 */
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

	/**
	 * @return the factira_facturaId
	 */
	public int getFactira_facturaId() {
		return idFactura;
	}
	

	/**
	 * @param factira_facturaId the factira_facturaId to set
	 */
	public void setFactira_facturaId(int factira_facturaId) {
		this.idFactura = factira_facturaId;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", concepto=" + concepto + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", idFactura=" + idFactura + "]";
	}

}
