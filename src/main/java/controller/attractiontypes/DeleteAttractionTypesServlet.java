package controller.attractiontypes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;
import services.AttractionTypesService;

@WebServlet("/attraction-types/delete.do")
public class DeleteAttractionTypesServlet extends HttpServlet {

	private static final long serialVersionUID = 3107356901998409956L;
	private AttractionTypesService attractionTypesService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionTypesService = new AttractionTypesService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		attractionTypesService.delete(id);

		resp.sendRedirect("/TierraMedia3/attraction-types/index.do");
	}

}
