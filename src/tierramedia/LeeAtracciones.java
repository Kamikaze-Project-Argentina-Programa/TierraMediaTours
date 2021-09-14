package tierramedia;

import java.io.*;
import java.util.ArrayList;

public class LeeAtracciones {
	protected static ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

	public static void leeAtracciones() {
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader("TMFiles/Atracciones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {

				String[] actividad = linea.split(",");
				Atraccion atraccion = new Atraccion(actividad[0], Integer.parseInt(actividad[1]),
						Double.parseDouble(actividad[2]), Integer.parseInt(actividad[3]), actividad[4]);
				listaAtracciones.add(atraccion);

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

	public static ArrayList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}

}
