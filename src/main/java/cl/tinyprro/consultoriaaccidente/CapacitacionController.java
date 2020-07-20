package cl.tinyprro.consultoriaaccidente;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Capacitacion;
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Profesional;
import cl.tinyprro.dao.DAOcapacitacion;
import cl.tinyprro.dao.DAOclientes;
import cl.tinyprro.dao.DAOprofesional;


@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@Autowired
	DAOcapacitacion capacitacionDAO;
	@Autowired
	DAOclientes clientesDAO;
	@Autowired
	DAOprofesional profesionalDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String capacitacion() {
		System.out.println("Voy a capacitacion");
		return "profesional/capacitacion";
	}
	
	@RequestMapping(value="/crear")
	public ModelAndView crearCapacitacion() {
		
		List<Cliente> listaClientes = clientesDAO.buscarTodosClientes();
		List<Profesional> listaProf = profesionalDAO.listarTodos();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listaClientes", listaClientes);
		model.put("listaProf", listaProf);
		
		return new ModelAndView("profesional/crearCapacitacion", "model", model);
	}
	
	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public ModelAndView capacitacion(Locale locale, Model model, HttpServletRequest request) {
			logger.info("Detalles Capacitacion", locale);
			
			capacitacionDAO.ingresarCapacitacion(new Capacitacion(
						Integer.parseInt(request.getParameter("client")),
						request.getParameter("tema"),
						request.getParameter("objetivos"),
						request.getParameter("contenidos"),
						request.getParameter("recursos"),
						request.getParameter("fecha"),
						Integer.parseInt(request.getParameter("idProf"))));
			
		return new ModelAndView("/profesional/capacitacion");
	}
	
}
