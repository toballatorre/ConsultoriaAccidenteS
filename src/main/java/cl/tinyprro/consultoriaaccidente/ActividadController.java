package cl.tinyprro.consultoriaaccidente;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Actividad;
import cl.tinyprro.dao.DAOactividad;


@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {
	private static final Logger logger = LoggerFactory.getLogger(ActividadController.class);
	
	@Autowired
	DAOactividad actividadDAO;
	
	@RequestMapping(value="/ingresar", method = RequestMethod.GET)
	public String actividad() {

		return "profesional/ingresrActividad";
	}
	

	@RequestMapping(value = "/detalle", method = RequestMethod.POST) public
	String actividad(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Detalles Capacitacion", locale);

		ApplicationContext aC = new
				ClassPathXmlApplicationContext("cl/tinyprro/xml/beans.xml");

		Actividad a = (Actividad) aC.getBean("actividad");

		a.setId(Integer.parseInt(request.getParameter("idAct")));
		a.setTitulo(request.getParameter("titulo"));
		a.setFechaPlazo(request.getParameter("fechaP"));
		a.setDescripcion(request.getParameter("descripcion"));
		a.setComentario(request.getParameter("comentario"));
		a.setStatus(request.getParameter("status"));
		a.setIdCliente(Integer.parseInt(request.getParameter("cliente")));

		model.addAttribute("act", a);

		((ConfigurableApplicationContext)aC).close();
		
		return "profesional/revisarActividad";
	}
	
	@RequestMapping(value = "/listarActividades")
	public ModelAndView listarActividades(){
		
		List<Actividad> listaActividades = actividadDAO.buscarTodos();
		
		return new ModelAndView("/admin/visualizarActividades", "listaAct", listaActividades);
	}
	
	@RequestMapping(value = "/detalleTest", method = RequestMethod.GET) public
	String detalleactividad(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Detalles Capacitacion", locale);

		ApplicationContext aC = new
				ClassPathXmlApplicationContext("cl/tinyprro/xml/beans.xml");

		Actividad a = (Actividad) aC.getBean("actividad");

		model.addAttribute("act", a);

		((ConfigurableApplicationContext)aC).close();
		
		return "profesional/revisarActividad";
	}
}
