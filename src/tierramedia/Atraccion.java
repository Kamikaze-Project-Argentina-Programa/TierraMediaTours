package tierramedia;

public class Atraccion {
	protected String nombre;
	protected int monto;
	protected double tiempo;
	protected int cupo;
	protected String tipo;

	public Atraccion(String nombre, String monedas, String tiempo, String cupo, String atraccion) {
		super();
		this.nombre = nombre;
		this.monto = Integer.parseInt(monedas);
		this.tiempo = Double.parseDouble(tiempo);
		this.cupo = Integer.parseInt(cupo);
		this.tipo = atraccion;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", monto=" + monto + ", tiempo=" + tiempo + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]";
	}

}
