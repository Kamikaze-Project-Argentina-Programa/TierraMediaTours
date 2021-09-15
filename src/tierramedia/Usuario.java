package tierramedia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
	protected static String nombre;
	protected static double monedas;
	protected static double tiempo;
	protected static String tipoAtraccion; // tipo Atraccion preferida
	public static ArrayList<Promocion> promosAceptadas = new ArrayList<Promocion>();
	public static ArrayList<Atraccion> atraccAceptadas = new ArrayList<Atraccion>();

	public Usuario(String nombre, String tipo, int monedas, double tiempo) {
		super();
		Usuario.nombre = nombre;
		Usuario.monedas = monedas;
		Usuario.tiempo = tiempo;
		Usuario.tipoAtraccion = tipo;
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre + " Presupuesto: " + monedas + " monto. Tiene " + tiempo
				+ " horas y le gusta hacer: " + tipoAtraccion + ".";
	}

	protected double getMonedas() {
		return monedas;
	}

	protected double getTiempo() {
		return tiempo;
	}

	

	//restar tiempo cuando hace una atraccion:
	public static void gastarTiempo(double tiempoUsado) {
		Usuario.tiempo -= tiempoUsado;
	}
	

//restar monedas cuando hace una atraccion:
	public static void gastarMonedas(double monedasUsadas) {
		Usuario.monedas -= monedasUsadas;
	}

	public static void darBienvenida(Usuario usuario) {
		System.out.println("");
		System.out.println("Bienvenidx " + usuario.getNombre() + "!");
		System.out.println("Te gustan las atracciones de " + usuario.getTipo() + "?");
		System.out.println("Tenes " + usuario.getTiempo() +" horas disponibles y tu presupuesto es de " + usuario.getMonedas() + " Monedas." );
		System.out.println("Entonces estas promos son para vos!");
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipoAtraccion;
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
		return Objects.equals(tipoAtraccion, Usuario.tipoAtraccion) && monedas == Usuario.monedas
				&& Objects.equals(nombre, Usuario.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(Usuario.tiempo);
	}

	public static ArrayList<Promocion> getPromosAceptadas() {
		return promosAceptadas;
	}

	public static ArrayList<Atraccion> getAtracAceptadas() {
		return atraccAceptadas;
	}

	public static void aceptaAtraccion(Atraccion unaAtraccion) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Atraccion.setAceptada(unaAtraccion, false);

		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				Atraccion.setAceptada(unaAtraccion, true);
				atraccAceptadas.add(unaAtraccion);
				System.out.println("Aceptaste: " + unaAtraccion.getNombre());
				unaAtraccion.bajarCupo();
				gastarTiempo(unaAtraccion.getTiempo());
				gastarMonedas(unaAtraccion.getMonto());
				
				System.out.println("Acepta "+ unaAtraccion.getNombre() + unaAtraccion.isAceptada());
				
			} else {
				System.out.println("No acepta " + unaAtraccion.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			System.out.println("Gracias por tu respuesta!");
			System.out.println();
		}
	}

	
	public static void imprimePromos() {
		System.out.println("Estas llevando estas Promos:");
		for (Promocion promo : getPromosAceptadas()) {
			System.out.println(promo.getPromo());

		}
		getAtracAceptadas().clear();
	}

	public static void imprimeAtracciones() {
		System.out.println("Tambien vas a llevar estas Atracciones:");
		for (Atraccion act : getAtracAceptadas()) {
			System.out.println(act.getNombre());

		}
		getAtracAceptadas().clear();
	}

	public static void aceptaPromo(Promocion unaPromo) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Promocion.setPromoAceptada(unaPromo, false);

		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				Promocion.setPromoAceptada(unaPromo, true);
				Usuario.promosAceptadas.add(unaPromo);
				System.out.println("Aceptaste: " + unaPromo.getPromo());
				System.out.println(Promocion.isPromoAceptada());
				gastarTiempo(unaPromo.getTiempo());
				gastarMonedas(unaPromo.getMonto());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			System.out.println("Gracias por tu respuesta!");
			System.out.println();
		}
	}

}
