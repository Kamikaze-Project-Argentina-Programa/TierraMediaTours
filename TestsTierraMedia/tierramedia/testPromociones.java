package tierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPromociones {

	@Test
	public void crearAtraccionesTest() {
		Atraccion atraccion1 = new Atraccion("atraccion1", 20, 2.5, 10, "tipoUno");
		assertNotNull(atraccion1);
	}

	@Test
	public void promoPorcentualTest() {
		Atraccion moria = new Atraccion("Moria", 10, 2, 6, "Aventura");
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, "Aventura");
		Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 12, "Aventura");

		Porcentual promoPorcentual1 = new Porcentual("Aventura", moria, mordor, 20);
		assertEquals( moria.getNombre() + " + " + mordor.getNombre() + " por " + promoPorcentual1.getMonto() + " monedas!",
				promoPorcentual1.getPromo());
		assertEquals(28, promoPorcentual1.getMonto(), 0);

		Porcentual promoPorcentual2 = new Porcentual("Aventura", mordor, bosque, 30);
		assertEquals(mordor.getNombre() + " + " + bosque.getNombre() + " por " + promoPorcentual2.getMonto() +" monedas!",
				promoPorcentual2.getPromo());
		assertEquals(20, promoPorcentual2.getMonto(), 0);

		Porcentual promoPorcentual3 = new Porcentual("Aventura", moria, bosque, 25);
		assertEquals(moria.getNombre() + " + " + bosque.getNombre() + " por " + promoPorcentual3.getMonto() + " monedas!",
				promoPorcentual3.getPromo());
		assertEquals(10, promoPorcentual3.getMonto(), 0);
	}

	@Test
	public void promoAbsolutaTest() {
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, "Degustacion");
		Atraccion lothlorien = new Atraccion("Lothlorien", 35, 1, 30, "Degustacion");

		Absoluta promoAbsoluta1 = new Absoluta("Degustacion", laComarca, lothlorien, 35);
		assertEquals( laComarca.getNombre() + " + " + lothlorien.getNombre() + " por "
				+ promoAbsoluta1.getMonto() + " monedas!", promoAbsoluta1.getPromo());
		assertEquals(35, promoAbsoluta1.getMonto(), 0);
	}

	@Test
	public void promoAxBTest() {
		Atraccion minas = new Atraccion("Minas Tirith", 5, 2.5, 25, "Paisajes");
		Atraccion abismo = new Atraccion("Abismo de Helm", 5, 2, 15, "Paisajes");
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, "Paisajes");

		AxB promoAxB1 = new AxB("Paisajes", minas, abismo, erebor);
		assertEquals(10, promoAxB1.getMonto(), 0);
		assertEquals( minas.getNombre() + " + " + abismo.getNombre() + " por " + promoAxB1.getMonto() + " monedas y "
				+ erebor.getNombre() + " es gratis!", promoAxB1.getPromo());
	}

}
