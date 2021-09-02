package tierramedia;

import java.io.*;

public class LeeAtracciones {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			
			fr = new FileReader("TMFiles/Atracciones.txt");
			br = new BufferedReader(fr);
			
			String linea = br.readLine();
			while ((linea != null)) {
				
				String[] actividad = linea.split(",");
				Atraccion detalle = new Atraccion (actividad[0], actividad[1], actividad[2], actividad[3], actividad[4]);
				System.out.println(detalle.toString());//lo use para ver que ande bien el constructor
				
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
