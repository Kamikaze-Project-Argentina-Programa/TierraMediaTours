package tierramedia;

public class Absoluta extends Promos {
	protected String tipoAtraccion;
	protected int monto;
	private String atraccion1;
	private String atraccion2;
	
	protected Absoluta(String tipoAtraccion, String atraccion1, String atraccion2, int monto) {
		super();
		this.monto = monto;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
	}
	
	protected String getPromo() {
		return " Llevá " + atraccion1 + " + " + atraccion2 +" por "+ this.monto + "!";
	}
	@Override
	protected int calcularMonto() {
	return this.monto;
	}


}
