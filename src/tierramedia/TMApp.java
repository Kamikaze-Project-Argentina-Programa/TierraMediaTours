 package tierramedia;

import java.io.IOException;

public class TMApp {

	public static void main(String[] args) throws IOException {

		LeeUsuarios.leeUsuarios();

		Atraccion.ordenarAtraccionesPorTipo();
		
		for (Usuario usuario : LeeUsuarios.getListaUsuarios()) {
			Usuario.darBienvenida(usuario);
			
			Promocion.ofrecePromociones(usuario, Usuario.tipoAtraccion); 
			
			Atraccion.ofreceAtraccionesPreferidas(usuario, Usuario.tipoAtraccion);
			
			Atraccion.ofreceOtrasAtracciones(usuario);
			
			Usuario.imprimePromos();
			Usuario.imprimeAtracciones();
		}

				
	}

	
}
