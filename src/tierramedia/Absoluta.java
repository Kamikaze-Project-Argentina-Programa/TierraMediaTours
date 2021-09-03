package tierramedia;

public class Absoluta extends Promos {
	protected String tipoAtraccion;
	protected int monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	
	protected Absoluta(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int monto) {
		super();
		this.monto = monto;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
	}
	
	protected String getPromo() {
		return "Lleva " + atraccion1.nombre + " + " + atraccion2.nombre +" por "+ this.monto + "!";
	}
	@Override
	protected double calcularMonto() {
	return this.monto;
	}


}
