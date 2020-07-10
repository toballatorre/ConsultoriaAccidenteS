package cl.tinyprro.consultoriaaccidente;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.tinyprro.beans.Capacitacion;


@Controller
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@RequestMapping(value = "/capacitacion", method = RequestMethod.GET)
	public String capacitacion(Locale locale, Model model) {
			logger.info("Detalles Capacitacion", locale);
			
			ApplicationContext aC = new ClassPathXmlApplicationContext("cl/tinyprro/xml/beans.xml");
			
			Capacitacion c = (Capacitacion) aC.getBean("capacitacion");
			
			model.addAttribute("id", c.getId());
			model.addAttribute("idCliente", c.getIdCliente());
			model.addAttribute("tema", c.getTema());
			model.addAttribute("objetivos", c.getTema());
			model.addAttribute("contenidos", c.getContenidos());
			model.addAttribute("recursos", c.getRecursos());
			model.addAttribute("fecha", c.getFecha());
			model.addAttribute("idUsuarioPro", c.getIdUsuarioPro());
			
		return "detalleCapacitacion";
	}
}
