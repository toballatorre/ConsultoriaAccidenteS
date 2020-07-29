package cl.tinyprro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.tinyprro.beans.Pregunta;
import cl.tinyprro.beans.PreguntaRepository;

@Service
public class PreguntaImpl implements PreguntaService {

	@Autowired
	PreguntaRepository pr;
	
	@Override
	public Pregunta getById(int id) {
		// TODO Auto-generated method stub
		return pr.findOne(id);
	}

	@Override
	public List<Pregunta> getAll() {
		// TODO Auto-generated method stub
		return (List<Pregunta>) pr.findAll();
	}

	@Override
	public void add(Pregunta p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void edit(Pregunta p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public void delete(Pregunta p) {
		// TODO Auto-generated method stub
		pr.delete(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pr.delete(id);
	}

}
