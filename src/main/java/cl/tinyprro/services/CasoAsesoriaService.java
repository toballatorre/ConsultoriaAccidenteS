package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.CasoAsesoria;

public interface CasoAsesoriaService {

	CasoAsesoria getById(int id);
	List<CasoAsesoria> getAll();
	void add(CasoAsesoria ca);
	void edit(CasoAsesoria ca);
	void delete(CasoAsesoria ca);
	void delete(int id);
	
}
