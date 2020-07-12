package cl.tinyprro.consultoriaaccidente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@RequestMapping(value = "/Usuarios", method = RequestMethod.GET)
	public String usuarios(Model model) {
		logger.info("/Usuarios @UsuarioController ");
	
		
		return "admin/UsuarioReadAll";
	}
	@RequestMapping(value = "/Clientes", method = RequestMethod.GET)
	public String clientes(Model model) {
		logger.info("/Clientes @UsuarioController ");
		
		
		return "admin/ClienteReadAll";
	}
	
	
}
