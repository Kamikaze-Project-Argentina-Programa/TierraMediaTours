package tierramedia;

public class AxB extends Promocion {
	// Comprando A y B, C es gratis

	@Override
	public String toString() {
		return "AxB [tipoAtraccion=" + tipoAtraccion + ", descuento=" + descuento + ", monto=" + monto + ", atraccion1="
				+ atraccion1 + ", atraccion2=" + atraccion2 + ", atraccion3=" + atraccion3 + "]";
	}

	protected String tipoAtraccion;
	protected int descuento;
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

	public String getPromo() {
		return "Lleva " + atraccion1.getNombre() + " + " + atraccion2.getNombre() + " por " + this.monto + " y " + atraccion3.getNombre() + " es gratis!";
	}

	@Override
	protected double calcularMonto() {
		this.monto = this.atraccion1.getMonto() + this.atraccion2.getMonto();
		return this.monto;
	}

}
