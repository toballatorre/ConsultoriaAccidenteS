package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Cliente;

public interface ClienteService {

	Cliente getById(int id);
	List<Cliente> getAll();
	void add(Cliente c);
	void edit(Cliente c);
	void delete(Cliente c);
	void delete(int id);
	Cliente getByUsuario_idusuario(int idusuario);
}
