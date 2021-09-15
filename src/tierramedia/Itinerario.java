package tierramedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Itinerario {

	public static void imprimeItinerario(Usuario usuario) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter("TMFiles/" + usuario.getNombre() + ".txt"));

		salida.println("Hola " + usuario.getNombre() + "!");
		salida.println("Estas llevando:");

		for (Promocion promo : Usuario.getListaDePromosAceptadas()) {
			salida.println("Promo " + promo.getPromo());
			salida.println("Monto: " + promo.getMonto() +" monedas.");
			salida.println("Duracion: " + promo.getTiempo() +" horas.");
			salida.println("");
	
		}
		Usuario.getListaDePromosAceptadas().clear();
		
		for (Atraccion act : Usuario.getListaDeAtracAceptadas()) {
			salida.println("Atraccion " + act.getNombre());
			salida.println("Monto: " + act.getMonto() +" monedas.");
			salida.println("Duracion: " + act.getTiempo() +" horas.");
			salida.println("");
		}
		Usuario.getListaDeAtracAceptadas().clear();

		salida.close();

	}

}
