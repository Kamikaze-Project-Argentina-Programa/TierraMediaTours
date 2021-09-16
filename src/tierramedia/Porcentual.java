package tierramedia;

public class Porcentual extends Promocion{
	protected String tipoAtraccion;
	protected int descuento;
	protected double monto;
	protected Atraccion atraccion1;
	protected Atraccion atraccion2;
	protected Atraccion[] atraccionesEnLaPromo;
	
	public Porcentual(String tipoAtraccion, Atraccion atraccion1, Atraccion atraccion2, int descuento) {
		super();
		this.descuento = descuento;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1=atraccion1;
		this.atraccion2=atraccion2;
		crealistaDeAtracciones();
		}

		private void crealistaDeAtracciones() {
			atraccionesEnLaPromo = new Atraccion[] {this.atraccion1,this.atraccion2};
		}
		
		public Atraccion[] getAtraccionesEnLaPromo() {
			return atraccionesEnLaPromo;
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
	public double calcularMonto() {
		this.monto = Math.round((atraccion1.monto + atraccion2.monto) * (100 - descuento)/100);	
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
	public String toString() {
		return "Promo Porcentual [tipo = " + tipoAtraccion + ", descuento= " + descuento + " Porciento , monto final =" + this.getMonto()
				+ atraccion1.getNombre() + " + " + atraccion2.getNombre() + "]";
	}

	@Override
	public Boolean puedeComprar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
