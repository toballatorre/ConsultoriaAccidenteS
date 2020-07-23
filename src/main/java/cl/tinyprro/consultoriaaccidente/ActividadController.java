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
import cl.tinyprro.services.ActividadService;
import cl.tinyprro.services.ClienteService;

/**
 * Actividad implementado JPA
 * @author Cristobal L
 *
 */
@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {

	@Autowired
	ActividadService as;
	@Autowired
	ClienteService cs;
	
	/**
	 * Listar Actividades para Admin
	 * @return
	 */
	@RequestMapping(value = "/listarActividadesA")
	public ModelAndView listarActividadesA() {
		
		List<Actividad> lista = as.getAll();
		
		return new ModelAndView("/admin/visualizarActividades", "listaAct", lista);
	}
	
	/**
	 * Listar Actividades para Profesional
	 * @return
	 */
	@RequestMapping(value = "/listarActividadesP")
	public ModelAndView listarActividadesP() {
		
		List<Actividad> lista = as.getAll();
		
		return new ModelAndView("/profesional/listarActividades", "listaAct", lista);
	}
	
	/**
	 * Muestra en detalle una actividad en específico VistaProfesional
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleActividad(@PathVariable int id) {
		
		Actividad a = as.getById(id);
		
		return new ModelAndView("profesional/revisarActividad", "act", a);
	}
	
	/**
	 * Muestra en detalle una actividad en específico VistaAdmin
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detalleA/{id}", method = RequestMethod.GET)
	public ModelAndView detalleActividadA(@PathVariable int id) {
		
		Actividad a = as.getById(id);
		
		return new ModelAndView("admin/revisarActividad", "act", a);
	}
	
	
	
	/**
	 * Muestra la Vista para llenar los datos de la actividad
	 * @return
	 */
	@RequestMapping(value="/ingresar", method = RequestMethod.GET)
	public ModelAndView ingresarActividad() {
		
		List<Cliente> lista = cs.getAll();
		
		return new ModelAndView("profesional/ingresrActividad", "listaCliente", lista);
	}
	
	/**
	 * Ingresa a la base de datos con JPA la actividad y muestra las actividades listadas
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/ingresar", method = RequestMethod.POST)
	public ModelAndView ingresarActividad(HttpServletRequest request) {
		
		as.add(new Actividad(
				request.getParameter("titulo"),
				request.getParameter("descripcion"),
				request.getParameter("fechaP"),
				request.getParameter("status"),
				request.getParameter("comentario"),
				Integer.parseInt(request.getParameter("cliente"))));
		
		return new ModelAndView("redirect:/actividad/listarActividadesP");
	}
	
}
