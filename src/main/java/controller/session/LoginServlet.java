package controller.session;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promotion;
import model.User;
import services.LoginService;
import services.PromotionService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginService loginService;
	private PromotionService promotionService;
	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		this.promotionService = new PromotionService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		List<Promotion> promotions = promotionService.list();
		User user = loginService.login(username, password);

		if (!user.isNull()) {
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("promotions", promotions);
			resp.sendRedirect("index.jsp");
		} else {
			req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}