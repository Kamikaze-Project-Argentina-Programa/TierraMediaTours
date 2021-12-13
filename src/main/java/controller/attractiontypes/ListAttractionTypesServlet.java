package controller.attractiontypes;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AttractionTypes;
import services.AttractionTypesService;

@WebServlet("/attraction-types/index.do")
public class ListAttractionTypesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3482610655624083221L;
	private AttractionTypesService attractionTypesService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionTypesService = new AttractionTypesService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AttractionTypes> attractionTypes = attractionTypesService.list();
		req.setAttribute("attractionTypes", attractionTypes);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attraction-types/index.jsp");
		dispatcher.forward(req, resp);

	}

}