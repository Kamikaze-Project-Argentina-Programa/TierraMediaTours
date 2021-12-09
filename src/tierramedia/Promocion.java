package tierramedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Promocion implements Adquirible {
	public String tipoAtraccion;
	public double monto;
	private static Boolean promoAceptada;
	public static ArrayList<Promocion> listaDePromos;
	

	public Promocion() {
		super();
	}

	abstract public double calcularMonto();

	abstract public String getPromo();
	
	abstract public double getTiempo() ;

	public double getMonto() {
		return this.calcularMonto();
	}

	public String getTipo() {
		return tipoAtraccion;
	}

	public static Boolean getPromoAceptada() {
		return promoAceptada;
	}

	public static void setPromoAceptada(Boolean promoAceptada) {
		Promocion.promoAceptada = promoAceptada;
	}

	public static void armarListasdePromos() {
		LeePromos.leePromos();
		LeePromos.getListaPromos();
		LeePromos.crearPromosyArmarLista();
	}

	public static ArrayList<Promocion> getListaDePromos() {
		return Promocion.listaDePromos;
	}

	public static void ofrecePromociones(String tipoAtraccion, Usuario usuario) throws IOException {
		ArrayList<Promocion> promos = getListaDePromos();

		for (Promocion unaPromo : promos) {
			String tipo = unaPromo.getTipo();
			if (tipo.equalsIgnoreCase(tipoAtraccion)) {
				// metodo que confirma si tiene tiempo y plata para comprar
				// if (puedeComprar) => ofrece
				System.out.println("");
				System.out.println("*-*-*-*-*-*-*-*-*");
				System.out.println("Lleva " + unaPromo.getPromo());
				System.out.println("*-*-*-*-*-*-*-*-*");
				System.out.println("");
				System.out.println("¿Te gustaria adquirir este paquete? si / no ");
				
				aceptaPromo(unaPromo,usuario);
				
				System.out.println("");
			}
			
		}
	}

	// metodo que pregunte si desea adquirir y que si la respuesta es si que lo
	// guarde en otra lista que la app muestra

	public static void aceptaPromo(Promocion unaPromo, Usuario usuario) {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		ArrayList<Promocion> promosAceptadas = Usuario.listaDePromosAceptadas;
		setPromoAceptada(false);
		
		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				setPromoAceptada(true);
				promosAceptadas.add(unaPromo);
				System.out.println("Aceptaste: " + unaPromo.getPromo());
				
				usuario.gastarMonedas(unaPromo.getMonto());
				System.out.println("Tu saldo restante es de "+usuario.getMonedas()+" Monedas!");
				usuario.gastarTiempo(unaPromo.getTiempo());
				System.out.println("Tu Tiempo restante es de "+usuario.getTiempo()+" Horas!");
				
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
