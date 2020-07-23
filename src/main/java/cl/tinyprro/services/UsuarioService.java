package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Usuario;

public interface UsuarioService {
	
	Usuario getById(int id);
	List<Usuario> getAll();
	void add(Usuario u);
	void edit(Usuario u);
	void delete(Usuario u);
	void delete(int id);
	
}
