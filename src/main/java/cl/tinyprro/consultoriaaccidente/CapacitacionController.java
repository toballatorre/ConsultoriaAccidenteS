package cl.tinyprro.consultoriaaccidente;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Profesional;
import cl.tinyprro.services.CapacitacionService;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.ProfesionalService;

/**
 * Controller funcional con JPA
 * @author Cristobal L
 *
 */
@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@Autowired
	CapacitacionService cs;
	@Autowired
	ClienteService cls;
	@Autowired
	ProfesionalService ps;
	
	/**
	 * Muestra la Vista del menu de capacitación
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView capacitacion() {
		return new ModelAndView("profesional/capacitacion");
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarCapacitacion() {
		logger.info("Lista capacitaciones");
		
		List<Capacitacion> lista = cs.getAll();
		
		return new ModelAndView("profesional/listarCapacitaciones", "listaCap", lista);
	}
	
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleCapacitacion(@PathVariable int id) {
		
		Capacitacion c = cs.getById(id);
		
		return new ModelAndView("/profesional/detalleCapacitacion", "cap", c);
	}
	
	@RequestMapping(value="/crear", method = RequestMethod.GET)
	public ModelAndView crearCapacitacion() {
		
		List<Cliente> listaCliente = cls.getAll();
		List<Profesional> listaProf = ps.getAll();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listaClientes", listaCliente); model.put("listaProf", listaProf);
		
		return new ModelAndView("profesional/crearCapacitacion", "model", model);
	}
	
	@RequestMapping(value="/ingresar", method = RequestMethod.POST)
	public ModelAndView insertarCapacitacion(HttpServletRequest request) {

		cs.add(new Capacitacion(
				Integer.parseInt(request.getParameter("client")),
				request.getParameter("tema"),
				request.getParameter("objetivos"),
				request.getParameter("contenidos"),
				request.getParameter("recursos"),
				request.getParameter("fecha"),
				Integer.parseInt(request.getParameter("idProf"))));

		return new ModelAndView("redirect:/capacitacion/listar");
	}
}
