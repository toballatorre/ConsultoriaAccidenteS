package cl.tinyprro.beans;


public class Capacitacion {
	
	/* ATRIBUTOS */
	private int id;
	private int idCliente;
	private String tema;
	private String objetivos;
	private String contenidos;
	private String recursos;
	private String fecha;
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
