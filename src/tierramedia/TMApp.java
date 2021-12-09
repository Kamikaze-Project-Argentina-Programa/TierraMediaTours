package tierramedia;

import java.io.IOException;

public class TMApp {

	public static void main(String[] args) throws IOException {

		LeeUsuarios.leeUsuarios();

		Atraccion.ordenarAtraccionesPorTipo();
		
		
		//System.out.println(Promocion.getListaDePromos());
		
		
		for (Usuario usuario : LeeUsuarios.getListaUsuarios()) {
			Usuario.darBienvenida(usuario);
			
			Promocion.ofrecePromociones(usuario.tipoAtraccion, usuario); 
			// Metodo que resta a Usuario lo que consume cada pack
			//Si le queda tiempo y dinero entonces
			//Metodo que ofrece otras atracciones individuales que no haya comprado ya
			
			
			Atraccion.ofreceAtracciones(usuario.tipoAtraccion, usuario);
			
			Atraccion.ofreceOtrasAtracciones(usuario);
			
			// para ver que estoy ofreciendo
			Usuario.imprimePromos();
			Usuario.imprimeAtracciones();
			
			Itinerario.imprimeItinerario(usuario);
			
			System.out.println("");
			System.out.println("Gracias por elegir nuestros servicios, "+ usuario.getNombre() +"!" );
			System.out.println("");
		}

				
	}

	
}
