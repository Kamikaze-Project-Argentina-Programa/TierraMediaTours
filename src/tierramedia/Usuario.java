package tierramedia;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
	protected String nombre;
	protected int monedas;
	protected double tiempo;
	protected String tipoAtraccion; // tipoAtraccion preferida
	public static ArrayList<Promocion> listaDePromosAceptadas = new ArrayList<Promocion>();
	public static ArrayList<Atraccion> listaDeAtracAceptadas = new ArrayList<Atraccion>();

	public Usuario(String nombre, String tipo, int monedas, double tiempo) {
		super();
		this.nombre = nombre;
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.tipoAtraccion = tipo;
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre + " Presupuesto: " + monedas + " monto. Tiene " + tiempo
				+ " horas y le gusta hacer: " + tipoAtraccion + ".";
	}

	public int getMonedas() {
		return monedas;
	}

	public double getTiempo() {
		return tiempo;
	}

	
//restar tiempo cuando hace una atracción:
	public void gastarTiempo(Atraccion atraccion) {
		double tiempoUsado = atraccion.getTiempo();
		this.tiempo -= tiempoUsado;
	}
//restar monedas cuando hace una atracción:
	public void gastarMonedas(Atraccion atraccion) {
		double monedasUsadas = atraccion.getMonto();
		this.monedas -= monedasUsadas;
	}

	public static void darBienvenida(Usuario usuario) {
		System.out.println("");
		System.out.println("Bienvenid@ " + usuario.getNombre() + "!");
		System.out.println("Te gustan las atracciones de " + usuario.getTipo() + "?");
		System.out.println("Entonces estas promos son para vos!");
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipoAtraccion;
	}

	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoAtraccion, monedas, nombre, tiempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(tipoAtraccion, other.tipoAtraccion) && monedas == other.monedas
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo);
	}

	public static ArrayList<Promocion> getListaDePromosAceptadas() {
		return listaDePromosAceptadas;
	}
	
	public static ArrayList<Atraccion> getListaDeAtracAceptadas() {
		return listaDeAtracAceptadas;
	}

	public static void imprimePromos() {
		System.out.println("Estas llevando estas Promos:");
		for (Promocion promo : getListaDePromosAceptadas()) {
			System.out.println(promo.getPromo());
			
		}
	}
	
	public static void imprimeAtracciones() {
		System.out.println("Ademas llevas estas atracciones individuales:");
		for (Atraccion act : getListaDeAtracAceptadas()) {
			System.out.println(act.getNombre());
			
		}
	}
}
