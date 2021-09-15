package tierramedia;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Promocion implements Adquirible {
	private String tipoAtraccion;
	protected double monto;
	private static Boolean promoAceptada;
	public static ArrayList<Promocion> listaDePromos;

	protected Promocion() {
		super();
	}

	abstract public Atraccion[] getAtracciones();

	abstract protected double calcularMonto();

	abstract public String getPromo();

	public double getMonto() {
		return this.calcularMonto();
	}
	abstract public double getTiempo();
	
	
	
	public String getTipo() {
		return tipoAtraccion;
	}

	public static Boolean isPromoAceptada() {
		return promoAceptada;
	}

	public static void setPromoAceptada(Promocion promo, Boolean estado) {
		Promocion.promoAceptada = estado;
		for (Atraccion atraccionAceptada : promo.getAtracciones()) {
			Atraccion.setAceptada(atraccionAceptada, estado);
		}

	}

	public static void armarListasdePromos() {
		LeePromos.leePromos();
		LeePromos.getListaPromos();
		LeePromos.crearPromosyArmarLista();
	}

	public static ArrayList<Promocion> getListaDePromos() {
		return Promocion.listaDePromos;
	}

	public static void ofrecePromociones(Usuario usuario, String tipoAtraccion) throws IOException {
		ArrayList<Promocion> promos = getListaDePromos();

		for (Promocion unaPromo : promos) {
			String tipo = unaPromo.getTipo();
			
			if (tipo.equalsIgnoreCase(tipoAtraccion)) {

				if (unaPromo.puedeComprar(usuario)) {

					System.out.println("*-*-*-*-*-*-*-*-*");
					System.out.println("Lleva " + unaPromo.getPromo());
					System.out.println("*-*-*-*-*-*-*-*-*");
					System.out.println("");
					System.out.println("¿Te gustaria adquirir este paquete? si / no ");

					Usuario.aceptaPromo(unaPromo);
					
					System.out.println("");
				} else {
					System.out.println("No puede comprar " + unaPromo.getPromo());//
				}
			}
		}
	}

}
