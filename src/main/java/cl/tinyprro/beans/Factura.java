package cl.tinyprro.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FACTURA")
public class Factura {
	/* CONSTANTE */
	private final float IVA = 0.19f;
	
	/* CABECERA */
	@Id
	@Column(name="IDFACTURA")
	private int idFactura;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	private String fechaemision;
	private String fechavencimiento;
	private String fechapago;
	
	/* DETALLE */
	private List<Item> listaItem = null;

	/* CONSTRUCTORES */
	public Factura() {
	}

	public Factura(int idFactura, int idCliente, String fechaEmision, String fechaVencimiento, String fechaPago,
			List<Item> listaItem) {
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.fechaemision = fechaEmision;
		this.fechavencimiento = fechaVencimiento;
		this.fechapago = fechaPago;
		this.listaItem = listaItem;
	}

	/* GET AND SET */
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCliente_idCliente() {
		return idCliente;
	}

	public void setCliente_idCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaEmision() {
		return fechaemision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaemision = fechaEmision;
	}

	public String getFechaVencimiento() {
		return fechavencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechavencimiento = fechaVencimiento;
	}

	public String getFechaPago() {
		return fechapago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechapago = fechaPago;
	}

	public List<Item> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public float getIVA() {
		return IVA;
	}
	
	/* METODOS */
	/**
	 * Retorna el subtotal de todos los itemes
	 * @return
	 */
	public float subTotales() {
		float total = 0;
		
		for (Item i : listaItem) {
			total += (i.getCantidad() * i.getPrecioUnitario());
		}
		
		return total;
	}
	
	/**
	 * Retorna el subtotal de un item en específico
	 * @param i ItemDTO a calcular
	 * @return
	 */
	public float subTotales(Item i) {
		return (i.getCantidad() * i.getPrecioUnitario());
	}
	
	/**
	 * Retorna el total de todos los itemes
	 * @return
	 */
	public float Totales() {
		float total = 0;
		
		for (Item i : listaItem) {
			total += ((i.getCantidad() * i.getPrecioUnitario())*(1+IVA));
		}
		
		return total;
	}
	/**
	 * Retorna el total de un item en específico
	 * @param i ItemDTO a calcular
	 * @return
	 */
	public float Totales(Item i) {
		return ((i.getCantidad() * i.getPrecioUnitario())*(1+IVA));
	}
	
}
