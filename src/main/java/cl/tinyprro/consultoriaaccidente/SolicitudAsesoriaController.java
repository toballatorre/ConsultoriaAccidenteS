package cl.tinyprro.consultoriaaccidente;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.SolicitudAsesoria;
import cl.tinyprro.dao.DAOasesoria;

@Controller
public class SolicitudAsesoriaController {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudAsesoriaController.class);
	
	@Autowired
	DAOasesoria asesoriaDAO;
	
	@RequestMapping(value = "/SolicitudAsesoria", method = RequestMethod.GET)
	public ModelAndView solicitudasesoria(Model model) {
		logger.info("/SolicitudAsesoria estamos en SolicitudAsesoriaController");
	
		List<SolicitudAsesoria> lista = asesoriaDAO.buscarTodos();
		
		return new ModelAndView("cliente/SolicitudAsesoriaReadAll", "listaSolicitud", lista);
	}
	@RequestMapping(value = "/SolicitudAsesoriaCreate", method = RequestMethod.GET)
	public String solicitudasesoriacrear(Model model) {
		logger.info("/SolicitudAsesoriaCreate estamos en SolicitudAsesoriaController");
		
		
		return "cliente/SolicitudAsesoriaCreate";
	}
	
}
