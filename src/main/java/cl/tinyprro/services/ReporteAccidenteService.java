package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.ReporteAccidente;

public interface ReporteAccidenteService {

	ReporteAccidente getById(int id);
	List<ReporteAccidente> getAll();
	//List<ReporteAccidente> getAllId(int id); //
	void add(ReporteAccidente r);
	void edit(ReporteAccidente r);
	void delete(ReporteAccidente r);
	void delete(int id);
	
}
