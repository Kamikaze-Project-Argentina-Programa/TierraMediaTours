package tierramedia;

public class AxB extends Promocion {
	// Comprando A y B, C es gratis

	@Override
	public String toString() {
		return "Promo AxB [tipo = " + tipoAtraccion + ", monto= " + this.getMonto() + ", atraccion 1: "
				+ atraccion1.getNombre() + ", atraccion 2: " + atraccion2.getNombre() + ", de regalo: " + atraccion3.getNombre() + "]";
	}

	protected String tipoAtraccion;
	protected double monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	protected Atraccion atraccion3;

	public AxB(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3) {
		super();
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		this.atraccion3 = atraccion3;
	}

	@Override
	public String getPromo() {
		return "Lleva " + atraccion1.getNombre() + " + " + atraccion2.getNombre() + " por " + this.getMonto() + " monedas y " + atraccion3.getNombre() + " es gratis!";
	}

	@Override
	public String getTipo() {
		return tipoAtraccion;
	}


	@Override
	protected double calcularMonto() {
		this.monto = this.atraccion1.getMonto() + this.atraccion2.getMonto();
		return this.monto;
	}
	

}
