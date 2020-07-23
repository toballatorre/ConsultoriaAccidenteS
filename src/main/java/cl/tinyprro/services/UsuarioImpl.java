package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Usuario;
import cl.tinyprro.beans.UsuarioRepositiry;

@Service
public class UsuarioImpl implements UsuarioService {

	@Autowired
	UsuarioRepositiry ur;
	
	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return ur.findOne(id);
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) ur.findAll();
	}

	@Override
	public void add(Usuario u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void edit(Usuario u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public void delete(Usuario u) {
		// TODO Auto-generated method stub
		ur.delete(u);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ur.delete(id);
	}

}
