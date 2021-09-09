package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeePromos {
	protected static List<String> promoX = new ArrayList<String>();
	protected static ArrayList<List<String>> listaPromos = new ArrayList<>();
	protected static ArrayList<List<String>> prPorcentual;
	protected static ArrayList<List<String>> prAbsoluta;
	protected static ArrayList<List<String>> prAxB;

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
				listaPromos.add(unaPromo);
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

	protected static ArrayList<List<String>> getListaPromos() {
		return listaPromos;
	}

}
