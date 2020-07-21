package cl.tinyprro.consultoriaaccidente;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Actividad;
import cl.tinyprro.dao.DAOactividad;

@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {

	@Autowired
	DAOactividad actividadDAO;

	@RequestMapping(value="/ingresar", method = RequestMethod.GET)
	public String actividad() {

		return "profesional/ingresrActividad";
	}


	
	  @RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	  public String actividad(HttpServletRequest request) {
	  	  
	  actividadDAO.ingresarActividad(new Actividad(
			  request.getParameter("titulo"),
			  request.getParameter("descripcion"),
			  request.getParameter("fechaP"),
			  request.getParameter("status"),
			  request.getParameter("comentario"),
			  Integer.parseInt(request.getParameter("cliente"))));
	  
	  return "profesional/revisarActividad"; }
	 

	@RequestMapping(value = "/listarActividades")
	public ModelAndView listarActividades(){

		List<Actividad> listaActividades = actividadDAO.buscarTodos();

		return new ModelAndView("/admin/visualizarActividades", "listaAct", listaActividades);
	}

	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleActividad(@PathVariable int id) {
		
		Actividad actividad = actividadDAO.actividadById(id);

		return new ModelAndView("profesional/revisarActividad", "act", actividad);
	}
}
