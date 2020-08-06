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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.services.ClienteService;

@Controller
@RequestMapping("/ReporteGlobal")
public class ReporteGlobal {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ClienteService cs;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView reporteGlobal(Locale locale, Model model, HttpServletRequest request) {
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
	    
	    /* Controller */
		List<Cliente> listaC = cs.getAll();
		
		model.addAttribute("date", date);
		
		return new ModelAndView("admin/ReporteGlobal", "listaC", listaC);
	}
	
}
