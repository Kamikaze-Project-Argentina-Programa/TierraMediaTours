package tierramedia;

public class TMApp {

	public static void main(String[] args) {

		//LeeUsuarios.leeUsuarios();
		//System.out.println("Lista Promocion------------------------");
		Promocion.ordenarListasdePromos();

		//System.out.println("Lista Atracciones------------------------");
		Atraccion.ordenarAtraccionesPorTipo();
		//for (Usuarios usuario : LeeUsuarios.getListaUsuarios()) {
			//Usuarios.darBienvenida(usuario);
			
			//Promocion.ofrecerPromo(usuario.atraccion);
			/*ya tengo actividades separadas por tipo
			hay que ver como le pedimos al constructor 
			de promos que del nombre de la promo en el string
			invoque al objeto que se llame igual :/  */
			
		//}

		Promocion.crearPromocion(LeePromos.getListaPromos(),LeeAtracciones.getListaActividades());		
		System.out.println(Promocion.getListaDePromos());
	}
}
