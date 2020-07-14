package cl.tinyprro.consultoriaaccidente;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.tinyprro.beans.Capacitacion;


@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String capacitacion() {
		System.out.println("Voy a capacitacion");
		return "profesional/capacitacion";
	}
	
	@RequestMapping(value="/crear")
	public String crearCapacitacion() {
		System.out.println("Voy a capacitacion");
		return "profesional/crearCapacitacion";
	}
	
	
	@RequestMapping(value = "/detalle", method = RequestMethod.POST)
	public String capacitacion(Locale locale, Model model, HttpServletRequest request) {
			logger.info("Detalles Capacitacion", locale);
			
			ApplicationContext aC = new ClassPathXmlApplicationContext("cl/tinyprro/xml/beans.xml");
			
			Capacitacion c = (Capacitacion) aC.getBean("capacitacion");
			
			c.setId(Integer.parseInt(request.getParameter("idCap")));
			c.setFecha(request.getParameter("fecha"));
			c.setTema(request.getParameter("tema"));
			c.setIdCliente(Integer.parseInt(request.getParameter("client")));
			c.setObjetivos(request.getParameter("objetivos"));
			c.setContenidos(request.getParameter("contenidos"));
			c.setRecursos(request.getParameter("recursos"));
			c.setIdUsuarioPro(Integer.parseInt(request.getParameter("idProf")));
			
			model.addAttribute("cap", c);
			
			((ConfigurableApplicationContext)aC).close();
			
		return "profesional/detalleCapacitacion";
	}
	
}
