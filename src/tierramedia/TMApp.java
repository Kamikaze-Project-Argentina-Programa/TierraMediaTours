package tierramedia;

public class TMApp {

	public static void main(String[] args) {

		LeeUsuarios.leeUsuarios();
		for (Usuarios usuario : LeeUsuarios.getListaUsuarios()) {
			Usuarios.darBienvenida(usuario);
			
			//ya tengo actividades separadas por tipo
			//hay que ver como le pedimos al constructor 
			//de promos que del nombre de la promo en el string
			//invoque al objeto que se llame igual :/  
			
		}
		
	}
}
