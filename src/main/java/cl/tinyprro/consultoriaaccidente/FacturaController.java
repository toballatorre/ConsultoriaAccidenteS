package cl.tinyprro.consultoriaaccidente;

import java.util.List;

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

import cl.tinyprro.beans.Factura;
import cl.tinyprro.beans.Item;
import cl.tinyprro.services.FacturaService;

@Controller
@RequestMapping(value = "/factura")
public class FacturaController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	FacturaService fs;
	/**
	 * Lista todas las facturas existentes
	 * @param model
	 * @return
	 */
	@RequestMapping(value ="/listarFaturas", method = RequestMethod.GET)
	public ModelAndView leerFacturas(Model model) {

		logger.info("Listar facturas");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username

		model.addAttribute("username", name);


		List<Factura> listaFacturas = fs.getAll();
		for (Factura factura : listaFacturas) {
			logger.debug(factura.toString());
		}


		return new ModelAndView("admin/controlPagos", "listaFacturas", listaFacturas);
	}

	@RequestMapping(value="/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalleFactura(Model model,@PathVariable int id) {
		logger.info("Detalle factura Nº{}", id);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username

		model.addAttribute("username", name);
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		Factura f = fs.getById(id);
		logger.info(f.toString());
		List<Item> li = f.getListaItem();
		for (Item i : li) {
			logger.info("ITEM: {}",i.toString());
		}
		
		return new ModelAndView("/admin/detalleFactura", "f", f);
	}

}
