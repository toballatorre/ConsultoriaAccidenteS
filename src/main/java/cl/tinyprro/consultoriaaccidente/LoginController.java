package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

		
	@RequestMapping(value = "/haceLogin", method = RequestMethod.POST)
	public String hacelogin(Locale locale, Model model, HttpServletRequest request) {
		
		logger.info("Haciendo login- U: " + request.getParameter("Usuario") + "  P: "+ request.getParameter("Password"), locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		
		String user = request.getParameter("Usuario");
		String pass = request.getParameter("Password");
		
		/*Login provisional, sin conexion a DB*/
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
		/*Fin login mula*/
	}
	@RequestMapping(value = "/AreaAdmin", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		
		logger.info("estamos en AreaAdmin", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "AreaAdmin";
	}
	
	@RequestMapping(value="/AreaCliente", method = RequestMethod.GET)
	public String areacliente(Locale locale,Model model) {
		
		logger.info("estamos en AreaClienteController");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "AreaCliente";
	}
	
	@RequestMapping(value="/AreaProfesional", method = RequestMethod.GET)
	public String areaprofesional(Locale locale,Model model) {
		
		logger.info("estamos en AreaProfesionalController");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "AreaProfesional";
	}
}
