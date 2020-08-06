package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.ReporteAccidente;
import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.services.ClienteService;

/**
 * Para el Caso de uso de generar reporte cliente
 * @author Cristobal L
 *
 */
@Controller
public class ReporteClienteController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ClienteService cs;
	
	@RequestMapping("/ReporteCliente/{id}")
	public ModelAndView muestraReporteCliente(@PathVariable int id, Locale locale, Model model) {
		
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
	    Cliente c = cs.getById(id);
	    logger.info("Reporte Cliente Nº: {}", c.getId());
	    
//	    System.out.println(c.toString());
//	    		
//		System.out.println("========== ACCIDENTES ============");
//		System.out.println("TAMAÑO LISTA: " + c.getListaAccidentes().size());
//		Set<ReporteAccidente> listaR = c.getListaAccidentes();
//		for (ReporteAccidente ra : listaR) { 
//			System.out.println(ra.toString());
//		}
//		 
//	    System.out.println("========== SOLICITUD ASESORIA ============");
//	    
//	    System.out.println("TAMAÑO LISTA: " + c.getListaAsesoriaE().size());
//	    Set<SolicitudAsesoria> listaSA = c.getListaAsesoriaE();
//	    for (SolicitudAsesoria sa : listaSA) {
//			System.out.println(sa.toString());
//		}
//	    
//	    System.out.println("========== CAPACITACIONES ============");
//	    System.out.println("TAMAÑO LISTA: " + c.getListaCapacitaciones().size());
//	    Set<Capacitacion> listaC = c.getListaCapacitaciones();
//	    for (Capacitacion cap : listaC) {
//			System.out.println(cap.toString());
//		}
//	    
//	    System.out.println("========== FACTURAS ============");
//	    Set<Factura> listaF = c.getListaFacturas();
//	    System.out.println("TAMAÑO LISTA: " + listaF.size());
//	    for (Factura f : listaF) {
//			System.out.println(f.toString());
//		}
	    model.addAttribute("date", date);
	    
		return new ModelAndView("admin/ReporteCliente", "c", c);
	}
}
