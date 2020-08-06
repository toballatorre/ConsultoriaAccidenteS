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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Asesoria;
import cl.tinyprro.beans.CasoAsesoria;
import cl.tinyprro.beans.Checklist;
import cl.tinyprro.services.AsesoriaService;
import cl.tinyprro.services.CasoAsesoriaService;

@Controller
@RequestMapping("/CasoAsesoria")
public class CasoAsesoriaController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CasoAsesoriaService cas;
	
	@Autowired
	AsesoriaService as;
	
		
	@RequestMapping(value="/leer", method = RequestMethod.GET)
	public ModelAndView leerCasosAsesoriaTodos(Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/leer {}", name, formattedDate);
		
		List<CasoAsesoria> listaCA = cas.getAll();
		
		return new ModelAndView("/profesional/CasoAsesoriaReadAll", "listaCA", listaCA);
	}
	
	
	@RequestMapping(value="/crear", method = RequestMethod.GET)
	public ModelAndView crearCasoAsesoria(Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/crear {}", name, formattedDate);
		
			
		return new ModelAndView("/profesional/CasoAsesoriaCreate");
	}
	
	
	@RequestMapping(value="/saveCaso", method = RequestMethod.POST)
	public ModelAndView guardarCaso(HttpServletRequest request,Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/saveCaso {}", name, formattedDate);
		
		
		CasoAsesoria ca = new CasoAsesoria(
				Integer.parseInt(request.getParameter("idcliente")),
				request.getParameter("codcontrato"),
				request.getParameter("plan"),
				request.getParameter("contacto"),
				request.getParameter("activo")
				);
		
		cas.add(ca);
		List<CasoAsesoria> listaCA = cas.getAll();
		
		return new ModelAndView("/profesional/CasoAsesoriaReadAll", "listaCA", listaCA);
	}
	
	/* Leer las asesorias de un caso especifico*/
	@RequestMapping(value="/leer/{id}", method = RequestMethod.GET)
	public ModelAndView leerAsesoriasByCaso(@PathVariable int id,Locale locale, ModelMap model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/leer/id  - {}", name, formattedDate);
		
		CasoAsesoria ca = cas.getById(id);
		List<Asesoria> la = ca.getListaAs();

		Map<String, Object> modelo = new HashMap<String, Object>();
		modelo.put("caso", ca);
		modelo.put("asesorias", la);
				
		return new ModelAndView("/profesional/AsesoriasReadById", "modelo", modelo);
	}
	
	@RequestMapping(value="/crearasesoria/{id}", method = RequestMethod.GET)
	public ModelAndView crearAsesoriaForm(@PathVariable int id,Locale locale, ModelMap model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/crearasesoria/  - {}", name, formattedDate);
		
		model.addAttribute("idcaso", id);
		
		return new ModelAndView("/profesional/AsesoriasCreate");
	}
	@RequestMapping(value="/saveAsesoria", method = RequestMethod.POST)
	public ModelAndView guardarAsesoria(HttpServletRequest request,Locale locale, Model model) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		logger.info("Usuario {}. /CasoAsesoria/saveAsesoria  - {}", name, formattedDate);
		
		
		Asesoria a = new Asesoria(
				Integer.parseInt(request.getParameter("idcaso")),
				request.getParameter("fecha"),
				request.getParameter("idempleado"),
				request.getParameter("lugar"),
				request.getParameter("comentarios")
				);
		
		as.add(a);
		
		model.addAttribute("id", a.getIdcaso());
		
		return new ModelAndView("redirect:/CasoAsesoria/leer/{id}");

	}
		
	@RequestMapping(value="/leerAsesoriaAPI/{id}", method = RequestMethod.GET)
	public @ResponseBody Asesoria leerAsesoriaAPI (@PathVariable int id) {
		
		Asesoria a = as.getById(id);
		
		return a;
	}
	@RequestMapping(value="/saveAsesoriaAPI", method = RequestMethod.POST)
	public @ResponseBody Asesoria guardarAsesoriaAPI (@RequestBody Asesoria a) {
		
		Map<Integer, Asesoria> asData = new HashMap<Integer, Asesoria>();
		
		asData.put(a.getIdasesoria(), a);
		
		as.add(a);
		
		return a;
	}
	
}
