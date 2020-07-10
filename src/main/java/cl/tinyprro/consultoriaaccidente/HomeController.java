package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.tinyprro.beans.Persona;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Bienvenido al home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		
		ApplicationContext aC = new ClassPathXmlApplicationContext("cl/tinyprro/xml/beans.xml");
		
		Persona p = (Persona) aC.getBean("persona");

		//Persona p = new Persona("tobal", "latorre", 34);
		
		model.addAttribute("nombre", p.getNombre() );
		model.addAttribute("apellido", p.getApellido() );
		model.addAttribute("edad", p.getEdad() );
		
		
		return "home";
	}
	
}
