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
import cl.tinyprro.beans.Cliente;
import cl.tinyprro.dao.DAOactividad;
import cl.tinyprro.dao.DAOclientes;

@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {

	@Autowired
	DAOactividad actividadDAO;
	@Autowired
	DAOclientes clientesDAO;

	@RequestMapping(value="/ingresar", method = RequestMethod.GET)
	public ModelAndView actividad() {
		
		List<Cliente> listaCliente = clientesDAO.buscarTodosClientes();
		
		return new ModelAndView("profesional/ingresrActividad", "listaCliente", listaCliente);
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
	 

	@RequestMapping(value = "/listarActividadesA")
	public ModelAndView listarActividadesA(){

		List<Actividad> listaActividades = actividadDAO.buscarTodos();

		return new ModelAndView("/admin/visualizarActividades", "listaAct", listaActividades);
	}
	
	@RequestMapping(value = "/listarActividadesP")
	public ModelAndView listarActividadesP(){

		List<Actividad> listaActividades = actividadDAO.buscarTodos();

		return new ModelAndView("/profesional/listarActividades", "listaAct", listaActividades);
	}


	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleActividad(@PathVariable int id) {
		
		Actividad actividad = actividadDAO.actividadById(id);

		return new ModelAndView("profesional/revisarActividad", "act", actividad);
	}
}
