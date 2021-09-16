package tierramedia;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testGeneral {

	@Test
	public void testArchivosPromociones() {
		new LeePromos();

		Assert.assertNotNull(LeePromos.getListaPromos());

	}

	@Test
	public void testArchivosUsuarios() {
		new LeeUsuarios();

		Assert.assertNotNull(LeeUsuarios.getListaUsuarios());

	}

	@Test
	public void testArchivosAtracciones() {
		new LeeAtracciones();

		Assert.assertNotNull(LeeAtracciones.getListaAtracciones());

	}

}
