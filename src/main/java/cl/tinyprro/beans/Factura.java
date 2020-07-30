package cl.tinyprro.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FACTURA")
public class Factura {
	
	/* CABECERA */
	@Id
	@Column(name="IDFACTURA")
	private int idFactura;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	@Column(name="FECHAEMISION")
	private String fechaemision;
	@Column(name="FECHAVENCIMIENTO")
	private String fechavencimiento;
	@Column(name="FECHAPAGO")
	private String fechapago;
	@Column(name="IVAAPLICABLE")
	private float IVA;
	
	/* DETALLE */
	@OneToMany(mappedBy = "factura", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<Item> listaItem;

	/* CONSTRUCTORES */
	public Factura() {
		listaItem = new ArrayList<Item>();
	}

	public Factura(int id, int idCliente, String fechaEmision, String fechaVencimiento, String fechaPago,
			List<Item> listaItem) {
		this.idFactura = id;
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

	public void setIdFactura(int id) {
		this.idFactura = id;
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
			total += ((i.getCantidad() * i.getPrecioUnitario())*(1+(IVA/100)));
		}
		
		return total;
	}
	/**
	 * Retorna el total de un item en específico
	 * @param i ItemDTO a calcular
	 * @return
	 */
	public float Totales(Item i) {
		return ((i.getCantidad() * i.getPrecioUnitario())*(1+(IVA/100)));
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", idCliente=" + idCliente + ", fechaemision=" + fechaemision
				+ ", fechavencimiento=" + fechavencimiento + ", fechapago=" + fechapago + "]";
	}
	
}
