package tierramedia;

public class Absoluta extends Promos {
	@Override
	public String toString() {
		return "Absoluta [tipoAtraccion=" + tipoAtraccion + ", monto=" + monto + ", atraccion1=" + atraccion1
				+ ", atraccion2=" + atraccion2 + "]";
	}
	protected String tipoAtraccion;
	protected double monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	
	public Absoluta(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int montoFinal) {
		super();
		this.monto = montoFinal;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
	}
	
	public String getPromo() {
		return "Lleva " + atraccion1.getNombre() + " + " + atraccion2.getNombre() +" por "+ this.getMonto() + "!";
	}
	@Override
	protected double calcularMonto() {
		return this.monto;
	}

}
