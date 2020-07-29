package cl.tinyprro.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHECKLIST")
public class Checklist {
	/* ATRIBUTOS */
	@Id
	@Column(name="IDCHECKLIST")
	private int id;
	@Column(name="CLIENTE_IDCLIENTE")
	private int idCliente;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="STATUS")
	private String status;
	@Column(name="COMENTARIOS")
	private String comentarios;
	
	public Checklist() {
		
	}
	public Checklist(int id, int idCliente, String descripcion, String status, String comentarios) {
		this.id = id;
		this.idCliente = idCliente;
		this.descripcion = descripcion;
		this.status = status;
		this.comentarios = comentarios;
	}
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString() {
		return "Checklist [id=" + id + ", idCliente=" + idCliente + ", descripcion=" + descripcion + ", status="
				+ status + ", comentarios=" + comentarios + "]";
	}
}
