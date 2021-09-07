package tierramedia;

import java.util.ArrayList;
import java.util.List;

public abstract class Promos {
	protected String tipo;
	public double monto;

	protected Promos() {
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

	protected static void crearPromosPorTipo(ArrayList<List<String>> listaPromosporTipo) {

		for (List<String> promo : listaPromosporTipo) {
			// for (int i = 0; i < listaPromosporTipo.size(); i++) {

			String tipoPromo = promo.get(0);
			String tipoActPromo = promo.get(1);
			ArrayList<Atraccion> listaAtracciones;
			ArrayList<Atraccion> atraccionesDelaPromo = new ArrayList<Atraccion>();

			if (tipoPromo.equalsIgnoreCase(TipoPromo.DESCUENTO.name())) {

				System.out.println("Promo Porcentual true");
				listaAtracciones = Atraccion.getActiAventura();

				if (tipoActPromo.equalsIgnoreCase(TipoAtraccion.AVENTURA.name())) {
					System.out.println(tipoActPromo + " True");

					for (int j = 0; j > promo.size(); j++) {
						String paramActividad = promo.get(j);

						for (Atraccion atrc : listaAtracciones) {
							if (paramActividad.equals(atrc.getNombre())) {
								atraccionesDelaPromo.add(atrc);
								System.out.println("Agrega atraccion" + atraccionesDelaPromo);

							}
							int monto = Integer.parseInt(promo.get(4));
							Porcentual promoPorcentual = new Porcentual(tipoActPromo, atraccionesDelaPromo.get(0),
									atraccionesDelaPromo.get(1), monto);
							List<Porcentual> listaPorcentuales = new ArrayList<Porcentual>();
							listaPorcentuales.add(promoPorcentual);
							System.out.println("Agrega promo" + listaPorcentuales);
						}
					}

				} else {
					if (tipoActPromo.equalsIgnoreCase(TipoAtraccion.DEGUSTACION.name())) {
						System.out.println(tipoActPromo + " True");

						for (int j = 0; j > promo.size(); j++) {
							String paramActividad = promo.get(j);

							for (Atraccion atrc : listaAtracciones) {
								if (paramActividad.equals(atrc.getNombre())) {
									atraccionesDelaPromo.add(atrc);
									System.out.println("Agrega atraccion" + atraccionesDelaPromo);
								}
							}
						} // hasa aca llega el for
					} else {
						if (tipoActPromo.equalsIgnoreCase(TipoAtraccion.PAISAJE.name())) {
							System.out.println(tipoActPromo + " True");

							for (int j = 0; j > promo.size(); j++) {
								String paramActividad = promo.get(j);

								for (Atraccion atrc : listaAtracciones) {
									if (paramActividad.equals(atrc.getNombre())) {
										atraccionesDelaPromo.add(atrc);
										System.out.println("Agrega atraccion" + atraccionesDelaPromo);
									}
								}
							}
						}
					}
				}
			} else {
				if (tipoPromo.equals("Combo")) {
					System.out.println("Promos AxB true");
				} else {
					if (tipoPromo.equals("Final")) {
						System.out.println("Promos Absoluta true");
					}
				}
			}
		}
	}
}
