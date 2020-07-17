package cl.tinyprro.consultoriaaccidente;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Usuario;
import cl.tinyprro.dao.DAOusuarios;

@Controller
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	DAOusuarios usuarioDAO;	
	
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
	@RequestMapping(value = "/UsuarioUpdate", method = RequestMethod.GET)
	public String usuarioUpdate(Locale locale,Model model) {
		logger.info("/UsuarioUpdate @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/UsuarioUpdate";
	}
	
	/*CRUD CLIENTES*/
	@RequestMapping(value = "/Clientes", method = RequestMethod.GET)
	public String clientes(Locale locale,Model model) {
		logger.info("/Clientes @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/ClienteReadAll";
	}
	@RequestMapping(value = "/ClienteUpdate", method = RequestMethod.GET)
	public String clienteUpdate(Locale locale,Model model) {
		logger.info("/ClienteUpdate @UsuarioController ");
		return "admin/ClienteUpdate";
	}
	
	/*CRUD PROFESIONALES*/
	@RequestMapping(value = "/Profesionales", method = RequestMethod.GET)
	public String profesionales(Locale locale,Model model) {
		logger.info("/Profesionales @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/ProfesionalReadAll";
	}
	@RequestMapping(value = "/ProfesionalUpdate", method = RequestMethod.GET)
	public String profesionalUpdate(Locale locale,Model model) {
		logger.info("/ProfesionalUpdate @UsuarioController ");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "admin/ProfesionalUpdate";
	}
	
	
}
