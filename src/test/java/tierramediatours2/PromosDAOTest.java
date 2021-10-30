package tierramediatours2;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tierramedia2.dao.PromocionesDAO;

public class PromosDAOTest {
	
	@Test
	public void testFindAll() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();
		
		List<LeePromociones>  listaPromociones = PromocionesDAO.findAll();
		Assert.assertNotNull(listaPromociones);
		Assert.assertEquals(3,listaPromociones.size());
	}

	@Test
	public void testFindByTipoPackAventuras() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = PromocionesDAO.findByTipo("Aventuras");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Aventuras", leePromociones.getTipo_pack());
		Assert.assertEquals("Moria", leePromociones.getAtraccion1());
		Assert.assertEquals("Mordor", leePromociones.getAtraccion2());

	}

	@Test
	public void testFindByTipoPackPaisajes() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = PromocionesDAO.findByTipo("Paisajes");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Paisajes", leePromociones.getTipo_pack());
		Assert.assertEquals("Minas Tirith", leePromociones.getAtraccion1());
		Assert.assertEquals("Abismos de Helm", leePromociones.getAtraccion2());
		Assert.assertEquals("Erebor", leePromociones.getAtraccion3());

	}

	@Test
	public void testFindByTipoPackDegustacion() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = PromocionesDAO.findByTipo("Degustacion");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Degustacion", leePromociones.getTipo_pack());
		Assert.assertEquals("La Comarca", leePromociones.getAtraccion1());
		Assert.assertEquals("Lothlorien", leePromociones.getAtraccion2());

	}

}
