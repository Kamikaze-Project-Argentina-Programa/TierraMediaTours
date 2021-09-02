package tierramedia;

public class AxB extends Promos {
	// Comprando A y B, C es gratis

	protected String tipoAtraccion;
	protected int descuento;
	protected int monto;
	private Atraccion atraccion1;
	private Atraccion atraccion2;
	private Atraccion atraccion3;

	protected AxB(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3) {
		super();
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		this.atraccion3 = atraccion3;
	}

	protected String getPromo() {
		return " Llevá " + atraccion1 + " + " + atraccion2 + " por " + this.monto + " y " + atraccion3 + " es gratis!";
	}

	@Override
	protected int calcularMonto() {
		this.monto = atraccion1.monto + atraccion2.monto;
		return this.monto;
	}

}
