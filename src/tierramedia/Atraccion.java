package tierramedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Atraccion implements Adquirible {
	private boolean estado;
	private String nombre;
	public double monto;
	private double tiempo;
	private int cupo;
	private String tipo;

	public Atraccion(String nombre, double monto, double tiempo, int cupo, String tipoAtraccion) {
		super();
		this.nombre = nombre;
		this.monto = monto;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipoAtraccion;
	}

	@Override
	public String toString() {
		return "[nombre=" + getNombre() + ", monto=" + getMonto() + ", tiempo=" + tiempo + ", cupo=" + cupo + ", tipo="
				+ tipo + "]";
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public int getCupo() {
		return this.cupo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getMonto() {
		return this.monto;
	}

	protected static void ordenarAtraccionesPorTipo() {
		LeeAtracciones.leeAtracciones();
		LeeAtracciones.getListaAtracciones();
		Promocion.armarListasdePromos();
	}

	public static void sugiereUnaAtraccion(Usuario usuario, Atraccion unaAtraccion) {

		if (unaAtraccion.puedeComprarAtraccIndividual(usuario)) {

			System.out.println("");
			System.out.println("*-*-*-*-*-*-*-*-*");
			System.out.println("Lleva " + unaAtraccion.getNombre());
			System.out.println("*-*-*-*-*-*-*-*-*");
			System.out.println("");
			System.out.println("¿Te gustaria adquirir " + unaAtraccion.getNombre() + "? si / no ");

			Usuario.aceptaAtraccion(unaAtraccion);

			System.out.println("Tenes " + usuario.getTiempo() + " horas disponibles y tu presupuesto es de "
					+ usuario.getMonedas() + " Monedas.");
			System.out.println("");

		}
	}

	public static void ofreceAtraccionesPreferidas(Usuario usuario, String tipoAtraccion) throws IOException {
		ArrayList<Atraccion> atracciones = LeeAtracciones.getListaAtracciones();

		System.out.println("Te interesa alguna de las siguientes Atracciones?");

		for (Atraccion unaAtraccion : atracciones) {

			String tipo = unaAtraccion.getTipo();

			if (tipo.equalsIgnoreCase(tipoAtraccion)) {

				sugiereUnaAtraccion(usuario, unaAtraccion);
			}

		}
	}

	public static void ofreceOtrasAtracciones(Usuario usuario) {
		ArrayList<Atraccion> atracciones = LeeAtracciones.getListaAtracciones();

		System.out.println("Tambien te podemos ofrecer estas Atracciones:");

		for (Atraccion unaAtraccion : atracciones) {

			sugiereUnaAtraccion(usuario, unaAtraccion);
		}
	}

	public boolean isAceptada() {
		return estado;
	}

	public static void setAceptada(Atraccion atraccionAceptada, boolean estado) {
		atraccionAceptada.estado = estado;
	}

	@Override
	public Boolean puedeComprar(Usuario usuario) {
		return (!this.isAceptada() && this.getCupo() > 0);
	}

	public Boolean puedeComprarAtraccIndividual(Usuario usuario) {
		return (puedeComprar(usuario) && usuario.getTiempo() > this.getTiempo()
				&& usuario.getMonedas() > this.getMonto());
	}

	protected void bajarCupo() {
		this.cupo--;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupo, monto, nombre, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupo == other.cupo && Double.doubleToLongBits(monto) == Double.doubleToLongBits(other.monto)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& Objects.equals(tipo, other.tipo);
	}

}
