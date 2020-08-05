package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.SolicitudAsesoriaService;
import cl.tinyprro.services.UsuarioService;

/**
 * Solicitud Asesoria funcionando con JPA
 * @author Cristobal L
 *
 */
@Controller
public class SolicitudAsesoriaController {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudAsesoriaController.class);
	
	@Autowired
	SolicitudAsesoriaService sas;
	
	@Autowired
	UsuarioService us;
	
	@Autowired
	ClienteService cs;

	
	/**
	 * Muestra la Vista de las asesorías listadas
	 * @return
	 */
	@RequestMapping(value = "/SolicitudAsesoria", method = RequestMethod.GET)
	public ModelAndView listarAsesorias(HttpServletRequest request,ModelMap model, Locale locale) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    
	    /*Controlador*/
		
		int idusuario =us.getByUsuario(name).getId();
		int idcliente =cs.getByUsuario_idusuario(idusuario).getId();
		
		logger.info("idUsuario {}", idusuario );
		logger.info("idCliente {}", idcliente );
		

		
		List<SolicitudAsesoria> listaS = sas.getByIdCliente(idcliente);

		
		return new ModelAndView("cliente/SolicitudAsesoriaReadAll", "listaS", listaS);
	}
	
	/**
	 * Muestra la Vista del formulario para crear una Solicitud de Asesoria
	 * @return
	 */
	@RequestMapping(value = "/SolicitudAsesoriaCreate", method = RequestMethod.GET)
	public ModelAndView crearSolicitud(HttpServletRequest request,ModelMap model, Locale locale) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    /*Controlador*/
	    int idusuario =us.getByUsuario(name).getId();
		int idcliente =cs.getByUsuario_idusuario(idusuario).getId();
		
		logger.info("idUsuario {}", idusuario );
		logger.info("idCliente {}", idcliente );
		
		model.addAttribute("idcliente",idcliente);
		model.addAttribute("sa", new SolicitudAsesoria());	
		model.addAttribute("date", date);
		
		return new ModelAndView("cliente/SolicitudAsesoriaCreate");
	}
	
	@RequestMapping(value = "/ingresarAsesoria", method = RequestMethod.POST)
	public ModelAndView ingresarSolicitud(HttpServletRequest request, ModelMap model, Locale locale, SolicitudAsesoria sa) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    /*Controlador*/
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController Ingresar Asesoria");
		
		sas.add(sa);
		System.out.println(sa.toString());
					
		return new ModelAndView("redirect:/SolicitudAsesoria");
	}

	/* Vista profesional - listar todas las solicitudes de asesoria*/
	@RequestMapping(value = "/ProSolicitudAsesoria", method = RequestMethod.GET)
	public ModelAndView proListarAsesorias(HttpServletRequest request,ModelMap model, Locale locale) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    
	    /*Controlador*/
		
		int idusuario =us.getByUsuario(name).getId();
			
		logger.info("idUsuario {}", idusuario );

		

		
		List<SolicitudAsesoria> listaS = sas.getAll();

		
		return new ModelAndView("profesional/PlanVisitaVerTodas", "listaS", listaS);
	}
	
	@RequestMapping(value="/ProAgendarEdit/{id}", method = RequestMethod.GET)
	public ModelAndView proAgendarEdit(@PathVariable int id, Locale locale, ModelMap model, HttpServletRequest request) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    
	    /*Controlador*/
		
		SolicitudAsesoria sa = sas.getById(id);
		
		return new ModelAndView("/profesional/PlanVisitaEditar", "sa", sa);
	}
	
	@RequestMapping(value="/ProAgendarSave", method = RequestMethod.POST)
	public ModelAndView proAgendarSave(HttpServletRequest request, Locale locale, Model model, SolicitudAsesoria sa) {
		/*Rescata fecha hora actual*/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	    model.addAttribute("username", name);
	    String url = request.getRequestURL().toString();
	    logger.info("Usuario {} en {}", name, url);
	    
	    /*Controlador*/
		/*
		 * SolicitudAsesoria s = new SolicitudAsesoria(
		 * Integer.parseInt(request.getParameter("idsolicitud")),
		 * request.getParameter("fechasolicitud"), request.getParameter("motivo"),
		 * request.getParameter("preferenciahorario"),
		 * Integer.parseInt(request.getParameter("idcliente")),
		 * request.getParameter("status"), request.getParameter("fechaagenda"),
		 * request.getParameter("lugar"), request.getParameter("contacto"),
		 * request.getParameter("detalle") );
		 */
		/*
		 * SolicitudAsesoria s =
		 * sas.getById(Integer.parseInt(request.getParameter("idsolicitud")));
		 * s.setFechaagenda(request.getParameter("fechaagenda"));
		 * s.setContacto(request.getParameter("contacto"));
		 * s.setLugar(request.getParameter("lugar"));
		 * s.setDetalle(request.getParameter("detalle"));
		 * s.setStatus(request.getParameter("status"));
		 * 
		 * System.out.println(s.getId()); System.out.println(s.getFechasolicitud());
		 * System.out.println(s.getMotivo());
		 * System.out.println(s.getPreferenciaHorario());
		 * System.out.println(s.getIdCliente()); System.out.println(s.getStatus());
		 * System.out.println(s.getFechaagenda()); System.out.println(s.getLugar());
		 * System.out.println(s.getContacto()); System.out.println(s.getDetalle());
		 * sas.edit(s);
		 */
	    
	    System.out.println("EL EDITADO: " + sa.toString());
		sas.edit(sa);
		//List<SolicitudAsesoria> listaS = sas.getAll();
		
		//return new ModelAndView("redirect:/profesional/ProSolicitudAsesoria", "listaS", listaS);
	    return new ModelAndView("redirect: ProSolicitudAsesoria");
	}
	
	
	
	
}
