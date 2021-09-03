package tierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class PromosTest {

	@Test
	public void crearAtraccionesTest() {
		@SuppressWarnings("unused")
		Atraccion atraccion1 = new Atraccion("atraccion1", 20, 2.5, 10, "tipoUno");
		assertNotNull(atraccion1);
	}

	@Test
	public void promoPorcentualTest() {
		Atraccion moria = new Atraccion("Moria", 10, 2, 6, "Aventura");
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, "Aventura");
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, "Aventura");
		
		Porcentual promoPorcentual1 = new Porcentual("Aventura", moria, mordor, 20);
		assertEquals("Llevá " + "Moria" + " + " + "Mordor" + " por "+ promoPorcentual1.calcularMonto() + "!", 
				promoPorcentual1.getPromo());
		assertEquals(7, promoPorcentual1.calcularMonto(), 0);
		
		Porcentual promoPorcentual2 = new Porcentual("Aventura", mordor, bosqueNegro, 30);
		assertEquals("Llevá " + mordor.nombre + " + " + bosqueNegro.nombre +" por "+ promoPorcentual2.monto + "!", 
				promoPorcentual2.getPromo());
		assertEquals(8, promoPorcentual2.calcularMonto(), 0);
	
		Porcentual promoPorcentual3 = new Porcentual("Aventura", moria, bosqueNegro, 12);
		assertEquals("Llevá " + moria.nombre + " + " + bosqueNegro.nombre +" por "+ promoPorcentual3.monto + "!", 
				promoPorcentual3.getPromo());
		assertEquals(2, promoPorcentual3.calcularMonto(), 0);
	}

	@Test
	public void promoAbsolutaTest() {
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, "Degustacion");
		Atraccion lothlorien = new Atraccion("Lothlórien", 35, 1, 30, "Degustacion");
		
		Absoluta promoAbsoluta1 = new Absoluta("Degustacion", laComarca, lothlorien, 35);
		assertEquals("Llevá " + laComarca.nombre + " + " + lothlorien.nombre +" por "+ promoAbsoluta1.monto + "!", 
						promoAbsoluta1.getPromo());
		assertEquals(35, promoAbsoluta1.calcularMonto(), 0);
	}
	
	@Test
	public void promoAxBTest() {
		Atraccion minas = new Atraccion("Minas Tirith", 5, 2.5, 25, "Paisajes");
		Atraccion abismo = new Atraccion("Abismo de Helm", 5, 2, 15, "Paisajes");
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, "Paisajes");
		
		AxB promoAxB1 = new AxB("Paisajes", minas, abismo, erebor);
		assertEquals(10, promoAxB1.calcularMonto(), 0);
		assertEquals("Llevá " + minas.nombre + " + " + abismo.nombre +" por "+ promoAxB1.calcularMonto() + " y " + erebor.nombre + " es gratis!", promoAxB1.getPromo());
	}

}
