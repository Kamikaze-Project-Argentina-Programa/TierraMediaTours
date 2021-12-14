package controller.itineraries;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.Itinerary;
import model.Promotion;
import model.User;
import persistence.commons.DAOFactory;

import services.CreateItineraryService;

@WebServlet("/itineraries/create.do")
public class CreateItineraryServlet extends HttpServlet {

	
	private static final long serialVersionUID = 6918456241178351968L;
	private CreateItineraryService createItineraryService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.createItineraryService = new CreateItineraryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Attraction attraction = (Attraction) req.getSession().getAttribute("id");
		User user = (User) req.getSession().getAttribute("user");
		Itinerary itinerary = (Itinerary) req.getSession().getAttribute("id");
		Promotion promotion = (Promotion) req.getSession().getAttribute("id");
		createItineraryService.list(itinerary, user, attraction, promotion);

		Itinerary itinerary2 = DAOFactory.getItineraryDAO().find(itinerary.getId());
		req.getSession().setAttribute("itinerary", itinerary2);

	

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/attractions/index.do");
		dispatcher.forward(req, resp);
	}
}