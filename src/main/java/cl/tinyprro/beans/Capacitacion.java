package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="capacitacion")
public class Capacitacion {
	
	/* ATRIBUTOS */
	@Id
	@Column(name="IDCAPACITACION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cap_seq")
	@SequenceGenerator(name = "Cap_seq", sequenceName = "CAPACITACION_SEQ1")
	private int id;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	@Column(name="TEMA")
	private String tema;
	@Column(name="OBJETIVOS")
	private String objetivos;
	@Column(name="CONTENIDOS")
	private String contenidos;
	@Column(name="RECURSOS")
	private String recursos;
	@Column(name="FECHA")
	private String fecha;
	@Column(name="IDUSUARIOPRO")
	private int idUsuarioPro;
	
	/* CONSTRUCTORES */
	public Capacitacion() {
	}
	
	// Todos los atributos
	public Capacitacion(int id, int idCliente, String tema, String objetivos, String contenidos, String recursos,
			String fecha, int idUsuarioPro) {
		this.id = id;
		this.idCliente = idCliente;
		this.tema = tema;
		this.objetivos = objetivos;
		this.contenidos = contenidos;
		this.recursos = recursos;
		this.fecha = fecha;
		this.idUsuarioPro = idUsuarioPro;
	}
	
	// Sin su identificador	
	public Capacitacion(int idCliente, String tema, String objetivos, String contenidos, String recursos,
			String fecha, int idUsuarioPro) {
		this.idCliente = idCliente;
		this.tema = tema;
		this.objetivos = objetivos;
		this.contenidos = contenidos;
		this.recursos = recursos;
		this.fecha = fecha;
		this.idUsuarioPro = idUsuarioPro;
	}

	/* GET AND SET */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getObjetivos() {
		return objetivos;
	}
	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}
	public String getContenidos() {
		return contenidos;
	}
	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}
	public String getRecursos() {
		return recursos;
	}
	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdUsuarioPro() {
		return idUsuarioPro;
	}
	public void setIdUsuarioPro(int idUsuarioPro) {
		this.idUsuarioPro = idUsuarioPro;
	}
	
	
	
}
