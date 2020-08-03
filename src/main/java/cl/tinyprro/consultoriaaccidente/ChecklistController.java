package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Checklist;
import cl.tinyprro.beans.Pregunta;
import cl.tinyprro.dao.DAOchecklist;
import cl.tinyprro.services.ChecklistService;
import cl.tinyprro.services.PreguntaService;

@Controller
@RequestMapping("/checklist")
public class ChecklistController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//********* JPA *********
	@Autowired
	ChecklistService cs;
	@Autowired
	PreguntaService ps;
	
	//******* TEMPLATE *********
	@Autowired
	DAOchecklist checklistDAO;	
	
	/**
	 * Lista todas los checklist de la base de datos
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView listarChecklist(Locale locale,ModelMap model) {
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	
	    /* Mostrar el nombre en el header */
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /listar a las {}", name, formattedDate);
		
		List<Checklist> lista = cs.getAll();
		System.out.println(lista);
		return new ModelAndView("/profesional/listaChecklist", "listaCh", lista);
	}
	/**
	 * INCOMPLETO !!! - Muestra la vista con los detalles del Checklist y la lista de preguntas
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleChecklist(@PathVariable int id,Locale locale, ModelMap model) {
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}. /detalle/{}", name, id);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
		
		Checklist ch = cs.getById(id);
		List<Pregunta> listaP = ps.getAll();// no sirve
		
		Map<String, Object> modelo = new HashMap<String, Object>();
		modelo.put("ch", ch);
		modelo.put("listaP", listaP);
		
		return new ModelAndView("/profesional/detalleChecklist", "model", modelo);
	}
	
	/**
	 * Muestra la vista con los detalles del Checklist y la lista de preguntas
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/crear", method = RequestMethod.GET)
	public ModelAndView crearChecklist(Locale locale, Model model) {
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}. /crear", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
		
		
		
		return new ModelAndView("/profesional/ChecklistCreate");
	}
	
	/**
	 * Muestra la vista con los detalles del Checklist y la lista de preguntas
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/guardarChecklist", method = RequestMethod.POST)
	public ModelAndView guardarChecklist(HttpServletRequest request,Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		model.addAttribute("username", name);
		logger.info("Usuario {}. /guardarChecklist {}", name, formattedDate);
		
		
		Checklist ch = new Checklist(
				Integer.parseInt(request.getParameter("idcliente")),
				request.getParameter("descripcion"),
				"No respondida",
				""
				);
		String mensaje ="";
		if (checklistDAO.ingresarChecklist(ch)>0) {
			logger.info("Exito DAO checklist");
			
			mensaje ="Exito";
			model.addAttribute("mensaje", mensaje);
			
			List<Checklist> lista = cs.getAll();
			
			return new ModelAndView("/profesional/listaChecklist", "listaCh", lista);
		} else {
			mensaje ="F en el chat";
			model.addAttribute("mensaje", mensaje);
			return new ModelAndView("/profesional/listaChecklist", "listaCh", model);
		}
	}
	
	/* Muestra la vista de creacion de pregunta */
	@RequestMapping(value="/crearPregunta/{id}", method = RequestMethod.GET)
	public ModelAndView crearPregunta(@PathVariable int id, Locale locale, Model model) {
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {}. /crear", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    model.addAttribute("serverTime", formattedDate );
		
		Checklist ch = cs.getById(id);
		
		Map<String, Object> modelo = new HashMap<String, Object>();
		modelo.put("ch", ch);
		
		return new ModelAndView("/profesional/PreguntaCreate", "datos", modelo);
	}
	

	@RequestMapping(value="/guardarPregunta", method = RequestMethod.POST)
	public ModelAndView guardarPregunta(HttpServletRequest request,Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		model.addAttribute("username", name);
		logger.info("Usuario {}. /guardarChecklist {}", name, formattedDate);
		
		
		Pregunta p = new Pregunta(
				Integer.parseInt(request.getParameter("idchecklist")),
				request.getParameter("pregunta")
				);
		String mensaje ="";
		
		ps.add(p);
		model.addAttribute("id", Integer.parseInt(request.getParameter("idchecklist")));
		
		return new ModelAndView("redirect:/checklist/detalle/{id}");

	}

	
	
}
