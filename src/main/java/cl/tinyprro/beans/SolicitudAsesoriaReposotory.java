package cl.tinyprro.beans;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SolicitudAsesoriaReposotory extends CrudRepository<SolicitudAsesoria, Integer>{

	List<SolicitudAsesoria> findAllByIdCliente (int idcliente);
}
