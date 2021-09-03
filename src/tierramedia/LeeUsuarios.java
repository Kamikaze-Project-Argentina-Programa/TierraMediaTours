package tierramedia;

import java.io.*;


public class LeeUsuarios {

	public static void main(String[] args) {
		//public static void leeUsuarios() {
			
			FileReader fr = null;
			BufferedReader br = null;

			try {

				fr = new FileReader("TMFiles/Usuarios.txt");
				br = new BufferedReader(fr);

				// Lectura del fichero
				String linea = br.readLine();

				while ((linea != null)) {
					// lee perfil de usuario
					Usuarios user = darBienvenida(linea);
					System.out.println(user);
					
					LeeAtracciones.main(args);
					
			
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

			protected static Usuarios darBienvenida(String linea) {
				Usuarios usuario;
				String[] perfil = linea.split(",");
				usuario = new Usuarios(perfil[0], perfil[1],Integer.parseInt(perfil[2]), Double.parseDouble(perfil[3]));
				System.out.println("Bienvenidx " + usuario.nombre +"!!" ); 
				System.out.println("¿Te gustan las atracciones de tipoAtraccion " + usuario.atraccion + "?");
				System.out.println("¡Entonces tenemos estas promos para vos!");
				System.out.println("-------------");
				return usuario;
			}
	}