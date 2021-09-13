package tierramedia;

import java.io.IOException;

public class TMApp {

	public static void main(String[] args) throws IOException {

		LeeUsuarios.leeUsuarios();

		Atraccion.ordenarAtraccionesPorTipo();
		
		Promocion.armarListasdePromos();
		System.out.println(Promocion.getListaDePromos());
		
		
		for (Usuarios usuario : LeeUsuarios.getListaUsuarios()) {
			Usuarios.darBienvenida(usuario);
			
			Promocion.ofrecerPromo(usuario.tipoAtraccion); 
			
			//FIXME llego a ofrecer promos :) 
			
			//TODO un metodo que guarde las promos que se aceptan y luego uno que las imprima 
			
			//System.out.println(listaDePromosAceptadas);       -idea de prueba-
		}

				
	}
}
