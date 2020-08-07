package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.tinyprro.beans.Usuario;
import cl.tinyprro.services.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UsuarioControllerTest {
	

	@Autowired
	private UsuarioService usrService;
	
    @Before
    public void setUp() throws Exception {
    }
			
	@Test
    public void testGetbyid() {
		Usuario u1 = usrService.getById(1);
		
		String aa = u1.getUsuario();
		String ab = "admin1";

		System.out.println(u1);
		System.out.println(aa);
		System.out.println(ab);
			
        assertEquals(aa, ab);
    }
	
	@Test
	public void testGetAll(){
		List<Usuario> lu = usrService.getAll();
		
		System.out.println(lu.size());
		Boolean leyo;
		
		if (lu.size() > 0) {
			leyo = true;
		} else {
			leyo = false;
		}
		
		assertTrue(leyo);
		
	}
	@Test
	public void testAddYGetByUsusario(){
		Usuario u2 = new Usuario("usuariotest","testtipo", "testclave", "testmail", "t");
		
		usrService.add(u2);
		Usuario u3 = usrService.getByUsuario("usuariotest");
		
		String aa =u2.getMail();
		String ab =u3.getMail();
		System.out.println(aa);
		System.out.println(ab);
		
		assertEquals(aa,ab);
		

	}

}
