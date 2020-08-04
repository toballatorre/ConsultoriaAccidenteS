package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.Item;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.FacturaService;
/**
 * Controlles de la factura para el CU control de pagos
 * @author Cristobal L
 *
 */
@Controller
@RequestMapping(value = "/factura")
public class FacturaController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	FacturaService fs;
	@Autowired
	ClienteService cls;
	
	/**
	 * Lista todas las facturas existentes
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/listarFaturas", method = RequestMethod.GET)
	public ModelAndView leerFacturas(Locale locale, Model model) {
		
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


		List<Factura> listaFacturas = fs.getAll();
		for (Factura factura : listaFacturas) {
			logger.debug(factura.toString());
		}


		return new ModelAndView("admin/controlPagos", "listaFacturas", listaFacturas);
	}
	
	/**
	 * Muestra la vista con los detalles de la factura seleccionada
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleFactura(Locale locale, Model model, @PathVariable int id) {
		/*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	
	    /* Mostrar el nombre en el header */
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /Detalle a las {}", name, formattedDate);
		
		Factura f = fs.getById(id);
		logger.info(f.toString());
		List<Item> li = f.getListaItem();
		for (Item i : li) {
			logger.info("ITEM: {}",i.toString());
		}
		
		return new ModelAndView("/admin/detalleFactura", "f", f);
	}
	
	/**
	 * Muestra la vista del formulario para crear una factura
	 * @return
	 */
	@RequestMapping(value="/formularioFactura", method = RequestMethod.GET)
	public ModelAndView crearFactura(Locale locale, Model model) {
		/*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	
	    /* Mostrar el nombre en el header */
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /formularioFacturaGET a las {}", name, formattedDate);
		
		Factura factura = new Factura();
		List<Cliente> listaCliente = cls.getAll();
		model.addAttribute("date", date);
	    logger.info("DATE: {}", date);
	
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("factura",factura);
		m.put("listaC", listaCliente);
		
		return new ModelAndView("admin/formularioFactura", "model", m);
	}
	
	/**
	 * Agrega la factura a la base de datos
	 * @param locale
	 * @param model
	 * @param f
	 * @return
	 */
	@RequestMapping(value="/formularioFactura", method = RequestMethod.POST)
	public ModelAndView crearFactura(Locale locale, Model model, Factura f) {
		/*Rescata fecha hora actual*/
	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    
	    /* Mostrar el nombre en el header */
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    logger.info("Usuario {} en /formularioFacturaPOST a las {}", name, formattedDate);
			    
		fs.add(f);
		
		return new ModelAndView("redirect: listarFaturas");
	}

}
