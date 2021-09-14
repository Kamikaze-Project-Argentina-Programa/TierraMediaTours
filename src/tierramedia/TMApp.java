package tierramedia;

import java.io.IOException;

public class TMApp {

	public static void main(String[] args) throws IOException {

		LeeUsuarios.leeUsuarios();

		Atraccion.ordenarAtraccionesPorTipo();
		
		Promocion.armarListasdePromos();
		//System.out.println(Promocion.getListaDePromos());
		
		
		for (Usuario usuario : LeeUsuarios.getListaUsuarios()) {
			Usuario.darBienvenida(usuario);
			
			Promocion.ofrecePromociones(usuario.tipoAtraccion); 
			// Metodo que resta a Usuario lo que consume cada pack
			//Si le queda tiempo y dinero entonces
			//Metodo que ofrece otras atracciones individuales que no haya comprado ya
			
			
			Atraccion.ofreceAtracciones(usuario.tipoAtraccion, usuario);
			
			Atraccion.ofreceOtrasAtracciones(usuario);
			
			Usuario.imprimePromos();
			Usuario.imprimeAtracciones();
		}

				
	}

	
}
