package cl.tinyprro.consultoriaaccidente;

import java.util.HashMap;
import java.util.List;
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

import cl.tinyprro.beans.Checklist;
import cl.tinyprro.beans.Pregunta;
import cl.tinyprro.services.ChecklistService;
import cl.tinyprro.services.PreguntaService;

@Controller
@RequestMapping("/checklist")
public class ChecklistController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	ChecklistService cs;
	@Autowired
	PreguntaService ps;
	/**
	 * Lista todas los checklist de la base de datos
	 * @return
	 */
	@RequestMapping("/listar")
	public ModelAndView listarChecklist(Model model) {
		logger.info("Listar Checklist");
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username

	      model.addAttribute("username", name);
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		List<Checklist> lista = cs.getAll();
		System.out.println(lista);
		return new ModelAndView("/profesional/listaChecklist", "listaCh", lista);
	}
	/**
	 * Muestra la vista con los detalles del Checklist y la lista de preguntas
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleChecklist(@PathVariable int id, Model model) {
		logger.info("Detalle de Checklist {}", id);
		
		/* Mostrar el nombre en el header */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username

	      model.addAttribute("username", name);
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		Checklist ch = cs.getById(id);
		List<Pregunta> listaP = ps.getAll();
		
		Map<String, Object> modelo = new HashMap<String, Object>();
		modelo.put("ch", ch);
		modelo.put("listaP", listaP);
		
		return new ModelAndView("/profesional/detalleChecklist", "model", modelo);
	}
}