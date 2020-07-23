package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Profesional;

public interface ProfesionalService {
	
	Profesional getById(int id);
	List<Profesional> getAll();
	void add(Profesional p);
	void edit(Profesional p);
	void delete(Profesional p);
	void delete(int id);
	
}
