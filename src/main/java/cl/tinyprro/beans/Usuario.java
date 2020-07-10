package cl.tinyprro.beans;

public class Usuario {

/* ATRIBUTOS */
	private int id;
	private String usuario;
	private String tipousuario;
	private String clave;
	private String mail;
	private String activo;

	
/*bob el CONSTRUCTOR */
	public Usuario() {
		super();
	}

	/*SIN id*/
	public Usuario(String usuario, String tipousuario, String clave, String mail, String activo) {
		super();
		this.usuario = usuario;
		this.tipousuario = tipousuario;
		this.clave = clave;
		this.mail = mail;
		this.activo = activo;
	}
	/* todos */
	public Usuario(int id, String usuario, String tipousuario, String clave, String mail, String activo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.tipousuario = tipousuario;
		this.clave = clave;
		this.mail = mail;
		this.activo = activo;
	}

/*GET SET, yo solo quiero ser del jet set*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	
		
}

