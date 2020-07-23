package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Profesional;
import cl.tinyprro.beans.ProfesionalRepository;

@Service
public class ProfesionalImpl implements ProfesionalService {

	@Autowired
	ProfesionalRepository pr;
	
	@Override
	public Profesional getById(int id) {
		// TODO Auto-generated method stub
		return pr.findOne(id);
	}

	@Override
	public List<Profesional> getAll() {
		// TODO Auto-generated method stub
		return (List<Profesional>)pr.findAll();
	}

	@Override
	public void add(Profesional p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void edit(Profesional p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void delete(Profesional p) {
		// TODO Auto-generated method stub
		pr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pr.delete(id);
	}

}
