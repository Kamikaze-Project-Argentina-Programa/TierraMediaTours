package tierramedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Atraccion implements Adquirible {
	private static boolean aceptada;
	protected String nombre;
	protected double monto;
	protected double tiempo;
	protected int cupo;
	protected String tipo;

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

		

	public static void aceptaAtraccion(Atraccion unaAtraccion) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Atraccion> atraccAceptadas = Usuario.listaDeAtracAceptadas;
		setAceptada(false);

		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				setAceptada(true);
				atraccAceptadas.add(unaAtraccion);
				System.out.println("Aceptaste: " + unaAtraccion.getNombre());
				unaAtraccion.bajarCupo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			
			System.out.println("Gracias por tu respuesta!");
			System.out.println();
		}
	}

	public static void ofreceAtracciones(String tipoAtraccion, Usuario usuario ) throws IOException {
		ArrayList<Atraccion> atracciones = LeeAtracciones.getListaAtracciones();
		System.out.println("Te interesa alguna de las siguientes Atracciones?");// iria dentro de ese metodo
		for (Atraccion unaAtraccion : atracciones) {
			String tipo = unaAtraccion.getTipo();
			if (tipo.equalsIgnoreCase(tipoAtraccion)) {
				
				sugiereUnaAtraccion(usuario, unaAtraccion);
			}

		}
	}
	
	public static void ofreceOtrasAtracciones(Usuario usuario) {
		ArrayList<Atraccion> atracciones = LeeAtracciones.getListaAtracciones();
		System.out.println("Te interesa alguna de las siguientes Atracciones?");// iria dentro de ese metodo
		for (Atraccion unaAtraccion : atracciones) {
			sugiereUnaAtraccion(usuario, unaAtraccion);
		}
	}

	public static void sugiereUnaAtraccion(Usuario usuario, Atraccion unaAtraccion) {
		if (unaAtraccion.puedeComprar(usuario)) {
		System.out.println("*-*-*-*-*-*-*-*-*");
		System.out.println("Lleva " + unaAtraccion.getNombre() + " Por " + unaAtraccion.getMonto() + "  Monedas" );
		System.out.println("*-*-*-*-*-*-*-*-*");
		System.out.println("");
		System.out.println("¿Te gustaria adquirir " + unaAtraccion.getNombre() + "? si / no ");
		aceptaAtraccion(unaAtraccion);
		System.out.println("");
		
		}
	}

	public static boolean isAceptada() {
		return aceptada;
	}

	public static void setAceptada(boolean estado) {
		Atraccion.aceptada = estado;
	}

	

	

	@Override
	public Boolean puedeComprar(Usuario usuario) {
		return ((!isAceptada())||cupo>0||usuario.getTiempo()>this.getTiempo()||usuario.getMonedas()>this.getMonto());
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
