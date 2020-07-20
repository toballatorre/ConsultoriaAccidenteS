package cl.tinyprro.consultoriaaccidente;

import java.util.List;
import java.util.Locale;

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
import cl.tinyprro.dao.DAOcapacitacion;
import cl.tinyprro.dao.DAOclientes;


@Controller
@RequestMapping(value = "/capacitacion")
public class CapacitacionController {
	private static final Logger logger = LoggerFactory.getLogger(CapacitacionController.class);
	
	@Autowired
	DAOcapacitacion capacitacionDAO;
	@Autowired
	DAOclientes clientesDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String capacitacion() {
		System.out.println("Voy a capacitacion");
		return "profesional/capacitacion";
	}
	
	@RequestMapping(value="/crear")
	public ModelAndView crearCapacitacion() {
		
		List<Cliente> listaClientes = clientesDAO.buscarTodosClientes();
		
		return new ModelAndView("profesional/crearCapacitacion", "listaClientes", listaClientes);
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
