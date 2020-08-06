package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Asesoria;
import cl.tinyprro.beans.AsesoriaRepository;

@Service
public class AsesoriaImpl  implements AsesoriaService{

	@Autowired
	AsesoriaRepository ar;
	
	
	@Override
	public Asesoria getById(int id) {
		return ar.findOne(id);
	}

	@Override
	public List<Asesoria> getAll() {
		return (List<Asesoria>) ar.findAll();
	}

	@Override
	public void add(Asesoria as) {
		ar.save(as);		
	}

	@Override
	public void edit(Asesoria as) {
		ar.save(as);
	}

	@Override
	public void delete(Asesoria as) {
		ar.delete(as);
	}

	@Override
	public void delete(int id) {
		ar.delete(id);		
	}

}
