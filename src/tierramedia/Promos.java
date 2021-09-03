package tierramedia;

public abstract class Promos {
	protected String tipo;
	protected double monto;
	protected Promos() {
		super();
	}
	
	abstract protected double calcularMonto();
	

}
