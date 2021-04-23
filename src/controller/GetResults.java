package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Caucus;

/**
 * Servlet implementation class GetResults
 */
@WebServlet("/GetResults")
public class GetResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetResults() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Caucus caucus = CaucusUtil.getCaucusFromHttpRequest(request);
		request.setAttribute("caucus", caucus);
		getServletContext().getRequestDispatcher("/results.jsp").forward(request, response);
	}
}
