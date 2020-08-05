package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {

	/* ATRIBUTOS */
	@Id
	@Column(name="IDITEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Item_seq")
	@SequenceGenerator(name="Item_seq", sequenceName = "ITEM_IDITEM_SEQ")
	private int idItem;
	private String concepto;
	@Column(name="PRECIOUNIT")
	private float precioUnitario;
	private int cantidad;
	
	@JoinColumn(name="FACTURA_IDFACTURA", referencedColumnName = "IDFACTURA")
	@ManyToOne(optional = false)
	private Factura factura;

	public Item() {
		
	}
	
	public Item(int idItem, String concepto, float precioUnitario, int cantidad, Factura factura) {
		this.idItem = idItem;
		this.concepto = concepto;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.factura = factura;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Item [idItem=" + idItem + ", concepto=" + concepto + ", precioUnitario=" + precioUnitario
				+ ", cantidad=" + cantidad + ", factura=" + factura.getIdFactura() + "]";
	}
	
	
}
