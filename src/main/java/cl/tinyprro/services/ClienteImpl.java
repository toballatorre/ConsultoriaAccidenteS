package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.ClienteRepositiry;

@Service
public class ClienteImpl implements ClienteService {

	@Autowired
	ClienteRepositiry cr;
	
	@Override
	public Cliente getById(int id) {
		// TODO Auto-generated method stub
		return cr.findOne(id);
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) cr.findAll();
	}

	@Override
	public void add(Cliente c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public void edit(Cliente c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public void delete(Cliente c) {
		// TODO Auto-generated method stub
		cr.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cr.delete(id);
	}

	@Override
	public Cliente getByUsuario_idusuario(int c) {
		// TODO Auto-generated method stub
		return cr.findOneByIdUsuario(c);
	}

}
