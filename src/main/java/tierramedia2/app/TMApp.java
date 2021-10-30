package tierramedia2.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import tierramedia2.dao.AtraccionesDAO;
import tierramedia2.dao.UsuariosDAO;
import tierramediatours2.LeeAtracciones;
import tierramediatours2.LeePromociones;
import tierramediatours2.LeeUsuarios;

public class TMApp {

	public static void main(String[] args) throws IOException, SQLException {

		UsuariosDAO usuariosDAO = new UsuariosDAO();

		for (LeeUsuarios leeUsuarios : usuariosDAO.findAll()) {
			LeeUsuarios.darBienvenida(leeUsuarios);

			//LeePromociones.ofrecePromociones(leeUsuarios.getId_tipo_atraccion(), leeUsuarios);

			LeeAtracciones.ofreceAtraccciones(leeUsuarios.getId_tipo_atraccion(), leeUsuarios);

		}

	}

}
