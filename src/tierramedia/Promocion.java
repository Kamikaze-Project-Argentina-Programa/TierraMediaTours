package tierramedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Promocion {
	public String tipoAtraccion;
	public double monto;
	public static ArrayList<Promocion> listaDePromos;
	public String respuesta;
	public static ArrayList<Promocion> listaDePromosAceptadas;

	protected Promocion() {
		super();
	}

	abstract protected double calcularMonto();
	
	abstract public String getPromo();

	public double getMonto() {
		return this.calcularMonto();
	}
	
	public String getTipo() {
		return tipoAtraccion;
	}

	protected static void armarListasdePromos() {
		LeePromos.leePromos();
		LeePromos.getListaPromos();
		crearPromosylistar();
	}

	public static void crearPromosylistar() {
		String tipoAventura = TipoAtraccion.AVENTURA.name();
		String tipoDegustacion = TipoAtraccion.DEGUSTACION.name();
		String tipoPaisaje = TipoAtraccion.PAISAJE.name();
		String tipoPorcentual = TipoPromo.DESCUENTO.name();
		String tipoAxB = TipoPromo.COMBO.name();
		String tipoAbsoluta = TipoPromo.FINAL.name();

		listaDePromos = new ArrayList<Promocion>();
		ArrayList<List<String>> list = LeePromos.getListaPromos();
		ArrayList<Atraccion> listaAtracciones = LeeAtracciones.getListaActividades();

		for (List<String> promo : list) {
			ArrayList<Atraccion> atraccDeLaPromo = new ArrayList<Atraccion>();

			String tipoPromo = promo.get(0);
			String tipoActPromo = promo.get(1);

			if (tipoPromo.equalsIgnoreCase(tipoPorcentual)) {

				comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo, atraccDeLaPromo,
						tipoActPromo);

				Porcentual promoPor = new Porcentual(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
						Integer.parseInt(promo.get(4)));
				listaDePromos.add(promoPor);

			} else {

				if (tipoPromo.equalsIgnoreCase(tipoAxB)) {

					comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo, atraccDeLaPromo,
							tipoActPromo);

					AxB promoAB = new AxB(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
							atraccDeLaPromo.get(2));
					listaDePromos.add(promoAB);

				} else {

					if (tipoPromo.equalsIgnoreCase(tipoAbsoluta)) {

						comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo,
								atraccDeLaPromo, tipoActPromo);

						Absoluta promoAbsol = new Absoluta(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
								Integer.parseInt(promo.get(4)));
						listaDePromos.add(promoAbsol);

					}
				}
			}
		}
	}

	public static ArrayList<Promocion> getListaDePromos() {
		return listaDePromos;
	}

	public static void comparaPorTipo(ArrayList<Atraccion> listaAtracciones, String tipoAventura,
			String tipoDegustacion, String tipoPaisaje, List<String> promo, ArrayList<Atraccion> atraccDeLaPromo,
			String tipoActPromo) {
		for (Atraccion atraccion : listaAtracciones) {
			for (String parametroDelaPromo : promo) {

				if (tipoActPromo.equalsIgnoreCase(tipoAventura)) {

					comparaListaAtracciones(atraccDeLaPromo, parametroDelaPromo, atraccion);

				} else {
					if (tipoActPromo.equalsIgnoreCase(tipoDegustacion)) {

						comparaListaAtracciones(atraccDeLaPromo, parametroDelaPromo, atraccion);

					} else {
						if (tipoActPromo.equalsIgnoreCase(tipoPaisaje)) {

							comparaListaAtracciones(atraccDeLaPromo, parametroDelaPromo, atraccion);
						}
					}
				}
			}
		}
	}

	public static void comparaListaAtracciones(ArrayList<Atraccion> atraccDeLaPromo, String parametroDelaPromo,
			Atraccion atracc) {
		if (parametroDelaPromo.equalsIgnoreCase(atracc.getNombre())) {
			atraccDeLaPromo.add(atracc);
		}
	}

	public static void ofrecerPromo(String tipoAtraccion) throws IOException {
		
		ArrayList<Promocion> promos = Promocion.getListaDePromos();
		ArrayList<Promocion> promosAceptadas = Promocion.getListaDePromosAceptadas();
		
		for (Promocion unaPromo : promos) {
			String tipo = unaPromo.getTipo();
			if (tipo.equalsIgnoreCase(tipoAtraccion)) {
				System.out.println(unaPromo.getPromo());
				System.out.println("");
				System.out.println("¿Te gustaría adquirir este paquete?");
				System.out.println("");
				
			//metodo que pregunte si desea adquirir y que si la respuesta es sí que lo guarde en otra lista que la app mostraría
			/* 
			public Boolean aceptaPromo(String respuesta) {
				respuesta = false;
				this.respuesta = respuesta.toLowerCase();
				if (respuesta = "si") {
					aceptaPromo = true;
					listaDePromosAceptadas.add(unaPromo);
				}
			}
			*/
				//entrada por pantalla
			}
		}
	}
	
	public static ArrayList<Promocion> getListaDePromosAceptadas() {
		return listaDePromosAceptadas;
	}
}
