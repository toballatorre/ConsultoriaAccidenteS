package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.Asesoria;

public interface AsesoriaService {

	Asesoria getById(int id);
	List<Asesoria> getAll();
	void add(Asesoria as);
	void edit(Asesoria as);
	void delete(Asesoria as);
	void delete(int id);
	
}
