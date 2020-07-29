package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Cliente;
import cl.tinyprro.beans.Profesional;
import cl.tinyprro.beans.Usuario;
import cl.tinyprro.dao.DAOclientes;
import cl.tinyprro.dao.DAOusuarios;
import cl.tinyprro.services.ClienteService;
import cl.tinyprro.services.ProfesionalService;

@Controller
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	
	// TAKE QUE LOS NOMBRES DE LOS INPUT COINCIDAN CON LOS ATRIBUTOS DE LAS ENTIDADES (CLASES)
	//********* JPA *********
	@Autowired
	ProfesionalService ps;
	
	@Autowired
	ClienteService cs;
	
	
	//******* TEMPLATE *********
	@Autowired
	DAOusuarios usuarioDAO;
	@Autowired
	DAOclientes clienteDAO;
	
	/*CRUD USUARIOS*/
	@RequestMapping(value = "/Usuarios", method = RequestMethod.GET)
	public ModelAndView listarUsuarios(ModelMap model) {
		
		List<Usuario> listausuarios = usuarioDAO.buscarTodos();
		
		
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
				
		return new ModelAndView("admin/UsuarioReadAll", "listaUsers", listausuarios);
	}
	@RequestMapping(value = "/UsuarioCreate", method = RequestMethod.GET)
	public String usuarioCreate(Locale locale,Model model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		logger.info("/UsuarioCreate @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/UsuarioCreate";
	}
	@RequestMapping(value = "/UsuarioCreateSave", method = RequestMethod.POST)
	public ModelAndView usuarioCreateSave(HttpServletRequest request, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    
	    
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
	public ModelAndView listarUsuarioporid(@PathVariable int id, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		
		Usuario u = usuarioDAO.buscarPorId(id);
		
		return new ModelAndView("admin/UsuarioUpdate", "usuario", u);
	}
	@RequestMapping(value = "/UsuarioUpdate/UsuarioUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarUsuarioporid(HttpServletRequest request, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		
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
	 * 
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
				
	}*/
	
	/*
	 * JPA CLIENTE
	 */
	@RequestMapping(value = "/Clientes", method = RequestMethod.GET)
	public ModelAndView listarClientes(ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		List<Cliente> listaclientes = cs.getAll();
		logger.info("JPA clientes ");
		return new ModelAndView("admin/ClienteReadAll", "listaClientes", listaclientes);
	}
	@RequestMapping(value = "/ClienteUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView clienteUpdate(@PathVariable int id, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);	
		
		
		Cliente c = cs.getById(id);
			
		return new ModelAndView("admin/ClienteUpdate", "cliente", c);
	}
	@RequestMapping(value = "/ClienteUpdate/ClienteUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarClienteporid(Cliente c, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		cs.edit(c);
		
		return new ModelAndView("redirect:/Clientes");
				
	}
	/**
	 * JPA PROFESIONALES
	 */
	
	/**
	 * Muestra la vista del listado de todos los profesionales
	 * @return
	 */
	@RequestMapping(value = "/Profesionales", method = RequestMethod.GET)
	public ModelAndView listarProfesionales(ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    
	    
		logger.info("Usuario Controller, listar profesionales con JPA");
		
		List<Profesional> lista = ps.getAll();
		
		return new ModelAndView("admin/ProfesionalReadAll", "listaProf", lista);
	}
	
	/**
	 * Muestra la Vista para editar los datos del profesional
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/ProfesionalUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView profesionalUpdate(@PathVariable int id, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
	    
		logger.info("/ProfesionalUpdate @UsuarioController ");
				
		Profesional p = ps.getById(id);
		logger.info("ID Seleccionado:" + p.getId());
		
		return new ModelAndView("admin/ProfesionalUpdate", "p", p);
	}
	
	/**
	 * Edita los datos modificados del formulario del profesional seleccionado
	 * @param p
	 * @return
	 */
	@RequestMapping(value = "/ProfesionalUpdate/ProfesionalUpdateSave", method = RequestMethod.POST)
	public ModelAndView guardarProfesionalporid(Profesional p, ModelMap model) {
		/*Rescata nombre de usuario*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		ps.edit(p);
		
		return new ModelAndView("redirect:/Profesionales");
	}

}
