package cl.tinyprro.consultoriaaccidente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AreaProfesionalController {
	private static final Logger logger = LoggerFactory.getLogger(AreaProfesionalController.class);

	@RequestMapping(value="/AreaProfesional", method = RequestMethod.GET)
	public String areaprofesional(Model model) {
		logger.info("estamos en AreaProfesionalController");
		
		return "AreaProfesional";
	}
	

}
