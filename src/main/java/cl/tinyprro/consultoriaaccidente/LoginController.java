package cl.tinyprro.consultoriaaccidente;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/AreaAdmin", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("estamos en AreaAdmin", locale);
	
		
		return "AreaAdmin";
	}
	
	@RequestMapping(value="/AreaCliente", method = RequestMethod.GET)
	public String areacliente(Model model) {
		logger.info("estamos en AreaClienteController");
		
		return "AreaCliente";
	}
	@RequestMapping(value="/AreaProfesional", method = RequestMethod.GET)
	public String areaprofesional(Model model) {
		logger.info("estamos en AreaProfesionalController");
		
		return "AreaProfesional";
	}
}
