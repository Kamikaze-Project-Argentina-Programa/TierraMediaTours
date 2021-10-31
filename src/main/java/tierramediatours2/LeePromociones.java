package tierramediatours2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia2.dao.AtraccionesDAO;
import tierramedia2.dao.PromocionesDAO;
import tierramedia2.db.ConnectionProvider;

public class LeePromociones {
	private static boolean aceptada;
	private String tipo_pack;
	private Float desc_prom;
	private String atraccion1;
	private Integer cupo1;
	private String atraccion2;
	private Integer cupo2;
	private String atraccion3;
	private Integer cupo3;

	public Integer getCupo1() {
		return cupo1;
	}

	public void setCupo1(Integer cupo1) {
		this.cupo1 = cupo1;
	}

	public Integer getCupo2() {
		return cupo2;
	}

	public void setCupo2(Integer cupo2) {
		this.cupo2 = cupo2;
	}

	public Integer getCupo3() {
		return cupo3;
	}

	public void setCupo3(Integer cupo3) {
		this.cupo3 = cupo3;
	}

	public String getTipo_pack() {
		return tipo_pack;
	}

	public void setTipo_pack(String tipo_pack) {
		this.tipo_pack = tipo_pack;
	}

	public Float getDesc_prom() {
		return desc_prom;
	}

	public void setDesc_prom(Float desc_prom) {
		this.desc_prom = desc_prom;
	}

	public String getAtraccion1() {
		return atraccion1;
	}

	public void setAtraccion1(String atraccion1) {
		this.atraccion1 = atraccion1;
	}

	public String getAtraccion2() {
		return atraccion2;
	}

	public void setAtraccion2(String atraccion2) {
		this.atraccion2 = atraccion2;
	}

	public String getAtraccion3() {
		return atraccion3;
	}

	public void setAtraccion3(String atraccion3) {
		this.atraccion3 = atraccion3;
	}

	public LeePromociones(String tipo_pack, Float desc_prom, String atraccion1, Integer cupo1, String atraccion2,
			Integer cupo2, String atraccion3, Integer cupo3) {
		super();
		this.tipo_pack = tipo_pack;
		this.desc_prom = desc_prom;
		this.atraccion1 = atraccion1;
		this.cupo1 = cupo1;
		this.atraccion2 = atraccion2;
		this.cupo2 = cupo2;
		this.atraccion3 = atraccion3;
		this.cupo3 = cupo3;
	}

	@Override
	public String toString() {
		return "LeePromociones [tipo_pack=" + tipo_pack + ", desc_prom=" + desc_prom + ", atraccion1=" + atraccion1
				+ ", cupo1=" + cupo1 + ", atraccion2=" + atraccion2 + ", cupo2=" + cupo2 + ", atraccion3=" + atraccion3
				+ ", cupo3=" + cupo3 + "]";
	}

	public static void ofrecePromociones(String id_tipo_atraccion, LeeUsuarios leeUsuarios) throws SQLException {

		List<LeePromociones> losLeePromociones = PromocionesDAO.findByTipoPack(leeUsuarios.getId_tipo_atraccion());
		List<LeeAtracciones> losLeeAtracciones = AtraccionesDAO.findByTipo(id_tipo_atraccion);
		System.out.println("La siguiente promocion podria interesarte...");
		for (LeeAtracciones leeAtracciones : losLeeAtracciones) {
			for (LeePromociones leePromociones : losLeePromociones) {
				sugiereUnaPromocion(leeUsuarios, leePromociones, leeAtracciones);
			}

		}

	}

	public static void sugiereUnaPromocion(LeeUsuarios leeUsuarios, LeePromociones leePromociones,
			LeeAtracciones leeAtracciones) {

		if (leePromociones.puedeComprar(leeUsuarios, leeAtracciones)) {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("Te ofrecemos " + leePromociones.getAtraccion1() + " y " + leePromociones.getAtraccion2()
					+ " por " + leePromociones.getDesc_prom() + " monedas.");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("");
			System.out.println("¿Te gustaria adquirir la promocion " + leePromociones.getTipo_pack() + "? si / no ");
			aceptaPromociones(leePromociones, leeUsuarios, leeAtracciones);
			System.out.println("");
			System.out.println("Saldo actual: " + leeUsuarios.getSaldo() + " monedas");
			System.out.println("");
		}

	}

	public static void aceptaPromociones(LeePromociones leePromociones, LeeUsuarios leeUsuarios,
			LeeAtracciones leeAtracciones) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Itinerarios itinerarios = new Itinerarios();

		ArrayList<LeePromociones> promosAceptadas = LeeUsuarios.listaDePromosPromociones;
		setAceptada(false);

		try {
			String respuesta = br.readLine();
			if (respuesta.equalsIgnoreCase("si")) {
				setAceptada(true);
				promosAceptadas.add(leePromociones);
				System.out.println("Aceptaste la promocion: " + leePromociones.getTipo_pack());
				leePromociones.bajarCupo();
				leeUsuarios.gastarMonedas(leeAtracciones);
				leeUsuarios.gastarTiempo(leeAtracciones);
				itinerarios.insertPromos(leeUsuarios, leeAtracciones);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			System.out.println("Entendido ¡Gracias por tu respuesta!");
		}

	}

	public Boolean puedeComprar(LeeUsuarios leeUsuarios, LeeAtracciones leeAtracciones) {

		return (leeAtracciones.getCupo() > 0 && leeUsuarios.getTiempo_dispo() > leeAtracciones.getTiempo()
				&& leeUsuarios.getSaldo() >= leeAtracciones.getCosto() && leeUsuarios.getSaldo() != 0);

	}

	public static boolean esAceptada() {
		return aceptada;
	}

	public static void setAceptada(boolean aceptada) {
		LeePromociones.aceptada = aceptada;

	}

	protected int bajarCupo() throws SQLException {
		this.cupo1 -= 1;
		this.cupo2 -= 1;
		Connection connection = ConnectionProvider.getConnection();

		String query = "UPDATE atracciones\r\n" + "SET cupo = cupo - 1\r\n" + "WHERE nombre = ? OR nombre = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, this.getAtraccion1());
		preparedStatement.setString(2, this.getAtraccion2());

		int rowsUpdated = preparedStatement.executeUpdate();

		return rowsUpdated;
	}
}
