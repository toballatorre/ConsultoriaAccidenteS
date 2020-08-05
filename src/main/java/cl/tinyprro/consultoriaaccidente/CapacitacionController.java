package cl.tinyprro.consultoriaaccidente;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Profesional;
import cl.tinyprro.services.CapacitacionService;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.ProfesionalService;

/**
 * Controller funcional con JPA
 * @author Cristobal L
 *
 */
@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@Autowired
	CapacitacionService cs;
	@Autowired
	ClienteService cls;
	@Autowired
	ProfesionalService ps;
	
	/**
	 * Muestra la Vista del menu de capacitación
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView capacitacion(Locale locale,ModelMap model) {
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
		
		
		return new ModelAndView("profesional/capacitacion");
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarCapacitacion(Locale locale,ModelMap model) {
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
		
		
		
		logger.info("Lista capacitaciones");
		
		List<Capacitacion> lista = cs.getAll();
		
		return new ModelAndView("profesional/listarCapacitaciones", "listaCap", lista);
	}
	
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleCapacitacion(@PathVariable int id,Locale locale,ModelMap model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
		Capacitacion c = cs.getById(id);
		
		return new ModelAndView("/profesional/detalleCapacitacion", "cap", c);
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.GET)
	public ModelAndView crearCapacitacion(Locale locale, ModelMap model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
		
		List<Cliente> listaCliente = cls.getAll();
		List<Profesional> listaProf = ps.getAll();
		model.addAttribute("date", date);
		model.addAttribute("c", new Capacitacion());
		
		Map<String, Object> modelo = new HashMap<String, Object>();
		modelo.put("listaClientes", listaCliente); modelo.put("listaProf", listaProf);
		
		return new ModelAndView("profesional/crearCapacitacion", "model", modelo);
	}
	
	@RequestMapping(value="/ingresar", method = RequestMethod.POST)
	public ModelAndView insertarCapacitacion(HttpServletRequest request, Locale locale, ModelMap model, Capacitacion c) {
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
	    cs.add(c);
		
		return new ModelAndView("redirect:/capacitacion/listar");
	}
}
