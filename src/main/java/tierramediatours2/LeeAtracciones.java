package tierramediatours2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.dao.AtraccionesDAO;
import tierramedia2.db.ConnectionProvider;

public class LeeAtracciones {

	private static boolean aceptada;
	private Integer id;
	private String nombre;
	private Integer costo;
	private Float tiempo;
	private Integer cupo;
	private String id_tipo_atraccion;

	@Override
	public String toString() {
		return "LeeAtracciones [Id: " + id + ", Nombre: " + nombre + ", Costo: " + costo + ", Tiempo: " + tiempo
				+ ", Cupo: " + cupo + ", Tipo de atraccion: " + id_tipo_atraccion + "]\n";
	}

	public LeeAtracciones(Integer id, String nombre, Integer costo, Float tiempo, Integer cupo,
			String id_tipo_atraccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.id_tipo_atraccion = id_tipo_atraccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Float getTiempo() {
		return tiempo;
	}

	public void setTiempo(Float tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public String getId_tipo_atraccion() {
		return id_tipo_atraccion;
	}

	public void setId_tipo_atraccion(String id_tipo_atraccion) {
		this.id_tipo_atraccion = id_tipo_atraccion;
	}

	public Integer getId() {
		return id;
	}

	public static void ofreceAtraccciones(String id_tipo_atraccion, LeeUsuarios leeUsuarios) throws SQLException {

		List<LeeAtracciones> losLeeAtracciones = AtraccionesDAO.findByTipo(leeUsuarios.getId_tipo_atraccion());
		System.out.println("La siguiente atraccion podria interesarte...");
		for (LeeAtracciones leeAtracciones : losLeeAtracciones) {

			sugiereUnaAtraccion(leeUsuarios, leeAtracciones);

		}
	}

//	public static void ofreceOtrasAtracciones(LeeUsuarios leeUsuarios) throws SQLException {
//		List<LeeAtracciones> losLeeAtracciones = AtraccionesDAO.findByTipo(leeUsuarios.getId_tipo_atraccion());
//		System.out.println("Te interesa alguna de las siguientes Atracciones?");// iria dentro de ese metodo
//		for (LeeAtracciones leeAtracciones : losLeeAtracciones) {
//			if(leeAtracciones.getId_tipo_atraccion().equalsIgnoreCase(leeUsuarios.getId_tipo_atraccion()))
//			sugiereUnaAtraccion(leeUsuarios, leeAtracciones);
//		}
//
//	}

	public static void sugiereUnaAtraccion(LeeUsuarios leeUsuarios, LeeAtracciones leeAtracciones) {
		
		if (leeAtracciones.puedeComprar(leeUsuarios)) {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out
					.println("Te ofrecemos " + leeAtracciones.getNombre() + " por " + leeAtracciones.getCosto() + " monedas.");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("");
			System.out.println("¿Te interesaria adquirirla? si / no");
			aceptaAtraccion(leeAtracciones, leeUsuarios);
			System.out.println("Saldo actual: " + leeUsuarios.getSaldo() + " monedas.");
			System.out.println("");
		}

	}

	public static void aceptaAtraccion(LeeAtracciones leeAtracciones, LeeUsuarios leeUsuarios) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Itinerarios itinerarios = new Itinerarios();

		ArrayList<LeeAtracciones> atraccAceptadas = LeeUsuarios.listaDeAtracAceptadas;
		setAceptada(false);

		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				setAceptada(true);
				atraccAceptadas.add(leeAtracciones);
				leeAtracciones.bajarCupo();
				leeUsuarios.gastarMonedas(leeAtracciones);
				leeUsuarios.gastarTiempo(leeAtracciones);
				itinerarios.insert(leeUsuarios, leeAtracciones);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			System.out.println("Entendido ¡Gracias por tu respuesta!");
			System.out.println("");
		}

	}

	public Boolean puedeComprar(LeeUsuarios leeUsuarios) {

		return (this.getCupo() > 0 && leeUsuarios.getTiempo_dispo() > this.getTiempo()
				&& leeUsuarios.getSaldo() >= this.getCosto() && leeUsuarios.getSaldo() != 0);

	}

	public static boolean esAceptada() {
		return aceptada;
	}

	public static void setAceptada(boolean aceptada) {
		LeeAtracciones.aceptada = aceptada;

	}

	protected int bajarCupo() throws SQLException {
		this.cupo -= 1;
		Connection connection = ConnectionProvider.getConnection();

		String query = "UPDATE atracciones\r\n"
				+ "SET cupo = cupo - 1\r\n"
				+ "WHERE nombre = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, this.getNombre());
		
		int rowsUpdated = preparedStatement.executeUpdate();
		
		return rowsUpdated;
	}

}
