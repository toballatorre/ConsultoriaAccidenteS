package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.CapacitacionRepository;

@Service
public class CapacitacionImpl implements CapacitacionService {

	@Autowired
	CapacitacionRepository cr;
	
	@Override
	public Capacitacion getById(int id) {
		// TODO Auto-generated method stub
		return cr.findOne(id);
	}

	@Override
	public List<Capacitacion> getAll() {
		// TODO Auto-generated method stub
		return (List<Capacitacion>) cr.findAll();
	}

	@Override
	public void add(Capacitacion c) {
		// TODO Auto-generated method stub
		cr.save(c);

	}

	@Override
	public void edit(Capacitacion c) {
		// TODO Auto-generated method stub
		cr.save(c);

	}

	@Override
	public void delete(Capacitacion c) {
		// TODO Auto-generated method stub
		cr.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cr.delete(id);
	}

}
