package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.services.ClienteService;

@Controller
public class NotificarController {
	
	@Autowired
	ClienteService cs;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Map<Integer, Cliente> cliData = new HashMap<Integer, Cliente>();
	
	@RequestMapping(value="/notificarAtrasos",method=RequestMethod.GET)
	public @ResponseBody List<Cliente> notificarAtrasos(Locale locale, Model model) {
		
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
	    List<Cliente> listaC = cs.getAll();
	    Set<Integer> listaKeys = cliData.keySet();
	    
	    for(Integer i: listaKeys) {
			listaC.add(cliData.get(i));
		}
	    
		return listaC;
	}
	
}
