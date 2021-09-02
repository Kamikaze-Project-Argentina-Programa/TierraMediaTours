package tierramedia;

public class Atraccion {
	protected String nombre;
	protected int monto;
	protected double tiempo;
	protected int cupo;
	protected String tipo;

	public Atraccion(String nombre, int monto, double tiempo, int cupo, String atraccion) {
		super();
		this.nombre = nombre;
		this.monto = monto;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = atraccion;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", monto=" + monto + ", tiempo=" + tiempo + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]";
	}

}
