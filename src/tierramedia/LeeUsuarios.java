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

				String[] perfil = linea.split(",");
				Usuarios user = new Usuarios(perfil[0], perfil[1], perfil[2], perfil[3]);
				System.out.println("Bienvenidx " + user.nombre +"!!" ); //lo use para ver que ande bien el constructor
				System.out.println("¿Te gustan las atracciones de tipo " + user.atraccion + "?");
				System.out.println("¡Entonces tenemos estas promos para vos!");
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

}
