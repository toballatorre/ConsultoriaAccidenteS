package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@RequestMapping("/login")
	public String login() {
		System.out.println("Ingreso a login");
		return "login";
	}

	@RequestMapping("/error")
	public String error(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username

	      model.addAttribute("username", name);
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}


	@RequestMapping(value = "/AreaAdmin", method = RequestMethod.GET)
	public String logina(Locale locale, Model model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /AreaAdmin.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
		
		return "AreaAdmin";
	}
	
	@RequestMapping(value="/AreaCliente", method = RequestMethod.GET)
	public String areacliente(Locale locale,Model model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /AreaCliente.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/

	      model.addAttribute("username", name);
		
		return "AreaCliente";
	}
	
	@RequestMapping(value="/AreaProfesional", method = RequestMethod.GET)
	public String areaprofesional(Locale locale,Model model) {
		/* Rescata nombre usuario logeado y muestra en header y log4j*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /AreaProfesional.", name);
	    
	    /*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /*Controlador*/
	    model.addAttribute("username", name);
		
		return "AreaProfesional";
	}
}

/* LOGIN MULA
@RequestMapping(value = "/haceLogin", method = RequestMethod.POST)
public String hacelogin(Locale locale, Model model, HttpServletRequest request) {
	
	logger.info("Haciendo login- U: " + request.getParameter("Usuario") + "  P: "+ request.getParameter("Password"), locale);
	Date date = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	String formattedDate = dateFormat.format(date);
	model.addAttribute("serverTime", formattedDate );
	
	
	String user = request.getParameter("Usuario");
	String pass = request.getParameter("Password");
	
	
	if (user.equals("cliente")) {
		model.addAttribute("tipoUsuario", "cliente");
		return "AreaCliente";	
	} else if (user.equals("admin")){
		model.addAttribute("tipoUsuario", "admin");
		return "AreaAdmin";
	} else {
		model.addAttribute("tipoUsuario", "profesional");
		return "AreaProfesional";
	}
	
}Fin login mula*/