package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Actividad;
import cl.tinyprro.beans.ActividadRepository;

@Service
public class ActividadImpl implements ActividadService {

	@Autowired
	ActividadRepository ar;
	
	@Override
	public Actividad getById(int id) {
		// TODO Auto-generated method stub
		return ar.findOne(id);
	}

	@Override
	public List<Actividad> getAll() {
		// TODO Auto-generated method stub
		return (List<Actividad>) ar.findAll();
	}

	@Override
	public void add(Actividad a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void edit(Actividad a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public void delete(Actividad a) {
		// TODO Auto-generated method stub
		ar.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ar.delete(id);
	}

}
