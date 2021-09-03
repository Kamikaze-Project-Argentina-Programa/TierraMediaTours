package tierramedia;

public class AxB extends Promos {
	// Comprando A y B, C es gratis

	protected String tipoAtraccion;
	protected int descuento;
	protected double monto;
	
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	protected Atraccion atraccion3;

	protected AxB(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3) {
		super();
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		this.atraccion3 = atraccion3;
	}

	protected String getPromo() {
		return "Llevá " + this.atraccion1 + " + " + this.atraccion2 + " por " + this.monto + " y " + this.atraccion3 + " es gratis!";
	}

	@Override
	protected double calcularMonto() {
		this.monto = this.atraccion1.monto + this.atraccion2.monto;
		return this.monto;
	}

}
