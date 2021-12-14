package controller.itineraries;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerary;
import services.ItineraryService;

@WebServlet("/itineraries/index.do")
public class ListItinerariesServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1323836674941613316L;
	private ItineraryService itineraryService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itineraryService = new ItineraryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Itinerary> itineraries = itineraryService.list();
		req.setAttribute("itineraries", itineraries);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/itineraries/index.jsp");
		dispatcher.forward(req, resp);

	}

}