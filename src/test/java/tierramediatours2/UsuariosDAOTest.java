package tierramediatours2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tierramedia2.dao.UsuariosDAO;
import tierramedia2.db.ConnectionProvider;

public class UsuariosDAOTest {

	@Test
	public void testConnectionOK() throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		Assert.assertNotNull(connection);
	}

//	@Test
//	public void testFindById() throws SQLException {
//		UsuariosDAO usuariosDAO = new UsuariosDAO();
//		
//		LeeUsuarios leeUsuario = usuariosDAO.findById(2);
//		Assert.assertNotNull(leeUsuario);
//		Assert.assertEquals(Integer.valueOf(2), leeUsuario.getId());
//		Assert.assertEquals("Gandalf", leeUsuario.getNombre());
//		
//		leeUsuario = usuariosDAO.findById(1);
//		Assert.assertNotNull(leeUsuario);
//		Assert.assertEquals(Integer.valueOf(1), leeUsuario.getId());
//		Assert.assertEquals("Eowyn", leeUsuario.getNombre());
//		
//		
//
//	}
//	
	
	@Test
	public void testFindAll() throws SQLException {
		UsuariosDAO usuariosDAO = new UsuariosDAO();
		List<LeeUsuarios> losLeeUsuarios = usuariosDAO.findAll();
		
		Assert.assertNotNull(losLeeUsuarios);
		Assert.assertEquals(4,losLeeUsuarios.size());
		
		System.out.println(losLeeUsuarios);
		
	}
//	
//	@Test
//	public void testFindByNombre() throws SQLException {
//		UsuariosDAO usuariosDAO = new UsuariosDAO();
//		
//		LeeUsuarios leeUsuario = usuariosDAO.findByNombre("Eowyn");
//		
//
//	}

}
