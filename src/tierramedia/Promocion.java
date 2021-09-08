package tierramedia;

import java.util.ArrayList;
import java.util.List;

public abstract class Promocion {
	protected String tipo;
	public double monto;
	public static ArrayList<Promocion> listaDePromos;

	protected Promocion() {
		super();
	}

	abstract protected double calcularMonto();

	public double getMonto() {
		return this.calcularMonto();
	}

	protected static void ordenarListasdePromos() {
		LeePromos.leePromos();
		LeePromos.getListaPromos();
		LeePromos.ordenaTipoPromos();
	}

	public static void crearPromocion(List<List<String>> list,
			ArrayList<Atraccion> listaAtracciones) {
		String tipoAventura = TipoAtraccion.AVENTURA.name();
		String tipoDegustacion = TipoAtraccion.DEGUSTACION.name();
		String tipoPaisaje = TipoAtraccion.PAISAJE.name();
		String tipoPorcentual = TipoPromo.DESCUENTO.name();
		String tipoAxB = TipoPromo.COMBO.name();
		String tipoAbsoluta = TipoPromo.FINAL.name();

		listaDePromos = new ArrayList<Promocion> ();
		
		for (List<String> promo : list) {
			ArrayList<Atraccion> atraccDeLaPromo = new ArrayList<Atraccion>();

			String tipoPromo = promo.get(0);
			String tipoActPromo = promo.get(1);

			if (tipoPromo.equalsIgnoreCase(tipoPorcentual)) {

				comparaListaAtraccionesPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo,
						atraccDeLaPromo, tipoActPromo);

				Porcentual promoPor = new Porcentual (tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
						Integer.parseInt(promo.get(4)));
				listaDePromos.add(promoPor);
				
			} else {
				
				if (tipoPromo.equalsIgnoreCase(tipoAxB)) {
					
					comparaListaAtraccionesPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo,
							atraccDeLaPromo, tipoActPromo);

					AxB promoAB = new AxB (tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),atraccDeLaPromo.get(1));
					listaDePromos.add(promoAB);
					
				} else {
					
					if (tipoPromo.equalsIgnoreCase(tipoAbsoluta)) {
						
						comparaListaAtraccionesPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo,
								atraccDeLaPromo, tipoActPromo);

						Absoluta promoAbsol = new Absoluta (tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),Integer.parseInt(promo.get(4)));
						listaDePromos.add(promoAbsol);
						
					}
				}
			}
		}
	}
	
	public static ArrayList<Promocion> getListaDePromos(){
		return listaDePromos ;
	}

	public static void comparaListaAtraccionesPorTipo(ArrayList<Atraccion> listaAtracciones, String tipoAventura,
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
}
