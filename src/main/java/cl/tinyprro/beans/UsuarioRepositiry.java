package cl.tinyprro.beans;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositiry extends CrudRepository<Usuario, Integer>{

	//@Query(value="select idusuario from usuario where usuario='cliente'")
	Usuario findOneByUsuario(String u);	
	
}
