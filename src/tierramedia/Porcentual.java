package tierramedia;

public class Porcentual extends Promos{
	protected String tipoAtraccion;
	protected int descuento;
	protected double monto;
	private Atraccion atraccion1;
	private Atraccion atraccion2;
	
	protected Porcentual(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int descuento) {
		super();
		this.descuento = descuento;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
	}
	
	protected String getPromo() {
		return "Lleva " + atraccion1.nombre + " + " + atraccion2.nombre +" por "+ this.monto + "!";
	}
	@Override
	protected double calcularMonto() {
		this.monto = (atraccion1.monto + atraccion2.monto)*descuento/100;
		return Math.round(this.monto);
	}
}