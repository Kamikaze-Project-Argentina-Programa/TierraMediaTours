package tierramedia;

public class Porcentual extends Promos{
	protected String tipoAtraccion;
	protected int descuento;
	protected double monto;
	private Atraccion atraccion1;
	private Atraccion atraccion2;
	
	public Porcentual(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int descuento) {
		super();
		this.descuento = descuento;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
	}
	
	public String getPromo() {
		return "Lleva " + atraccion1.getNombre() + " + " + atraccion2.getNombre() +" por "+ this.monto + "!";
	}
	@Override
	protected double calcularMonto() {
		this.monto = Math.round((atraccion1.monto + atraccion2.monto) * (100 - descuento)/100);	
		return this.monto;
	}

	@Override
	public String toString() {
		return "Porcentual [tipoAtraccion=" + tipoAtraccion + ", descuento=" + descuento + ", monto=" + monto
				+ ", atraccion1=" + atraccion1 + ", atraccion2=" + atraccion2 + "]";
	}
	
	
	
}
