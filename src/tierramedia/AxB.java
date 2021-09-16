package tierramedia;

public class AxB extends Promocion {
	// Comprando A y B, C es gratis

	@Override
	public String toString() {
		return "Promo AxB [tipo = " + tipoAtraccion + ", monto= " + this.getMonto() + ", atraccion 1: "
				+ atraccion1.getNombre() + ", atraccion 2: " + atraccion2.getNombre() + ", de regalo: " + atraccion3.getNombre() + "]";
	}

	protected String tipoAtraccion;
	protected double monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	protected Atraccion atraccion3;
	private Atraccion[] atraccionesEnLaPromo;

	public AxB(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, Atraccion atraccion3) {
		super();
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		this.atraccion3 = atraccion3;
		crealistaDeAtracciones();
	}

	private void crealistaDeAtracciones() {
		atraccionesEnLaPromo = new Atraccion[] {this.atraccion1,this.atraccion2,this.atraccion3};
	}
	
	public Atraccion[] getAtraccionesEnLaPromo() {
		return atraccionesEnLaPromo;
	}

	@Override
	public String getPromo() {
		return atraccion1.getNombre() + " + " + atraccion2.getNombre() + " por " + this.getMonto() + " monedas y " + atraccion3.getNombre() + " es gratis!";
	}

	@Override
	public String getTipo() {
		return tipoAtraccion;
	}

	@Override
	public double calcularMonto() {
		this.monto = this.atraccion1.getMonto() + this.atraccion2.getMonto();
		return this.monto;
	}
	
	@Override
	public double getTiempo() {
		double tiempoRequerido = 0;
		for (int i = 0; i < atraccionesEnLaPromo.length; i++ ) {
			tiempoRequerido =+ atraccionesEnLaPromo[i].getTiempo();
			}
		return tiempoRequerido;
		}
	
	@Override
	public Boolean puedeComprar(Usuario usuario) {
		return null;
	}
}
