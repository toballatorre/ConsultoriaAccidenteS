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

import cl.tinyprro.beans.ReporteAccidente;
import cl.tinyprro.dao.DAOaccidente;

@Controller
public class ReporteAccidenteController {
	private static final Logger logger = LoggerFactory.getLogger(ReporteAccidenteController.class);

	@Autowired
	DAOaccidente accidenteDAO;
	
	@RequestMapping(value = "/ReporteAccidente", method = RequestMethod.GET)
	public ModelAndView reporteaccidenten() {
		logger.info("estamos en ReporteAccidenteController ");
	
		List<ReporteAccidente> lista = accidenteDAO.buscarTodos();
		
		return new ModelAndView("cliente/ReporteAccReadCliente", "listaAccidente", lista);
	}
	@RequestMapping(value = "/ReporteAccidenteCreate", method = RequestMethod.GET)
	public String reporteaccidentecrear(Model model) {
		logger.info("/ReporteAccidenteCreate estamos en ReporteAccidenteController ");
		
		
		return "cliente/ReporteAccCreate";
	}
	@RequestMapping(value = "/Accidentabilidad", method = RequestMethod.GET)
	public String accidentabilidad(Model model) {
		logger.info("/Accidentabilidad estamos en ReporteAccidenteController ");
		
		
		return "admin/AccidentabilidadReadAll";
	}
}
