package tierramedia;

public abstract class Promos {
	protected String tipo;
	protected int monto;
	protected Promos() {
		super();
	}
	
	abstract protected int calcularMonto();
	

}
