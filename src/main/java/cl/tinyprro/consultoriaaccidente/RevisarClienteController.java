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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Usuario;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.UsuarioService;

@Controller
@RequestMapping("/revisarCliente")
public class RevisarClienteController {
	private static final Logger logger = LoggerFactory.getLogger(SolicitudAsesoriaController.class);
	
	@Autowired
	ClienteService cs;
	@Autowired
	UsuarioService us;
	
	@RequestMapping("/listar")
	public ModelAndView listarClientes(Locale locale, Model model, HttpServletRequest request){
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
		
	    /* COntroller */
		List<Cliente> listaClientes = cs.getAll();
		
		return new ModelAndView("profesional/listarClientes", "listaClientes", listaClientes);
	}
	
	@RequestMapping("/detalle/{id}")
	public ModelAndView revisarClientes(@PathVariable int id, Locale locale, Model model, HttpServletRequest request) {
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
		
		Cliente c = cs.getById(id);
		Usuario u = us.getById(c.getIdUsuario());
		
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("c", c);
		m.put("u", u);
		
		return new ModelAndView("profesional/revisarCliente", "m", m);
	}
}
