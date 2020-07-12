package cl.tinyprro.consultoriaaccidente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AreaClienteController {
	private static final Logger logger = LoggerFactory.getLogger(AreaClienteController.class);

	@RequestMapping(value="/AreaCliente", method = RequestMethod.GET)
	public String areacliente(Model model) {
		logger.info("estamos en AreaClienteController");
		
		return "AreaCliente";
	}
	
}
