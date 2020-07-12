package cl.tinyprro.consultoriaaccidente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SolicitudAsesoriaController {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudAsesoriaController.class);

	@RequestMapping(value = "/SolicitudAsesoria", method = RequestMethod.GET)
	public String solicitudasesoria(Model model) {
		logger.info("/SolicitudAsesoria estamos en SolicitudAsesoriaController");
	
		
		return "cliente/SolicitudAsesoriaReadAll";
	}
	@RequestMapping(value = "/SolicitudAsesoriaCreate", method = RequestMethod.GET)
	public String solicitudasesoriacrear(Model model) {
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController");
		
		
		return "cliente/SolicitudAsesoriaCreate";
	}
	
}
