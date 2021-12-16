package controller.attractiontypes;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AttractionTypes;
import services.AttractionTypesService;

@WebServlet("/attraction-types/create.do")
public class CreateAttractionTypesServlet extends HttpServlet {

	private static final long serialVersionUID = 5308721891792963867L;
	private AttractionTypesService attractionTypesService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionTypesService = new AttractionTypesService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attraction-types/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Boolean isActive = Boolean.parseBoolean("true");

		AttractionTypes attractionTypes = attractionTypesService.create(type, isActive);
		req.setAttribute("attractionTypes", attractionTypes);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attraction-typess/create.jsp");
		dispatcher.forward(req, resp);

	}

}