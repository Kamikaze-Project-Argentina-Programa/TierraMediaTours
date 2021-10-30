package tierramediatours2;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tierramedia2.dao.AtraccionesDAO;

public class AtraccionesDAOTest {
	
//	@Test
//	public void testFindById() throws SQLException {
//		AtraccionesDAO atraccionesDAO = new AtraccionesDAO();
//		
//		LeeAtracciones leeAtracciones = atraccionesDAO.findById(1);
//		Assert.assertNotNull(leeAtracciones);
//		Assert.assertEquals(Integer.valueOf(1),leeAtracciones.getId());
//		
//	}
	
//	@Test
//	public void testFindAll() throws SQLException {
//		AtraccionesDAO atraccionesDAO = new AtraccionesDAO();
//		List<LeeAtracciones> losLeeAtracciones = atraccionesDAO.findAll();
//		
//		Assert.assertNotNull(losLeeAtracciones);
//		Assert.assertEquals(9,losLeeAtracciones.size());
//		
//		System.out.println(losLeeAtracciones);
//		
//	}
	
	@Test
	public void testFindByTipo() throws SQLException {
		
		LeeUsuarios usuario = new LeeUsuarios(1, "Jorge", 20, 10f, "Aventuras");
		
		AtraccionesDAO atraccionesDAO = new AtraccionesDAO();
		List<LeeAtracciones> losLeeAtracciones = AtraccionesDAO.findByTipo(usuario.getId_tipo_atraccion());
		
		Assert.assertNotNull(losLeeAtracciones);
		Assert.assertEquals(4, losLeeAtracciones.size());
		System.out.println(losLeeAtracciones);
	}

}
