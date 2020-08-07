package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.tinyprro.beans.Item;
import cl.tinyprro.services.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context-test.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //Forzar a hacer las pruebas unitarias en orden según el nombre de los test
public class ItemServiceTest {

	@Autowired
	private ItemService itemService;
	
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Cantidad de items en la lista, en el inicio de esta lista tenemos 30 items creados
	 */
	@Test
	public void aTestLeerTodos() {
		System.out.println("001 - aTestLeerTodos");
		List<Item> listaItems = itemService.getAll();
		int cantidad = 30;
		assertEquals(cantidad, listaItems.size());
	}

	@Test
	public void bTestLeerPorId() {
		System.out.println("002 - bTestLeerPorId");
		int id = 1;
		
		Item i = itemService.getById(id);
		
		assertEquals(id, i.getIdItem());
		
	}
	
	@Test
	public void cTestEditar() {
		System.out.println("003 - cTestEditar");
		// Buscamos un item en especial para editar
		int id = 2;
		Item i = itemService.getById(id);
		
		//definimos lo que editaremos
		String concepto = "Mensualidad";
		i.setConcepto(concepto);
		
		//Editamos la base de datos ingresando la clase con el concepto cambiado
		itemService.edit(i);
		
		assertEquals(concepto, itemService.getById(id).getConcepto());
		
	}
	
	@Test
	public void dTestAgregarUnItem() {
		System.out.println("004 - dTestAgregarUnItem");
		//Cantidad de itemes antes de agregar uno
		int itemsAntes = itemService.getAll().size();
		System.out.println("Items Antes: " + itemsAntes);
		
		//Crear el Item a ingresar
		Item i = new Item();
		i.setCantidad(20);
		i.setConcepto("TEST");
		i.setPrecioUnitario(15);
		i.setFactura(12);
		System.out.println(i.toString());
		
		//Ingresa el item en la base de datos
		itemService.add(i);
		
		int itemsAhora = itemsAntes + 1;
		int sizeList = itemService.getAll().size();
		System.out.println("Items Ahora: " + sizeList);
		System.out.println("Items Antes + 1: " + itemsAhora);
		
		assertEquals(itemsAhora, itemService.getAll().size());
	}
	
	@Test
	public void eTestEliminarUnItem() {
		System.out.println("005 - eTestEliminarUnItem");
		//Cantidad de items antes de eliminar uno
		int itemsAntes = itemService.getAll().size();
		System.out.println("Cantidad antes de eliminar: " + itemsAntes);
		
		//Seleccionar el item a eliminar buscaremos el item agregado en el test.
		List<Item> listaI = itemService.getAll();
		Item itemEliminar = new Item();
		
		//Buscamos en la listaI con concepto TEST
		for (Item item : listaI) {
			if(item.getConcepto().equals("TEST"))
				itemEliminar = item;
		}
		
		// Eliminamos el item seleccionado
		itemService.delete(itemEliminar.getIdItem());
		
	}
}
