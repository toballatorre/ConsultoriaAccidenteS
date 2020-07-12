package cl.tinyprro.consultoriaaccidente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReporteAccidenteController {
	private static final Logger logger = LoggerFactory.getLogger(ReporteAccidenteController.class);

	@RequestMapping(value = "/ReporteAccidente", method = RequestMethod.GET)
	public String reporteaccidenten(Model model) {
		logger.info("estamos en ReporteAccidenteController ");
	
		
		return "cliente/ReporteAccReadCliente";
	}
	@RequestMapping(value = "/ReporteAccidenteCreate", method = RequestMethod.GET)
	public String reporteaccidentecrear(Model model) {
		logger.info("/ReporteAccidenteCreate estamos en ReporteAccidenteController ");
		
		
		return "cliente/ReporteAccCreate";
	}
	@RequestMapping(value = "/Accidentabilidad", method = RequestMethod.GET)
	public String accidentabilidad(Model model) {
		logger.info("/Accidentabilidad estamos en ReporteAccidenteController ");
		
		
		return "admin/AccidentabilidadReadAll";
	}
}
