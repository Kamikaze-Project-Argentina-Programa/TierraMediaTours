package tierramedia;

import java.io.*;

public class LeeUsuarios {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader("TMFiles/Usuarios.txt");
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea = br.readLine();

			while ((linea != null)) {

				darBienvenida(linea);
				//ofrecer promos
				//imprimir itinerario
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

	protected static void darBienvenida(String linea) {
		String[] perfil = linea.split(",");
		Usuarios usuario = new Usuarios(perfil[0], perfil[1],Integer.parseInt(perfil[2]), Double.parseDouble(perfil[3]));
		System.out.println("Bienvenidx " + usuario.nombre +"!!" ); //lo use para ver que ande bien el constructor
		System.out.println("¿Te gustan las atracciones de tipo " + usuario.atraccion + "?");
		System.out.println("¡Entonces tenemos estas promos para vos!");
	}

}
