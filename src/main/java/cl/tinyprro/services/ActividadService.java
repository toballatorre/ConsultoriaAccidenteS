package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Actividad;

public interface ActividadService {
	
	Actividad getById(int id);
	List<Actividad> getAll();
	void add(Actividad a);
	void edit(Actividad a);
	void delete(Actividad a);
	void delete(int id);
	
}
