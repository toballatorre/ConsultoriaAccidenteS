package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Capacitacion;

public interface CapacitacionService {

	Capacitacion getById(int id);
	List<Capacitacion> getAll();
	void add(Capacitacion c);
	void edit(Capacitacion c);
	void delete(Capacitacion c);
	void delete(int id);
	
}
