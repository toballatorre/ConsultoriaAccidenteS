package cl.tinyprro.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FACTURA")
public class Factura {
	
	/* CABECERA */
	@Id
	@Column(name="IDFACTURA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Fact_seq")
	@SequenceGenerator(name="Fact_seq", sequenceName = "FACTURA_IDFACTURA_SEQ")
	private int idFactura;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHAEMISION")
	private Date fechaemision;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHAVENCIMIENTO")
	private Date fechavencimiento;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHAPAGO")
	private Date fechapago;
	@Column(name="IVAAPLICABLE")
	private float IVA;
	
	/* DETALLE */
//	@OneToMany(mappedBy = "factura", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
//	private List<Item> listaItem;
//	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "FACTURA_IDFACTURA", referencedColumnName = "IDFACTURA")
	private List<Item> listaItem;

	/* CONSTRUCTORES */
	public Factura() {
		this.listaItem = new ArrayList<Item>();
		this.IVA = 19;
	}

	public Factura(int id, int idCliente, Date fechaEmision, Date fechaVencimiento, Date fechaPago,
			List<Item> listaItem) {
		this.idFactura = id;
		this.idCliente = idCliente;
		this.fechaemision = fechaEmision;
		this.fechavencimiento = fechaVencimiento;
		this.fechapago = fechaPago;
		this.listaItem = listaItem;
		this.IVA = 19;
	}

	/* GET AND SET */
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int id) {
		this.idFactura = id;
	}

	public int getidCliente() {
		return idCliente;
	}

	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFechaEmision() {
		return fechaemision;
	}

	public void setFechaEmision(String fechaEmision) {
		
		this.fechaemision = Utilidades.AjustaFecha(fechaEmision);
	}

	public Date getFechaVencimiento() {
		return fechavencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechavencimiento = Utilidades.AjustaFecha(fechaVencimiento);
	}

	public Date getFechaPago() {
		return fechapago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechapago = Utilidades.AjustaFecha(fechaPago);
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
