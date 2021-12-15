package controller.users;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;

@WebServlet("/users/create.do")
public class CreateUserServlet extends HttpServlet {
	

	private static final long serialVersionUID = 6770857886710948270L;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		Integer money = Integer.parseInt(req.getParameter("money"));
		Double time = Double.parseDouble(req.getParameter("time"));
		Integer preferences = Integer.parseInt(req.getParameter("preferences"));
		String preferencetype = req.getParameter(req.getParameter("preferencetype"));
		Boolean isActive = Boolean.parseBoolean(req.getParameter("true"));
		User tmp_user = userService.create(username, password, admin, money, time, preferences, preferencetype, isActive);
		if (tmp_user.isValid()) {
			resp.sendRedirect("/TierraMedia3/users/index.do");
		} else {
			req.setAttribute("tmp_user", tmp_user);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/create.jsp");
			dispatcher.forward(req, resp);
		}
	}

}