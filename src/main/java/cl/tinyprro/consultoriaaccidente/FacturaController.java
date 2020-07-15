package cl.tinyprro.consultoriaaccidente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.tinyprro.beans.Factura;

@Controller
@RequestMapping(value = "/factura")
public class FacturaController {
	
	@RequestMapping(value ="/listarFaturas", method = RequestMethod.GET)
	public ModelAndView leerFacturas() {
		
		System.out.println("ListarFacturas");
		List<Factura> listaFacturas = new ArrayList<Factura>();
		listaFacturas.add(new Factura(5, 2, "01/04/20", "01/05/20", "27/04/20", null));
		listaFacturas.add(new Factura(7, 3, "01/04/20", "01/05/20", "29/04/20", null));
		listaFacturas.add(new Factura(9, 1, "01/04/20", "01/05/20", "", null));
		
		return new ModelAndView("admin/controlPagos", "listaFacturas", listaFacturas);
	}
	
}
