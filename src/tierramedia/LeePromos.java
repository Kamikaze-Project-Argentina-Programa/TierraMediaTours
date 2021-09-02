package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeePromos {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("TMFiles/Promos.txt");
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while ((linea != null)) {
				List<String> promoX = new ArrayList<String>();
				String[] promo = linea.split(",");

				for (int i = 0; i < promo.length; i++) {
					promoX.add(promo[i]);
				}
					
				//System.out.println(promoX.get(promo.length-1));//el ultimo lugar
				System.out.println(promoX);
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
}
