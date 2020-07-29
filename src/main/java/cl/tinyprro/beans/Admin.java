package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN")
public class Admin {
	
	@Id
	@Column(name="IDEMPLEADO")
	private int id;
	private String nombre;
	@Column(name="USUARIO_IDUSUARIO")
	private int idUsuario;
	
	public Admin() {
		
	}
	
	public Admin(int id, String nombre, int idUsuario) {
		this.id = id;
		this.nombre = nombre;
		this.idUsuario = idUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
