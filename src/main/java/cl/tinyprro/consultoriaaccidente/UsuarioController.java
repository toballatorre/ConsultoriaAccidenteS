package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Profesional;
import cl.tinyprro.beans.Usuario;
import cl.tinyprro.dao.DAOclientes;
import cl.tinyprro.dao.DAOprofesional;
import cl.tinyprro.dao.DAOusuarios;

@Controller
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	DAOusuarios usuarioDAO;
	@Autowired
	DAOclientes clienteDAO;
	@Autowired
	DAOprofesional profesionalDAO;
	
	/*CRUD USUARIOS*/
	@RequestMapping(value = "/Usuarios", method = RequestMethod.GET)
	public ModelAndView listarUsuarios() {
		
		List<Usuario> listausuarios = usuarioDAO.buscarTodos();
				
		return new ModelAndView("admin/UsuarioReadAll", "listaUsers", listausuarios);
	}
	@RequestMapping(value = "/UsuarioCreate", method = RequestMethod.GET)
	public String usuarioCreate(Locale locale,Model model) {
		logger.info("/UsuarioCreate @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/UsuarioCreate";
	}
	@RequestMapping(value = "/UsuarioCreateSave", method = RequestMethod.POST)
	public ModelAndView usuarioCreateSave(HttpServletRequest request) {
		
		usuarioDAO.ingresarUsuario(new Usuario(
				request.getParameter("txtusuario"),
				request.getParameter("txttipouser"),
				request.getParameter("txtclave"),
				request.getParameter("txtmail"),
				request.getParameter("txtactivo")
				));
		
		return new ModelAndView("redirect:/Usuarios");
	}
	
	
	@RequestMapping(value = "/UsuarioUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView listarUsuarioporid(@PathVariable int id) {
		
		Usuario u = usuarioDAO.buscarPorId(id);
		
		return new ModelAndView("admin/UsuarioUpdate", "usuario", u);
	}
	@RequestMapping(value = "/UsuarioUpdate/UsuarioUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarUsuarioporid(HttpServletRequest request) {
		
		Usuario u = new Usuario(
				Integer.parseInt(request.getParameter("idusuario")),
				request.getParameter("txtusuario"),
				request.getParameter("txttipousuario"),
				request.getParameter("txtclave"),
				request.getParameter("txtmail"),
				request.getParameter("txtactivo")
				);
		usuarioDAO.actualizarPorId(u);
				
		
		return new ModelAndView("redirect:/Usuarios");
	}
	
	
		
	/*
	 * CRUD CLIENTES
	 * */
	@RequestMapping(value = "/Clientes", method = RequestMethod.GET)
	public ModelAndView listarClientes() {
		
		List<Cliente> listaclientes = clienteDAO.buscarTodosClientes();
				
		return new ModelAndView("admin/ClienteReadAll", "listaClientes", listaclientes);
	}
	@RequestMapping(value = "/ClienteUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView clienteUpdate(@PathVariable int id) {
			
		Cliente c = clienteDAO.buscarPorId(id);
			
		return new ModelAndView("admin/ClienteUpdate", "cliente", c);
	}
	
	@RequestMapping(value = "/ClienteUpdate/ClienteUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarClienteporid(HttpServletRequest request) {
		Cliente c = new Cliente(
				Integer.parseInt(request.getParameter("idcliente")),
				request.getParameter("nombreempresa"),
				request.getParameter("rutempresa"),
				Integer.parseInt(request.getParameter("idusuario"))
				);
		clienteDAO.actualizarCliente(c);
		
		return new ModelAndView("redirect:/Clientes");
				
	}
	
	
	
	
	
	
	/*
	 * CRUD PROFESIONALES
	 * */
	@RequestMapping(value = "/Profesionales", method = RequestMethod.GET)
	public ModelAndView profesionales() {

	
		List<Profesional> listaprofesionales = profesionalDAO.listarTodos();
		
		return new ModelAndView("admin/ProfesionalReadAll", "listaProf", listaprofesionales);
	}
	@RequestMapping(value = "/ProfesionalUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView profesionalUpdate(@PathVariable int id) {
		logger.info("/ProfesionalUpdate @UsuarioController ");
		
		Profesional p = profesionalDAO.buscarPorId(id);
		
		return new ModelAndView("admin/ProfesionalUpdate", "profesional", p);
	}
	@RequestMapping(value = "/ProfesionalUpdate/ProfesionalUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarProfesionalporid(HttpServletRequest request) {
		
		Profesional p = new Profesional(
				Integer.parseInt(request.getParameter("idempleado")),
				request.getParameter("nombre"),
				Integer.parseInt(request.getParameter("idusuario")),
				request.getParameter("celular")
				);
		profesionalDAO.actualizarPorId(p);
				
		return new ModelAndView("redirect:/Profesionales");
	}
	
}
