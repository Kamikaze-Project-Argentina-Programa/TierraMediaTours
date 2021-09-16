package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeePromos {
	public static List<String> unaPromo = new ArrayList<String>();
	public static ArrayList<List<String>> listaPromosParam = new ArrayList<>();
	
	
	public static void leePromos() {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> unaPromo;

		try {
			fr = new FileReader("TMFiles/Promos.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();

			while ((linea != null)) {

				unaPromo = Arrays.asList(linea.split(","));
				listaPromosParam.add(unaPromo);
				linea = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static ArrayList<List<String>> getListaPromos() {
		return listaPromosParam;
	}

	public static void crearPromosyArmarLista() {
		String tipoAventura = TipoAtraccion.AVENTURA.name();
		String tipoDegustacion = TipoAtraccion.DEGUSTACION.name();
		String tipoPaisaje = TipoAtraccion.PAISAJE.name();
		String tipoPorcentual = TipoPromo.DESCUENTO.name();
		String tipoAxB = TipoPromo.COMBO.name();
		String tipoAbsoluta = TipoPromo.FINAL.name();

		Promocion.listaDePromos = new ArrayList<Promocion>();
		ArrayList<List<String>> listaParamPromos = LeePromos.getListaPromos();
		ArrayList<Atraccion> listaAtracciones = LeeAtracciones.getListaAtracciones();

		for (List<String> promo : listaParamPromos) {
			ArrayList<Atraccion> atraccDeLaPromo = new ArrayList<Atraccion>();

			String tipoPromo = promo.get(0);
			String tipoActPromo = promo.get(1);

			if (tipoPromo.equalsIgnoreCase(tipoPorcentual)) {

				comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo, atraccDeLaPromo,
						tipoActPromo);

				Porcentual promoPor = new Porcentual(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
						Integer.parseInt(promo.get(4)));
				Promocion.listaDePromos.add(promoPor);

			} else {

				if (tipoPromo.equalsIgnoreCase(tipoAxB)) {

					comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo, atraccDeLaPromo,
							tipoActPromo);

					AxB promoAB = new AxB(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
							atraccDeLaPromo.get(2));
					Promocion.listaDePromos.add(promoAB);

				} else {

					if (tipoPromo.equalsIgnoreCase(tipoAbsoluta)) {

						comparaPorTipo(listaAtracciones, tipoAventura, tipoDegustacion, tipoPaisaje, promo,
								atraccDeLaPromo, tipoActPromo);

						Absoluta promoAbsol = new Absoluta(tipoActPromo, atraccDeLaPromo.get(0), atraccDeLaPromo.get(1),
								Integer.parseInt(promo.get(4)));
						Promocion.listaDePromos.add(promoAbsol);

					}
				}
			}
		}
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
	
}
