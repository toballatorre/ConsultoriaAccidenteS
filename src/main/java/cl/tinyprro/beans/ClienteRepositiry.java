package cl.tinyprro.beans;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositiry extends CrudRepository<Cliente, Integer>{

	Cliente findOneByIdUsuario(int c);
	
}
