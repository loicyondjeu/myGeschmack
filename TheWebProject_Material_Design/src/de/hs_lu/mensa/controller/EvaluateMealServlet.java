package de.hs_lu.mensa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;

import de.hs_lu.mensa.model.Meal;

/**
 * Servlet implementation class EvaluateMealServlet
 */
@WebServlet("/evaluateMeal")
public class EvaluateMealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ObjectId meal_id = new ObjectId(request.getParameter("meal"));
		String evaltype = request.getParameter("evaltype");
		
		if(evaltype != null){
			Meal meal = new Meal();
			meal.setMeal_id(meal_id);
			
			meal.mongoReadById();
			
			HttpSession session = request.getSession();
			session.setAttribute("toEvaluateMeal", meal);
			
			if(evaltype.equals("normal")){
				response.sendRedirect("jsp/evaluateMeal.jsp");
			}else if(evaltype.equals("quick")){
				response.sendRedirect("jsp/quickEvaluateMeal.jsp");
			}else{
				
			}
			
		}
		
	}

}