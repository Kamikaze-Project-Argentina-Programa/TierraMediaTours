package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeePromos {
	
	static List<String> promoX = new ArrayList<String>();

	public static void leePromos() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("TMFiles/Promos.txt");
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while ((linea != null)) {
				
				String[] promo = linea.split(",");
				for (int i = 0; i < promo.length; i++) {
					promoX.add(promo[i]);
				}
				
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

	/* protected static void armarPromos(List<String> promo) {
		 
		if (promo.get(0) == "Descuento") {			
			Promos promoX = new Porcentual(promo.get(1), promo.get(2), promo.get(3), Integer.parseInt(promo.get(4)));
			System.out.println(promoX.toString());
		} else {
			if (promo.get(0) == "Combo") {
				Promos promoX = new AxB(promo.get(1), promo.get(2), promo.get(3), promo.get(4));
				System.out.println(promoX.toString());
			} else {
				if (promo.get(0) == "Final") {
					Promos promoX = new Absoluta(promo.get(1), promo.get(2), promo.get(3),
							Integer.parseInt(promo.get(4)));
					System.out.println(promoX.toString());
				}
			}
		}
	}*/
	
}
