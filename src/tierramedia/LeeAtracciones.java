package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeeAtracciones {
	protected static List<Atraccion> listaActividades = new ArrayList<Atraccion>();
	protected static ArrayList<Atraccion> actiAventura;
	protected static ArrayList<Atraccion> actiDegustacion;
	protected static ArrayList<Atraccion> actiPaisaje;

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
				listaActividades.add(atraccion);

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

	protected static List<Atraccion> getListaActividades() {
		return listaActividades;
	}

	
	public static void ordenaTipoAtracciones() {
		actiAventura = new ArrayList<Atraccion>();
		actiDegustacion = new ArrayList<Atraccion>();
		actiPaisaje = new ArrayList<Atraccion>();

		for (Atraccion act : getListaActividades()) {
			if (act.getTipo().equalsIgnoreCase("Aventura")) {
				actiAventura.add(act);
			} else {
				if (act.getTipo().equalsIgnoreCase("Degustacion")) {
					actiDegustacion.add(act);
				} else {
					if (act.getTipo().equalsIgnoreCase("Paisaje")) {
						actiPaisaje.add(act);
					}
				}
			}
		}
	System.out.println(actiAventura);
	System.out.println(actiDegustacion);
	System.out.println(actiPaisaje);
	}
}
