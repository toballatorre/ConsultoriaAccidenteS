package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Pregunta;

public interface PreguntaService {
	
	Pregunta getById(int id);
	List<Pregunta> getAll();
	void add(Pregunta p);
	void edit(Pregunta p);
	void delete(Pregunta p);
	void delete(int id);
}
