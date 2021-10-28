package tierramediatours2;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import tierramedia2.dao.PromocionesDAO;

public class PromosDAOTest {

	@Test
	public void testFindByTipoPackAventuras() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = promocionesDAO.findByTipoPack("Aventuras");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Aventuras", leePromociones.getTipo_pack());
		Assert.assertEquals("Moria", leePromociones.getAtraccion1());
		Assert.assertEquals("Mordor", leePromociones.getAtraccion2());

	}

	@Test
	public void testFindByTipoPackPaisajes() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = promocionesDAO.findByTipoPack("Paisajes");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Paisajes", leePromociones.getTipo_pack());
		Assert.assertEquals("Minas Tirith", leePromociones.getAtraccion1());
		Assert.assertEquals("Abismos de Helm", leePromociones.getAtraccion2());
		Assert.assertEquals("Erebor", leePromociones.getAtraccion3());

	}

	@Test
	public void testFindByTipoPackDegustacion() throws SQLException {
		PromocionesDAO promocionesDAO = new PromocionesDAO();

		LeePromociones leePromociones = promocionesDAO.findByTipoPack("Degustacion");
		Assert.assertNotNull(leePromociones);
		Assert.assertEquals("Degustacion", leePromociones.getTipo_pack());
		Assert.assertEquals("La Comarca", leePromociones.getAtraccion1());
		Assert.assertEquals("Lothlorien", leePromociones.getAtraccion2());

	}

}
