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


@WebServlet("/attraction-types/edit.do")
public class EditAttractionTypesServlet extends HttpServlet {


	private static final long serialVersionUID = -5367394437291458523L;
private AttractionTypesService attractionTypesService;

 @Override
 public void init() throws ServletException {
  super.init();
  this.attractionTypesService = new AttractionTypesService();
 }

 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Integer id = Integer.parseInt(req.getParameter("id"));

  AttractionTypes attractionTypes = attractionTypesService.find(id);
  req.setAttribute("attractionTypes", attractionTypes);

  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attraction-types/edit.jsp");
  dispatcher.forward(req, resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Integer id = Integer.parseInt(req.getParameter("id"));
  String type = req.getParameter("type");
  Boolean isActive = Boolean.parseBoolean("isActive");

  AttractionTypes attractionTypes = attractionTypesService.update(id, type, isActive);

   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attraction-types/edit.jsp");
   dispatcher.forward(req, resp);
  }
 }
