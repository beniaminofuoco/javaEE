package demo.javaee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Terzo esempio uso il Request Dispatcher, che è molto simile al Redirect
		// Ma non cambia il path della URL e passa gli stessi valori di request e
		// response all'altra Servlet
		request.getRequestDispatcher("SecondServlet").forward(request, response);

		// Secondo esempio effettuo un Redirect sulla seconda Servlet
		// response.sendRedirect("SecondServlet");

		// Primo esempio -> in cui scrivo il QueryString e il parametro in pagina
		// response.setContentType("text/plain");
		// response.getWriter().write("QueryString = "+ request.getQueryString()+"\n");
		// response.getWriter().write("Param username = "+
		// request.getParameter("username")+"\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().write("QueryString = " + request.getQueryString() + "\n");
		response.getWriter().write("Param username = " + request.getParameter("username") + "\n");
	}

}
