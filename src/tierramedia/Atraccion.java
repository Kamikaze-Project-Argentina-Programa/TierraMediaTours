package tierramedia;

public class Atraccion {
	protected String nombre;
	protected String monedas;
	protected String tiempo;
	protected String cupo;
	protected String tipo;

	public Atraccion(String nombre, String monedas, String tiempo, String cupo, String atraccion) {
		super();
		this.nombre = nombre;
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = atraccion;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", monedas=" + monedas + ", tiempo=" + tiempo + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]";
	}

}
