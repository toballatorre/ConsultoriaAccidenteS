package cl.tinyprro.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

/* ATRIBUTOS */
	@Id
	@Column(name="IDUSUARIO")
	private int id;
	@Column(name="USUARIO")
	private String usuario;
	@Column(name="TIPOUSUARIO")
	private String tipousuario;
	@Column(name="CLAVE")
	private String clave;
	@Column(name="MAIL")
	private String mail;
	@Column(name="ACTIVO")
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", tipousuario=" + tipousuario + ", mail=" + mail
				+ ", activo=" + activo + "]";
	}


}

