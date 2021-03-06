package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.ReporteAccidente;
import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.services.ClienteService;

/**
 * Para el Caso de uso de generar reporte cliente
 * @author Cristobal L
 *
 */
@Controller
public class ReporteClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ClienteService cs;
	
	@RequestMapping("/ReporteCliente/{id}")
	public ModelAndView muestraReporteCliente(@PathVariable int id, Locale locale, Model model) {
		
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
		
	    /* CONTROLLER */
	    Cliente c = cs.getById(id);
	    logger.info("Reporte Cliente N�: {}", c.getId());
	    
	    model.addAttribute("date", date);
	    
		return new ModelAndView("admin/ReporteCliente", "c", c);
	}
}
