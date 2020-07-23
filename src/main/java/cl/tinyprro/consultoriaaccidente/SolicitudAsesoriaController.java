package cl.tinyprro.consultoriaaccidente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.services.SolicitudAsesoriaService;

/**
 * Solicitud Asesoria funcionando con JPA
 * @author Cristobal L
 *
 */
@Controller
public class SolicitudAsesoriaController {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudAsesoriaController.class);
	
	@Autowired
	SolicitudAsesoriaService sas;
	
	/**
	 * Muestra la Vista de las asesorías listadas
	 * @return
	 */
	@RequestMapping(value = "/SolicitudAsesoria", method = RequestMethod.GET)
	public ModelAndView listarAsesorias() {
		logger.info("/SolicitudAsesoria estamos en SolicitudAsesoriaController, listarAsesorias");
		
		List<SolicitudAsesoria> lista = sas.getAll();
		
		return new ModelAndView("cliente/SolicitudAsesoriaReadAll", "listaSolicitud", lista);
	}
	
	/**
	 * Muestra la Vista del formulario para crear una Solicitud de Asesoria
	 * @return
	 */
	@RequestMapping(value = "/SolicitudAsesoriaCreate", method = RequestMethod.GET)
	public ModelAndView crearSolicitud() {
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController Formulario crear");

		return new ModelAndView("cliente/SolicitudAsesoriaCreate");
	}
	
	@RequestMapping(value = "/ingresarAsesoria", method = RequestMethod.POST)
	public ModelAndView ingresarSolicitud(HttpServletRequest request) {
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController Ingresar Asesoria");
		
		sas.add(new SolicitudAsesoria( 
				request.getParameter("fecha"),
				request.getParameter("motivo"),
				request.getParameter("preferenciaHorario"),
				Integer.parseInt(request.getParameter("idCliente"))));
				
		return new ModelAndView("redirect:/SolicitudAsesoria");
	}

}
