package tierramedia;

public class Absoluta extends Promocion {
	@Override
	public String toString() {
		return "Promo Absoluta [tipo =" + tipoAtraccion + ", monto =" + this.getMonto() + ", atraccion 1=" + atraccion1
				+ ", atraccion2=" + atraccion2 + "]";
	}
	protected String tipoAtraccion;
	protected double monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	private Atraccion[] atraccionesEnLaPromo;
	
	public Absoluta(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int montoFinal) {
		super();
		this.monto = montoFinal;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
		crealistaDeAtracciones();
	}
	
	private void crealistaDeAtracciones() {
		atraccionesEnLaPromo = new Atraccion[] {this.atraccion1,this.atraccion2};
	}
	
	
	@Override
	public String getPromo() {
		return atraccion1.getNombre() + " + " + atraccion2.getNombre() +" por "+ this.getMonto() + " monedas!";
	}
	
	@Override
	public String getTipo() {
		return tipoAtraccion;
	}
	
	@Override
	protected double calcularMonto() {
		return this.monto;
	}

	@Override
	public Boolean puedeComprar(Usuario usuario) {
		return (atraccionesEnLaPromo[0].puedeComprar(usuario)&&
				atraccionesEnLaPromo[1].puedeComprar(usuario));
	}

	@Override
	public Atraccion[] getAtracciones() {
		return atraccionesEnLaPromo;
	}

	@Override
	public double getTiempo() {
		double tiempoRequerido = 0;
		for (int i = 0; i < atraccionesEnLaPromo.length; i++ ) {
			tiempoRequerido =+ atraccionesEnLaPromo[i].getTiempo();
			}
		return tiempoRequerido;
		}
}
