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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView listarAsesorias(ModelMap model, Locale locale) {
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
		logger.info("/SolicitudAsesoria estamos en SolicitudAsesoriaController, listarAsesorias");
		
		int idusuario =us.getByUsuario(name).getId();
		int idcliente =cs.getByUsuario_idusuario(idusuario).getId();
		
		System.out.println("idUsuario: "+idusuario);
		System.out.println("idCliente: "+idcliente);
		
		
		List<SolicitudAsesoria> listaS = sas.getByIdCliente(idcliente);

		
		return new ModelAndView("cliente/SolicitudAsesoriaReadAll", "listaS", listaS);
	}
	
	/**
	 * Muestra la Vista del formulario para crear una Solicitud de Asesoria
	 * @return
	 */
	@RequestMapping(value = "/SolicitudAsesoriaCreate", method = RequestMethod.GET)
	public ModelAndView crearSolicitud(ModelMap model, Locale locale) {
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
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController Formulario crear");

		return new ModelAndView("cliente/SolicitudAsesoriaCreate");
	}
	
	@RequestMapping(value = "/ingresarAsesoria", method = RequestMethod.POST)
	public ModelAndView ingresarSolicitud(HttpServletRequest request, ModelMap model, Locale locale) {
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
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController Ingresar Asesoria");
		
		sas.add(new SolicitudAsesoria( 
				request.getParameter("fechasolicitud"),
				request.getParameter("motivo"),
				request.getParameter("preferenciaHorario"),
				Integer.parseInt(request.getParameter("idCliente")),
				request.getParameter("status")
				));
				
		return new ModelAndView("redirect:/SolicitudAsesoria");
	}

}
