package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeeUsuarios {
	
	protected static List<Usuarios> listaUsuarios = new ArrayList<>();

	protected static void leeUsuarios() {

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader("TMFiles/Usuarios.txt");
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea = br.readLine();

			while ((linea != null)) {
				
				String[] perfil = linea.split(",");
				Usuarios usuario = new Usuarios(perfil[0], perfil[1], Integer.parseInt(perfil[2]), Double.parseDouble(perfil[3]));
				listaUsuarios.add(usuario);
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

	protected static List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

}