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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.Usuario;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.FacturaService;
import cl.tinyprro.services.ItemService;
import cl.tinyprro.services.UsuarioService;

@Controller
public class NotificarController {
	
	@Autowired
	ClienteService cs;
	
	@Autowired
	FacturaService fs;
	
	@Autowired
	ItemService is;
	
	@Autowired
	UsuarioService us;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Map<Integer, Cliente> cliData = new HashMap<Integer, Cliente>();
	
	Map<Integer, Factura> facData = new HashMap<Integer, Factura>();
	
	/* Endpoint JSON de todos los clientes y sus datos*/
	@RequestMapping(value="/notificarAtrasos",method=RequestMethod.GET)
	public @ResponseBody List<Cliente> notificarAtrasos(Locale locale, Model model) {
		
	    List<Cliente> listaC = cs.getAll();
	    Set<Integer> listaKeys = cliData.keySet();
	    
	    for(Integer i: listaKeys) {
			listaC.add(cliData.get(i));
		}
	    
		return listaC;
	}
	
	/* Endpoint JSON de una factura por idfactura*/
	@RequestMapping(value="/notificarAtrasos/{id}",method=RequestMethod.GET)
	public @ResponseBody Factura notificarAtrasosPorId(@PathVariable int id) {
		
		Factura f = fs.getById(id);
		facData.put(f.getIdFactura(), f);
		
		return facData.get(id);
	}
	
	/* Endpoint JSON */
	@RequestMapping(value="/notificarAtrasos/MailAPI/{id}",method=RequestMethod.GET)
	public @ResponseBody ModelMap notificarAtrasosMailPorId(@PathVariable int id) {
		
		ModelMap mail = new ModelMap();
		Factura f = fs.getById(id);
		Cliente c = cs.getById(f.getidCliente());
		Usuario u = us.getById(c.getIdUsuario());
		
		String mailcliente = u.getMail();
	
		
		
		mail.addAttribute("From", "cobranza@consultoria.cl");
		mail.addAttribute("Subject", "Nos debe plata");
		mail.addAttribute("To", mailcliente);
		mail.addAttribute("Body", "Estimado Cliente "+c.getNombreEmpresa()+" , le informamos que la factura "+id+" está pendiente de pago("+f.getFechaVencimiento()+"). Por favor dirigase al portal de pago.");

		
		return mail;
	}
	
}
