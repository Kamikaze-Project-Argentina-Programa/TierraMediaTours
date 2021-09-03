package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeeAtracciones {
	public static void main(String[] args) {
		//public static void leeAtracciones() {
		
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader("TMFiles/Atracciones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			List<Atraccion> listaActividades = new ArrayList<Atraccion>();
			
			while ((linea != null)) {

				Atraccion atraccion = crearActividades(linea);
				
				listaActividades.add(atraccion);
				
				
				linea = br.readLine();
			}
			
			System.out.println(listaActividades);// lo use para ver que ande bien el constructor
			
			
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

	
	protected static Atraccion crearActividades(String linea) {
		String[] actividad = linea.split(",");
		Atraccion atraccion = new Atraccion(actividad[0], Integer.parseInt(actividad[1]),
				Double.parseDouble(actividad[2]), Integer.parseInt(actividad[3]), actividad[4]);
		return atraccion;
	}
}