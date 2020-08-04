package cl.tinyprro.services;

import java.util.List;

import cl.tinyprro.beans.SolicitudAsesoria;

public interface SolicitudAsesoriaService {
	
	SolicitudAsesoria getById(int id);
	List<SolicitudAsesoria> getAll();
	void add(SolicitudAsesoria sa);
	void edit(SolicitudAsesoria sa);
	void delete(SolicitudAsesoria sa);
	void delete(int id);
	List<SolicitudAsesoria> getByIdCliente(int idcliente);
	
}
